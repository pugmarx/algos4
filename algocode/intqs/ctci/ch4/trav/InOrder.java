public class InOrder implements Traversal{

	public void traverse(BSTTrav.Node n){
		if(n == null) return;

		traverse(n.left);
		System.out.println(n);
		traverse(n.right);
		
	}

}
