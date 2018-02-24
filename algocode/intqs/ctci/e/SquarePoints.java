import java.util.*;

public class SquarePoints {
    public static void main(String s[]) {
        Scanner scan = new Scanner(System.in);

        Point[] p = new Point[4];

        // accept 4 sets of points
        for (int i = 0; i < 4; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            p[i] = new Point(x, y);
        }

        if (p[0].isFCEqual(p[1])) {
            if (p[0].isSCEqual(p[1])) {
                quit("N");
            }
            int ydel = p[0].y - p[1].y;

            if (p[2].isFCEqual(p[3])) {
                if (p[2].isSCEqual(p[3])) {
                    quit("N");
                }

                if (Math.abs(p[2].y - p[3].y) == Math.abs(ydel)) {
                    quit("Y");
                }
            }
            quit("N");
        }

        if (p[0].isFCEqual(p[2])) {
            if (p[0].isSCEqual(p[2])) {
                quit("N");
            }
            int ydel = p[0].y - p[2].y;

            if (p[1].isFCEqual(p[3])) {
                if (p[1].isSCEqual(p[3])) {
                    quit("N");
                }

                if (Math.abs(p[1].y - p[3].y) == Math.abs(ydel)) {
                    quit("Y");
                }
            }
            quit("N");
        }

        if (p[0].isFCEqual(p[3])) {
            if (p[0].isSCEqual(p[3])) {
                quit("N");
            }
            int ydel = p[0].y - p[3].y;

            if (p[1].isFCEqual(p[2])) {
                if (p[1].isSCEqual(p[2])) {
                    quit("N");
                }

                if (Math.abs(p[1].y - p[2].y) == Math.abs(ydel)) {
                    quit("Y");
                }
            }
            quit("N");
        }

    }

    public static void quit(String s) {
        System.out.println(s);
        System.exit(0);
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

    public boolean isOnSameLine(Point o) {
        if (this.x == o.x) {
            if (this.y == o.y) {
                return(false);
            }
            return(true);
        }

        if (this.y == o.y) {
            if (this.x == o.x) {
                return(false);
            }
            return(true);
        }
        return(false);
    }
}
