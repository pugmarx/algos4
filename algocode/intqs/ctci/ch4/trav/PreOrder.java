public class PreOrder implements Traversal{

	public void traverse(BSTTrav.Node n){
		if(n == null) return;

		System.out.println(n);
		traverse(n.left);
		traverse(n.right);
		
	}

}
