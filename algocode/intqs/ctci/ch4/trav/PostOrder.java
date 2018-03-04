public class PostOrder implements Traversal{

	public void traverse(BSTTrav.Node n){
		if(n == null) return;

		traverse(n.left);
		traverse(n.right);
		
		System.out.println(n);
	}

}
