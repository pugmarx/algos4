
public class DepthFirstSearch{
	private int count;	//keeps a track of # of vertices visited. useful in checking if the graph is connected
						// by comparing it with V	
	private boolean[] marked;
	
	public DepthFirstSearch(Graph G, int s){ // s is source
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	public int count(){return count;}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		System.out.println(v); // simulation of visit(v);	
		for(int w : G.adj(v)){ //get the adjacency list for this particular vertex
			if(!marked[w]){ // visit only if not visited earlier
				dfs(G,w);
			}
		}
	}
}
