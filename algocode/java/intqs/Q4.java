import java.util.Arrays;


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
		return "Meeting("+startTime+", "+endTime+")";
	}
}

class Q4Brute{

	public static void main(String s[]) throws Exception{

		Meeting m1 = new Meeting(5,7);
		Meeting	m2 = new Meeting(3,6);
		Meeting m3 = new Meeting(1,2);

		Meeting[] mArr = new Meeting[]{m1, m2, m3};

		Arrays.sort(mArr);

		for(Meeting m : mArr){
			System.out.print(m);		
		}
	}


}
