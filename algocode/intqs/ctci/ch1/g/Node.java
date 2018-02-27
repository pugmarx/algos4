class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;

    public Node() {
    }

    public Node(K k, V v) {
        this.key   = k;
        this.value = v;
    }

    public String toString() {
        return(this.key + " -> " + this.value);
    }

    public boolean equals(Node node) {
        return(this.key.equals(node.key) && this.value.equals(node.value));
    }

    public int hashCode() {
        int n = this.key.hashCode();
	    n = 31 * n;
        return(n);
    }
}
