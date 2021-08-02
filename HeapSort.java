public class HeapSort {

    public static int compareTo(int[]arr, int t, int o, boolean isIncreasing){
        if(isIncreasing)
          return arr[t]-arr[o];
        else
           return arr[o]-arr[t];
    }

    public static int swap(int i, int j){
        return i;
    }

    public static void  downheapify(int[]arr, int pi, int lidx,  boolean isIncreasing){
        int midx=pi,lci=2*pi+1,rci=2*pi+2;
        if(lci<=lidx && compareTo(arr,lci,midx, isIncreasing)>0)
            midx=lci;
        if(rci<=lidx && compareTo(arr,rci,midx, isIncreasing)>0)
          midx=rci;
        if(midx!=pi){
            arr[midx]=swap(arr[pi], arr[pi]=arr[midx]);
            downheapify(arr, midx, lidx, isIncreasing);
        }
    }

    public static void heapSort(int[]arr, boolean isIncreasing){
       int n= arr.length;
       int lidx=n-1;
       for(int i=lidx;i>=0;i--){
           downheapify(arr,i,lidx,isIncreasing);
       }
       while(lidx>=0){
           arr[lidx]=swap(arr[0],arr[0]=arr[lidx]);
           downheapify(arr, 0, --lidx, isIncreasing);
       }
    }
}
