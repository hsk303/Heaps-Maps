import java.util.*;
public class questions {
    public static int KthLargest(int[]arr, int k){
        PriorityQueue<Integer>pq= new PriorityQueue<>();
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k)
               pq.remove();
        }
        return pq.peek();
    }

    public static int KthSmallest(int[]arr, int k){
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k)
               pq.remove();
        }
        return pq.peek();
    }

    public static void printKSortedArrays(int[][]arr){
        int n= arr.length;
        int m= arr[0].length;
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->{
         int r1= a/m, c1=a%m, r2=b/m, c2=b/m;
         return arr[r1][c1]-arr[r2][c2];
        });

        for(int i=0;i<n;i++){
            pq.add(i*m+0);

        }

        int[]ans= new int[n*m];
        int idx=0;
        while(pq.size()!=0){
            Integer index= pq.remove();
            int r= index/m;
            int c=index%m;
            ans[idx++]=arr[r][c];
            c++;
            if(c<m)
               pq.add(r*m+c);
        }
        for(int ele:ans){
            System.out.print(ele);
        }
    }
}
