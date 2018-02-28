public class BST<Key extends Comparable<Key>, Value>{

	private Node root;

	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int N; // count of all subtree nodes
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node n){
		return n==null?0:n.N;
	}

	public Value get(Key key){
		
		return get(root, key);
		
	}	

	private Value get(Node n, Key key){
		if(n == null) return null;

		int cmp = key.compareTo(n.key);

		if(cmp < 0){
			return get(n.left, key);
		}else if(cmp > 0){
			return get(n.right, key);
		}
		return n.val;
	}
	
	public void put(Key key, Value val){
		root =  put(root, key, val);
	}
	
	private Node put(Node n, Key key, Value val){
		
		if(n == null) return new Node(key, val, 1);
		int cmp = key.compareTo(n.key);

		if(cmp < 0) n.left = put(n.left, key, val);
		else if(cmp > 0) n.right = put(n.right, key, val);
		else n.val = val;

		n.N = size(n.left) + size(n.right) + 1;
		return n;
	}
	
}
