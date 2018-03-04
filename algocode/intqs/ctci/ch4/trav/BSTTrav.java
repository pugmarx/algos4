
/**
Basic BST impl. from Sedgewick et. al.
**/
public class BSTTrav<Key extends Comparable<Key>, Value>{

	private Node root;
	private Traversal traversal;

	public void setTraversal(Traversal trav){
		traversal = trav;
	}

	class Node{
		private Key key;
		private Value val;
		Node left, right;
		private int N; // count of all subtree nodes
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
		public String toString(){
			return ""+key;
//			System.out.println(key);
//			if(left != null){
//				System.out.print(" / ");
//			}
//			if(right != null){
//				System.out.print(" \\ ");
//			}
			//System.out.println();
//			return "";
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

	public void print(){
	//	print(root);
		traversal.traverse(root);
	}

	String tab = "\t";
	private void print(Node n){
		if (n == null) return;

//		tab += "\t";
		System.out.println(n);
		if(n.left != null){
			print(n.left);
		}
		if(n.right != null){
			print(n.right);
		}
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

	public static void main(String a[]){
		BSTTrav<String, String> bst = new BSTTrav<String, String>();
		bst.put("d","hello");
		bst.put("b","world");
		bst.put("e","foo");
		bst.put("a","bar");

		bst.setTraversal(new InOrder());		
		bst.print();
		System.out.println("___");
		bst.setTraversal(new PreOrder());		
		bst.print();		
		System.out.println("___");
		bst.setTraversal(new PostOrder());		
		bst.print();		
		System.out.println("___");
		System.out.println("size: "+bst.size());
		System.out.println(bst.get("c"));		
	}
	
}
