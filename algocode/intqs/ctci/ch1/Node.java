/*
 * Decompiled with CFR 0_125.
 */
class Node {
    String key;
    String value;
    Node next;

    public Node() {
    }

    public Node(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public String toString() {
        return this.key + " -> " + this.value;
    }

    public boolean equals(Node node) {
        return this.key.equals(node.key) && this.value.equals(node.value);
    }

    public int hashCode() {
        int n = this.key.hashCode();
        n = 31 * n;
        return n;
    }
}
