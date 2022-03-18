import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment1 extends JFrame implements ActionListener {

  private JTextField jtfBinary, jtfDecimal;
  private JButton jbtConvert = new JButton("Convert To Decimal");

  private JTextField jtfHex, jtfHexToDecimal;
  private JButton jbtConvertHex = new JButton("Convert To Decimal");

  public static void main(String[] args) {
    Lab frame = new Lab();
    frame.pack(); 
    frame.setTitle("Lab: Exception Handling");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Lab() {

    // Panel p to hold index and element of the array
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(5, 2));
    p.add(new Label("Binary String"));
    p.add(jtfBinary = new JTextField(10));
    p.add(new Label("Decimal String"));
    p.add(jtfDecimal = new JTextField(30));
    jtfDecimal.setEditable(false);
    p.add (jbtConvert);
    p.add(new Label("  "));
    p.add(new Label("  "));

    // Panel p to hold index and element of the array
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(3, 2)); 
    p1.add(new Label("Hexadecimal String"));
    p1.add(jtfHex = new JTextField(10));
    p1.add(new Label("Decimal String"));
    p1.add(jtfHexToDecimal = new JTextField(30));
    jtfHexToDecimal.setEditable(false);
    p1.add (jbtConvertHex);

    // Add p and the button to the frame
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(p1, BorderLayout.SOUTH);

 
    // Register listener
    jbtConvert.addActionListener(this);
    jbtConvertHex.addActionListener(this);
  }

  // Handle ActionEvent
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtConvert) {
      try {
		String decimal = parseBinary(jtfBinary.getText());
            jtfDecimal.setText(decimal);
      }
      catch (NumberFormatException ex) {
        	jtfDecimal.setText("Invalid Format for a Binary String - " + ex.getMessage());
      }
    }
  }

  public static String parseBinary(String binaryString) {
    int value = 0;

    for (int i = 0; i < binaryString.length(); i++) {
      char ch = binaryString.charAt(i);
      if (ch == '0' || ch == '1')
        value = value * 2 + binaryString.charAt(i) - '0';
      else
        throw new NumberFormatException("Illegal character: " + ch);
    }

    return Integer.toString(value);
  }


}


  
