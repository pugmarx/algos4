public class UtilMethods{
	private static final boolean DEBUG = false;
	public static boolean isPrime(int N){
		
		if(N<2) return false;
		for(int i=2;i*i < N; i++){
			
			if(DEBUG){
				System.out.println(i);
			}
			
			if(N%i==0) return false;
		}
		return true;
	}


	public static void main(String a[]){
		
		System.out.println(UtilMethods.isPrime(31));
		System.out.println(UtilMethods.isPrime(171));
	
	}

}
