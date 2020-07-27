
import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opsLimit = in.nextInt();
        for (int i = 0; i < opsLimit; i++) {
            Stack<Character> stack1 = new Stack<>();
            boolean isNotOkay = false;
            String str = in.next();
            char[] chArr = str.toCharArray();
            for (int j = 0; j < chArr.length; j++) {
                if(stack1.isEmpty()  ){
                    if(chArr[j] == '}' || chArr[j] == ']' || chArr[j] == ')'){
                        isNotOkay = true;
                        break;
                    }else{
                        stack1.push(chArr[j]);
                    }
                        
                }else if(chArr[j] == '}' ){
                    isNotOkay = stack1.pop() != '{';
                }else{
                    if(chArr[j] == ']'){
                        isNotOkay = stack1.pop() != '[';
                    }else{
                        if( chArr[j] == ')'){
                            isNotOkay = stack1.pop() != '(';
                        }else{
                            stack1.push(chArr[j]);
                        }
                    }
                }
                if (isNotOkay) break;
                
            }
            if (isNotOkay || stack1.size() > 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

}