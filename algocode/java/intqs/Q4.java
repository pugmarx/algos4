import java.util.Arrays;



/**
Q4 from IvewCake.
Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.

For example, given:

  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

your method would return:

  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]

Time complexity: O(n.lg n) (Initial sorting + single iteration)
Space: O(n) (another array)

*/
class Q4Brute{

	public static void main(String s[]) throws Exception{

		Meeting m1 = new Meeting(5,7);
		Meeting	m2 = new Meeting(3,6);
		Meeting m3 = new Meeting(1,2);
		Meeting m0 = new Meeting(0,1);
//		Meeting m3 = new Meeting(1,5);
//		Meeting m4 = new Meeting(2,3);		

		Meeting[] mArr = new Meeting[]{m1, m2, m3, m0};
//  [Meeting(1, 10), Meeting(2, 6), Meeting(3, 5), Meeting(7, 9)]
	
		Meeting m7 = new Meeting(1,10);
		Meeting m8 = new Meeting(2,6);
		Meeting m9 = new Meeting(3,5);
		Meeting m10 = new Meeting(7,9);


//		Meeting[] mArr = new Meeting[]{m4, m3};
//		Meeting[] mArr = new Meeting[]{m7, m8, m9, m10};

		Arrays.sort(mArr);


		for(Meeting m : mArr){
			System.out.print(m);		
		}
		System.out.println();

		Meeting[] merged = mergeMeetings(mArr);

		for(Meeting m : merged){
			if(m != null)
			System.out.print(m);		
		}
		System.out.println();
	}

	private static Meeting[] mergeMeetings(Meeting[] m){
		
		Meeting[] merged = new Meeting[m.length];
		int size = 0;
		// initialize the merged array with the first element
		merged[size++] = m[0];

		for(int i=1;i<m.length;){

			if(((merged[size-1].getStartTime() <= m[i].getStartTime()) && (merged[size-1].getEndTime() >= m[i].getEndTime()) )){
				i++;
			}else if(((merged[size-1].getEndTime() >= m[i].getStartTime()) && (merged[size-1].getEndTime() < m[i].getEndTime()))){
				// update the end time
				merged[size-1].setEndTime(m[i].getEndTime());
				i++;
			}else{
				// add new element to merged array
				merged[size++]=m[i];
			}
		}
		 return merged;
	}








// Broken!! Merges only in pairs! Also, skips the last entry	
	private static Meeting[] mergeMeetingsBroken(Meeting[] m){

		Meeting[] merged = new Meeting[m.length];
		int size = 0;
		for(int i=0;i<m.length-1;){
			//if((m[i].getEndTime() >= m[i+1].getStartTime()) && (m[i].getEndTime() < m[i+1].getEndTime())){
			if(((m[i].getEndTime() >= m[i+1].getStartTime()) && (m[i].getEndTime() < m[i+1].getEndTime())) || ((m[i].getStartTime() <= m[i+1].getStartTime()) && (m[i].getEndTime() >= m[i+1].getEndTime()) ) ){
				//merge
				Meeting mnew = new Meeting(m[i].getStartTime(), m[i+1].getEndTime());
				merged[size++] = mnew;
				i+=2;
			}else{
				merged[size++] = m[i++];
			}
		}		
		//for(Meeting m: merged){
	//		System.out.print(m);
	//	}
		return merged;
	}

}
class Meeting implements Comparable<Meeting>{

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

	public int compareTo(Meeting other){
		if(startTime == other.getStartTime()){
			return endTime > other.getEndTime()?1:-1;
		}
		return startTime > other.getStartTime()? 1:-1;
	}
	public String toString(){
		return "Meeting("+startTime+", "+endTime+") ";
	}
}

