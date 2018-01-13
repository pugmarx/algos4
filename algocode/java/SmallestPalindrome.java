/**
Find next smallest palindrome greater than a number. e.g. 125 -> 131
*/

public class SmallestPalindrome{

	// accept a number
	// increment number by 1
	// iterate from beginning till the middle of the number
	// iterate from end till the middle of the number
	// if numbers are different, continue
	// else keep comparing numbers
	// if index becomes same, break -- this is the palindrome

	public static void main(String arg[]) throws Exception{

		boolean match = false;
		int NUM = -1;
		int N = Integer.valueOf(arg[0]);
		while(true){
			
			char[] nArr = (""+N).toCharArray();
			int L = nArr.length;

			for(int i=0;; i++){
				if(nArr[i]!=nArr[L-1-i]){
					break;
				}
				if(i==L/2){
					match = true;
					break;
				}
			}
			
			if(!match){
				N++;
//				System.out.println(N);
			}else{
				NUM = N;
				break;
			}	
		}
		System.out.println(NUM);
	}



}
