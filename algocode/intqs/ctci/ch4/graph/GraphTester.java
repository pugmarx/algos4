
public class GraphTester{


	public static void main(String a[]){

		Graph g = new Graph(9);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,6);
		g.addEdge(0,5);
		g.addEdge(3,5);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(4,6);
		g.addEdge(7,8);
	
		DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
		BreadthFirstSearch bfs = new BreadthFirstSearch(g,0);
//		if(dfs.count() != g.V()){
//			System.out.print("Not ");
//		}
//		System.out.println("Connected");

	}

}
