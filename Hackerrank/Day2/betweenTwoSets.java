import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static boolean check_b(int n,int val,List<Integer> a)
    {
        for(int i=0;i<n;i++)
        {
            if(a.get(i)%val!=0)
            return false;
        }
        return true;
    }
   public static  boolean check_a(int n,int val,List<Integer> a)
    {
        for(int i=0;i<n;i++)
        {
            if(val%a.get(i)!=0)
            return false;
        }
        return true;
    }   
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    int max_a=-1,min_b=-1;
    int n=a.size();
    int m=b.size();
    for(int i=0;i<n;i++)
    {
       
        if(max_a<a.get(i))
        max_a=a.get(i);
    }
    for(int i=0;i<m;i++)
    {
        if(min_b<b.get(i))
        min_b=b.get(i);
    
    }
    int count=0;
    for(int i=max_a;i<=min_b;i++)
    {
        if(check_a(n,i,a) && check_b(m,i,b))
        count++;
    }
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
