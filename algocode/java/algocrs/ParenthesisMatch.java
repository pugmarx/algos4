import java.util.Scanner;


public class ParenthesisMatch {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

//	while(sc.hasNext()){

        String word = sc.next();

        char[] warr = word.toCharArray();

        ArrayFCStack <Character> stack = new ArrayFCStack <>(10);
        boolean valid = true;

//		while(valid){
        for (char c : warr) {
            if (valid) {
                switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    //stack.print();
                    break;

                case '}':
                    if (stack.pop() != '{') {
                        valid = false;
                    }
                    break;

                case ']':
                    if (stack.pop() != '[') {
                        valid = false;
                    }
                    break;

                case ')':
                    if (stack.pop() != '(') {
                        valid = false;
                    }
                    break;

                default:
                    System.out.println("shouldnt be here");
                    break;
                }
            }
        }
//		}
        boolean output = valid && stack.isEmpty();
        System.out.println(output);

//	}
    }
}
