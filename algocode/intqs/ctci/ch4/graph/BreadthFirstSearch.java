import java.util.*;

public class BreadthFirstSearch{

	private boolean marked[];
	
	
	public BreadthFirstSearch(Graph G, int s){

		marked = new boolean[G.V()];
		
		bfs(G,s);
	}	

	private void bfs(Graph G, int s){

		Queue<Integer>  queue = new LinkedList<Integer>();
		marked[s] = true;

		queue.add(s);
		
		while(!queue.isEmpty()){
			int v = queue.remove();
			System.out.println(v); // visit(n)
			for(int w : G.adj(v)){
				
				if(!marked[w]){
					marked[w] = true;
					queue.add(w);	
				}
				
			}
		}
	}
}
