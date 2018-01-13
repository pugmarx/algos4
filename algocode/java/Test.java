public class Test{

	public static Runnable createNewRunnable(){
		return () -> System.out.println("Hello");
	}


	public static void main(String s[]) throws Exception{
		Runnable runnable = Test.createNewRunnable();
		runnable.run();
	}









}
