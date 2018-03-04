import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
/**
* Basic Graph impl. from Sedgewich et.al.
**/
public class Graph{
	
	private int V; // no. of vertices
	private int E; // no. of edges
	private ArrayList<Integer>[] adj;

	public Graph(int V){
		this.V = V;
		this.E = 0; // no edges initially!
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];

		for(int v=0; v< V; v++){
			adj[v] = new ArrayList<Integer>();
		}	
	}

	public int V(){return V;};
	public int E(){return E;};

	public Graph(Scanner sc){
		//Scanner sc = new Scanner(in);
		this(sc.nextInt());
		int E = sc.nextInt();

		for(int i=0;i<E;i++){
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v,w);
		}
	}

	public void addEdge(int v, int w){
		adj[v].add(w); // add w to v's list
		adj[w].add(v); // add v to w's list
		E++;
	}	

	public Iterable<Integer> adj(int v){
		return adj[v]; // return adj list for given vertex
	}

	public static void main(String a[]){
		Graph g = new Graph(new Scanner(System.in));
	}

}
