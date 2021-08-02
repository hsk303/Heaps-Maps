import java.util.*;
public class HeapBasic {
    public static void Int_Min(){
        PriorityQueue<Integer>pq= new PriorityQueue<>();
        for(int i=10;i>=1;i--){
            pq.add(i*10);
        }
        while(pq.size()!=0){
            System.out.println(pq.remove());
        }
    }

    public static void Int_Max(){
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=10;i>=1;i--){
            pq.add(i*10);
        }
        while(pq.size()!=0){
            System.out.println(pq.remove());
        }
    }

    public static void MatrixPQ(){
        int[][] arr= {{2,6,11,3},{8,5,16,4},{9,7,11,13},{8,13,12,11}};

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int[]a: arr){
            pq.add(a);
        }
        while(pq.size()!=0){
            int[]a= pq.remove();
            for(int ele: a){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        MatrixPQ();
    }
}
