import java.util.*;


class MyType implements Cloneable{
	String name;
	String val;

	public MyType(){}
	public MyType(String n, String v){
		name = n;
		val = v;
	}

	public void setName(String n){
		name = n;
	}

	public void setValue(String v){
		val = v;
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public String toString(){
		return name + " :: " + val;
	}
}


public class HashTest{

	public static void main(String a[]) throws Exception{

		Map<Integer, MyType> m = new HashMap<>();

		MyType t1 = new MyType("abra", "cadabra");

		m.put(1,t1);
		m.put(2, new MyType());

		System.out.println(m.get(1));		

		MyType t2 = t1;
		MyType t3 = (MyType)t2.clone();

//		t1 = null; 
		
//		System.out.println(m.get(1));		

		t1.setName("changedName");
		t1.setValue("changedVal");

		System.out.println(m.get(1));		

		System.out.println("t2:"+t2);
		
		System.out.println("t3:"+t3);
	}


}
