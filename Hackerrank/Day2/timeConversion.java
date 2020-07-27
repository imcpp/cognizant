import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         String result="";
         if(s.charAt(8)=='A' && Integer.parseInt(""+s.charAt(0)+s.charAt(1))!=12 ){
             return s.substring(0,8);
         }
          if(s.charAt(8)=='P' && Integer.parseInt(""+s.charAt(0)+s.charAt(1))==12 ){
             return s.substring(0,8);
         }
         int h=Integer.parseInt(""+s.charAt(0)+s.charAt(1));
         h+=12;
         if(h==24){
             h=0;
         }
         result+=h;
         if(h==0){
             result+=h;
         }
         result=result+s.substring(2,8);
         return result;


    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
