import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n,Collections.reverseOrder());
        
        int e;//=Integer.parseInt(br.readLine());
        //System.out.format("%.2f\n", e*1.0f);
        minHeap.add(Integer.MAX_VALUE);
        maxHeap.add(Integer.MIN_VALUE);
        DecimalFormat df = new DecimalFormat("#.0"); 
        while(--n>=0){
            e=Integer.parseInt(br.readLine());
            if(e<maxHeap.peek())
                maxHeap.add(e);
            else
                minHeap.add(e);
            
            //System.out.println(minHeap.toString());
            //System.out.println(maxHeap.toString());
            
            int minSize=minHeap.size();
            int maxSize=maxHeap.size();
            
            //System.out.println("minSize="+minSize);
            //System.out.println("maxSize="+maxSize);
            
            if(minSize> maxSize+1){
                maxHeap.add(minHeap.poll());
                minSize--;
                maxSize++;
            }
            else if(maxSize>minSize+1){
                minHeap.add(maxHeap.poll());
                minSize++;
                maxSize--;
            }
            
            //System.out.println("minSize="+minSize);
            //System.out.println("maxSize="+maxSize);
            if(maxSize==minSize)
//                System.out.format("%.2f\n", (minHeap.peek()+maxHeap.peek())/2.0f);
                System.out.println(df.format((minHeap.peek()+maxHeap.peek())/2.0f));
            else if(maxSize>minSize)
//                System.out.format("%.2f\n", maxHeap.peek()*1.0f);
                System.out.println(df.format(maxHeap.peek()*1.0f));
            else
//                System.out.format("%.2f\n", minHeap.peek()*1.0f);
                System.out.println(df.format(minHeap.peek()*1.0f));
        }
    }

}