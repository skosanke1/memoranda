package p12;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author Steven Kosanke, skosanke
 * @version 2/25/2022
 */
public class KosankeMain {
	BufferedReader indexReader;
    
    /**
     * Entry point for testing.
     * @param args the command line arguments
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        int V=997; //Size of hash table
    	BetterDiGraph DG = new BetterDiGraph(V);
    	LinkedList<String>[] symbol = (LinkedList<String>[]) new LinkedList[V]; //hash table
        

        try {
        	Integer subA; int x; String line;
			BufferedReader indexReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
			System.out.println("Original:"); 
			while (((line = new String(indexReader.readLine())) != null)) {

				if (line.contains("#")==false) { //Discard comment lines
					x = line.indexOf("\t");
					subA = Integer.valueOf(line.substring(0, x));
					int hashA = (subA.hashCode() & 0x7fffffff) % DG.V(); //Hash the int value 				
					
					byte[] japByte = line.substring(x+1).getBytes();
					String japChar = new String(japByte, StandardCharsets.UTF_8);
					System.out.print(japChar);
					DG.addVertex(subA);
					
					if (symbol[hashA] == null) { //HASH FUNCTION
						symbol[hashA] = new LinkedList<String>(); 
						symbol[hashA].add(japChar);	
					}
					else { //Linear Probing
						int b=0;
						while (symbol[hashA+b] != null) {
							b++;
						}
						symbol[hashA+b] = new LinkedList<String>(); 
						symbol[hashA+b].add(japChar);	
					}					
				}	
			}
			
		} catch (UnsupportedEncodingException | NullPointerException |FileNotFoundException e) {
			//Ignore exceptions	
        }
        finally {
        	if (DG.numV()<=0 ) {
        		System.out.println("Error reading file data-kanji.txt");
        	}
        	System.out.println();}
        
             
      //Add edges to the graph data-components.txt
        try {
        	String line; int x, subC, subD;
			BufferedReader indexReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("data-components.txt"))));
			while ((line = new String(indexReader.readLine())) != null) {
				
				if (line.contains("#")==false) {
					x = line.indexOf("\t");
					subC = Integer.valueOf(line.substring(0, x));
					subD = Integer.valueOf(line.substring(x+1));
					DG.addEdge(subC, subD);
				}
				
			}
		} catch (UnsupportedEncodingException| NullPointerException | FileNotFoundException e) {
			//Ignore exceptions		
        }
        finally {
        	if (DG.getEdgeCount() <= 0 ) {
        		System.out.println("Error reading file data-components.txt");
        	}
        }
        
        
        
        //Create an IntuitiveTopological object, and use it to sort the graph.
        IntuitiveTopological IT = new IntuitiveTopological(DG);        
       
        if (IT.isDAG() == true) { //Verify that DG can be ordered before sorting
        	Iterable<Integer> orderedSym = IT.order(); 
        	System.out.println("Sorted:");
        	for (Integer sym : orderedSym) {
        		System.out.print(symbol[((sym.hashCode() & 0x7fffffff) % DG.V())].get(0)); //Look up character stored in hashTable
            }

        	System.out.println();
        }
    	else {
    		System.out.println("Sorted could not be achieved, graph is not a DAG");
    	}
        
		}//end main[]
   
    }
