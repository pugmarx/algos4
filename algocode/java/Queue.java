
public class Queue{

	LinkedList l = new LinkedList();

	public Queue(){
		l = new LinkedList();
	}

	public void enqueue(String item){
		if(l.isEmpty()){
			l.add(item);
			return;
		}
		l.add(item);
	}

	public String dequeue(){
		if(l.isEmpty()){
			return null;
		}
		return (String)l.remove(l.size()-1);
	}


	public boolean isEmpty(){
		return l.isEmpty();
	}

	public void print(){
		l.traverse();
	}

	public int size(){
		return l.size();
	}

	public static void main(String a[]) throws Exception{
		Queue q = new Queue();
		q.enqueue("a");
		System.out.println(q.size());
		q.enqueue("b");
		System.out.println(q.size());
		q.enqueue("c");
		System.out.println(q.size());
		q.enqueue("c");
		System.out.println(q.size());
		q.print();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
