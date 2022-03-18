package p12;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class that implements EditableDiGraph for Project12.
 * 
 * @author Steven Kosanke, skosanke
 * @version 2/25/2022
 */
public class BetterDiGraph implements EditableDiGraph{
	private int V; //Graph max num V
	private int E; //Num edges
	private LinkedList<Integer>[] adj; //Edge list for graph
	private int numV; //Num vertecies in graph currently
	
	/**
	 * 
	 * @param V
	 */
	BetterDiGraph(int V) {
		this.V = V;
		this.E = 0;
		numV=0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
	}

	public int V() { return V;}
	public int E() {return E;}
	public int numV() { return numV;}
	
	public LinkedList<Integer> adj(int i) {
		return adj[i];
	}
	
    /**
     * Adds an edge between two vertices, v and w. If vertices do not exist,
     * adds them first.
     *
     * @param v source vertex
     * @param w destination vertex
     */
	@Override
	public void addEdge(int v, int w) {
		if (adj[v] != null) { } //
		else { this.addVertex(v); } //Create vertex v if does not exist
		if (adj[w] != null) { }// 
		else { this.addVertex(w); } //Create vertex w if does not exist
		
		int x = adj[v].indexOf(w); //return index of w, -1 if DNE
		if (x==-1) {
			adj[v].add(w);
			E++;
		}
	}
	
    /**
     * Adds a vertex to the graph. Does not allow duplicate vertices.
     *
     * @param v vertex number
     */
	@Override
	public void addVertex(int v) {
		if (adj[v] != null ) { } //Vertex exists, do not add
		else { 
			adj[v] = new LinkedList<Integer>(); 
			numV++;} //Initialize so adj[v].size() will read >=0
	}
	
	
    /**
     * Returns the direct successors of a vertex v.
     *
     * @param v vertex
     * @return successors of v
     */
	@Override
	public Iterable<Integer> getAdj(int v) {
		return adj[v];
	}
    
	
    /**
     * Number of edges.
     *
     * @return edge count
     */
	@Override
	public int getEdgeCount() {
		return this.E();
		}
	
	
    /**
     * Returns the in-degree of a vertex.
     * @param v vertex
     * @return in-degree. Returns -1 if vertex does not exist
     * @throws NoSuchElementException exception thrown if vertex does not exist.
     */
	@Override
	public int getIndegree(int v) throws NoSuchElementException {
		int count=-1; //Return -1 if vertex does not exist
		if (adj[v] != null) {
			count++;
				for (int i=0; i<V(); i++) {		
					if (adj[i] != null) {
						if (adj[i].indexOf(v) != -1) { 
							count++; }
					}	 
				}//end for loop
		}		
		return count;
	}
	
	
    /**
     * Returns number of vertices.
     * @return vertex count
     */
	@Override
	public int getVertexCount() {
		int count=0;
		for (int i=0; i<V(); i++) {
			if (adj[i] != null) {
				if (adj[i].size() >= 0) {
					count++;
				}
			}
			
		}
		return count;
	}
	
	
    /**
     * Removes edge from graph. If vertices do not exist, does not remove edge.
     *
     * @param v source vertex
     * @param w destination vertex
     */
	@Override
	public void removeEdge(int v, int w) {
		int x=-1;
		x = adj[v].indexOf(w); //return index of w, -1 if DNE
		if (x!=-1) {
			adj[v].remove(x);
			E--;
		}		
	}
	
	
    /**
     * Removes vertex from graph. If vertex does not exist, does not try to
     * remove it.
     *
     * @param v vertex
     */
	@Override
	public void removeVertex(int v) {
		if (adj[v] != null) { //Check if the vertex exist
			for (int i=0; i<V(); i++) {
				if (adj[i] != null) { //Check if an edge to v exist
					if (adj[i].contains(v) == true) {
						removeEdge(i,v); //Remove edges first
					}
				}
			} //end for
			adj[v] = null; //Remove vertex
			numV--;
		} //end if
	}
	
	
    /**
     * Returns iterable object containing all vertices in graph.
     *
     * @return iterable object of vertices
     */
	@Override
	public Iterable<Integer> vertices() {
		// TODO Auto-generated method stub
		LinkedList<Integer> v = new LinkedList<Integer>();
		for (int i = 0; i < V(); ++i) {
			if (adj[i] != null) {
				if (adj[i].size() != 0) {
					v.add(i);
				}			
			}//end if
		}
		
		return v;	
	} //end method

}
