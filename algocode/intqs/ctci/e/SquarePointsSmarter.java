import java.util.*;


/**
	Makes use of the property that in hyp ^ 2 = a ^ 2 + b ^ 2
	* Pick any point randomly
	* Checks its distance from all other points
	* Max distance sq should be 2 * smaller distance sq
	* Distance from the other two points should be the same
*/

public class SquarePointsSmarter {
    public static void main(String s[]) {
        Scanner scan = new Scanner(System.in);

        Point[] p = new Point[4];

        // accept 4 sets of points
        for (int i = 0; i < 4; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            p[i] = new Point(x, y);
        }
		
		int d1 = getSqDist(p[0],p[1]);
		int d2 = getSqDist(p[0],p[2]);
		int d3 = getSqDist(p[0],p[3]);

		if(d1 == d2 && d3 == 2*d1){
			int da = getSqDist(p[2],p[3]);
			int db = getSqDist(p[1],p[3]);
			if(da == db && da == d1)
				quit("Y");	
		} 

			
		if(d3 == d2 && d1 == 2*d3){
			int da = getSqDist(p[2],p[1]);
			int db = getSqDist(p[1],p[3]);
			if(da == db && da == d3)
				quit("Y");	
		} 

		if(d1 == d3 && d2 == 2*d1){
			int da = getSqDist(p[2],p[3]);
			int db = getSqDist(p[1],p[2]);
			if(da == db && da == d1)
				quit("Y");	
		} 
		quit("N");
    }

    public static void quit(String s) {
        System.out.println(s);
        System.exit(0);
    }

	public static int getSqDist(Point a, Point b){
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isFCEqual(Point o) {
        return(this.x == o.x);
    }

    public boolean isSCEqual(Point o) {
        return(this.y == o.y);
    }
}
