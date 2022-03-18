package p12;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Class that implements TopologicalSort for Project12.
 * 
 * @author Steven Kosanke, skosanke
 * @version 2/25/2022
 */
public class IntuitiveTopological implements TopologicalSort{
	BetterDiGraph DG;
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	
	
	/**
	 * CTOR for class, take in directed graph DG
	 * @param DG directed graph
	 */
	IntuitiveTopological(BetterDiGraph DG) { this.DG = DG; }
	
	/**
     * Returns an iterable object containing a topological sort.
     * @return a topological sort iterable for the DG
     */
	@Override
	public Iterable<Integer> order() {
		LinkedList<Integer> order = new LinkedList<Integer>();
		if (isDAG() == true) { //Checks for cycles
			int count = DG.numV();
			while (count > 0) { //generate topological sort
				for (int v = 0;  v < DG.V(); v++) {
					if (DG.getIndegree(v) ==0 ) {
						order.add(v);
						DG.removeVertex(v);
						count--;
					}	
				}
			}//End while
			return order;
		}
		else {
			System.out.println("Cycle found prior to sorting...Exiting.");
			return null;}

	}
    /**
     * Returns true if the graph being sorted is a DAG, false otherwise.
     * @return true if graph is DAG 
     */
	@Override
	public boolean isDAG() {
		onStack = new boolean[DG.V()];
		edgeTo = new int[DG.V()];
		marked = new boolean[DG.V()];
		for (int v = 0; v < DG.V(); v++) {
			if (!marked[v]) {
				if (dfs(DG, v) == false) { //Cycle detected
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Performs a depth first search on the graph, useb to verify no cycles in DiGraph
	 * 
	 * @param DG is DiGraph that is being tested
	 * @param v is the node that we start at
	 * @return true if there are no cycles detected in DG
	 */
	private boolean dfs(BetterDiGraph DG, int v) {
		if (DG.adj(v)== null) {
			return true;
		}
		onStack[v] = true;
		marked[v] = true;
		for (int w : DG.adj(v))
		if (this.hasCycle())
		return false;
		else if (!marked[w]) {
		edgeTo[w] = v; dfs(DG, w);
		}
		else if (onStack[w])
		{
		cycle = new Stack<Integer>();
		for (int x = v; x != w; x = edgeTo[x]) {
			cycle.push(x);
		}
		cycle.push(w);
		cycle.push(v);
		}
		onStack[v] = false;
		return true;
		}
		public boolean hasCycle() { return cycle != null; }
		public Iterable<Integer> cycle() { return cycle; }
	
	
    

}
