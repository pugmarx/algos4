/**
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
*/

/**
Needs 2N space and complexity is O(N^2)
*/
class Q2Brute{


	public static void main(String a[]){

		 //int[] arr = new int[]{1, 7, 3, 4};
		 int[] arr = new int[]{1, 0, 3, 4};

		getProductsOfAllIntsExceptAtIndex(arr);

	}

	private static void getProductsOfAllIntsExceptAtIndex(int[] a){

		int[] b = new int[a.length];
		for(int i=0;i<b.length;i++){
			b[i] = 1;
		}	
	
		for(int i=0;i<a.length;i++){
			
			for(int j=0; j<a.length; j++){
				
				if(i==j) continue;
				//if(b[i] == 0) b[i]=1;
				b[i] *= a[j];
				
			}

		}

		for(int i : b)
			System.out.print(i + "|");
		System.out.println();
	}



}
