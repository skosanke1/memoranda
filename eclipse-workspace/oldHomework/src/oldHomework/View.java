package oldHomework;
//**************************************************************************************************
// CLASS: View
//
// DESCRIPTION
// Implements the GUI for a calculator.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Implements the GUI for a calculator.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH  = 500;
    public static final int FRAME_HEIGHT = 200;

    private JTextField mText;

    /**
     * Default ctor. Does nothing.
     */
    public View() {
    	JPanel panelFunctButton = new JPanel();
    	panelFunctButton.setLayout(new GridLayout(2,2));
    	addButton(panelFunctButton, "x^y");
    	addButton(panelFunctButton, "log 10");
    	addButton(panelFunctButton, "log e");
    	addButton(panelFunctButton, "sqrt");

    	JPanel panelSysButton = new JPanel();
    	addButton(panelSysButton, "Clear");
    	addButton(panelSysButton, "About");
    	addButton(panelSysButton, "Exit");

        JPanel panelFunctSys = new JPanel();
        panelFunctSys.setLayout(new BorderLayout());
        panelFunctSys.add(panelFunctButton, BorderLayout.CENTER);
        panelFunctSys.add(panelSysButton, BorderLayout.SOUTH);
        
    	JPanel panelKeypad = new JPanel();
    	panelKeypad.setLayout(new GridLayout(4,4));
    	addButton(panelKeypad, "7");
    	addButton(panelKeypad, "8");
    	addButton(panelKeypad, "9");
    	addButton(panelKeypad, "/");
    	addButton(panelKeypad, "4");
    	addButton(panelKeypad, "5");
    	addButton(panelKeypad, "6");
    	addButton(panelKeypad, "*");
    	addButton(panelKeypad, "1");
    	addButton(panelKeypad, "2");
    	addButton(panelKeypad, "3");
    	addButton(panelKeypad, "-");
    	addButton(panelKeypad, "0");
    	addButton(panelKeypad, ".");
    	addButton(panelKeypad, "+/-");
    	addButton(panelKeypad, "+");
    	
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.LINE_AXIS));
        panelBottom.add(panelKeypad);
        Box.createRigidArea(new Dimension(10,0));
        panelBottom.add(panelFunctSys);
        JPanel panelTextField = new JPanel();
        JTextField mText = new JTextField(30);
        panelTextField.add(mText);
        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel("Kalkutron-9000");
        panelLabel.add(label);
        
        final JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(Box.createVerticalGlue());
        panelMain.add(panelLabel);
        panelMain.add(Box.createVerticalGlue());
        panelMain.add(panelTextField);
        panelMain.add(panelBottom);
        panelMain.add(Box.createVerticalGlue());              
        setTitle("Kalkutron-9000");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelMain);
        setVisible(true);
    }
    /**
     * Declare and create a JButton object displaying pText. Make this JFrame the action listener
     * for button events. Add the button to pPanel.
     */
    private void addButton(JPanel pPanel, String pText) {
        JButton button = new JButton(pText);
        button.addActionListener(this);
        pPanel.add(button);
    }
    /**
     * Implementation of the actionPerformed() method of the ActionListener interface.
     */
    @Override
    public void actionPerformed(ActionEvent pEvent) {
    	JButton button = (JButton)pEvent.getSource();
    	String buttonLabel = button.getText();
    	
    	if (buttonLabel.equals("About"))
    	{
    		JOptionPane.showMessageDialog(button, "Kalkutron-9000 Ver. 1 Steven Kosanke");
    	}
    	
    	if (buttonLabel.equals("Exit"))
    	{
    		System.exit(0);
    	}  
    }

}