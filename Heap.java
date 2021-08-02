import java.util.ArrayList;
public class Heap {
    private ArrayList<Integer>arr;
    private int noOfElements;
    boolean isMaxHeap;

    public void initialise(boolean isMaxHeap){
        this.arr= new ArrayList<>();
        this.noOfElements=0;
        this.isMaxHeap=isMaxHeap;
    }
    
    Heap(){
        this(true);
    }

    Heap( boolean isMaxHeap){
       initialise(isMaxHeap);
    }

    Heap(int[]arr, boolean isMaxHeap){
        for(int ele:arr){
            this.arr.add(ele);
        }
        for(int i=noOfElements;i>=0;i--){
            downheapify(i);
        }
    }

    public int size(){
        return this.noOfElements;
    }

    public boolean isEmpty(){
        return this.noOfElements==0;
    }

    public void UnderflowPointerException() throws Exception{
        if(this.noOfElements==0)
           throw new Exception("HeapUnderflowException");
    }

    public int peek() throws Exception{
        UnderflowPointerException();
        return this.arr.get(0);
    }

    public int compareTo(int t, int o){
        if(isMaxHeap){
            return this.arr.get(t)-this.arr.get(o);
        }
        else{
            return this.arr.get(o)-this.arr.get(t);
        }
    } 

    private void swap(int i, int j){
        int el1= this.arr.get(i);
        int el2= this.arr.get(j);
        this.arr.set(i,el2);
        this.arr.set(j,el1);
    }
     
    private void downheapify(int pi){
        int midx=pi,lci=2*pi+1,rci=2*pi+2;
        if(lci<this.noOfElements && compareTo(lci,midx)>0)
           midx=lci;
        if(rci<this.noOfElements && compareTo(rci,midx)>0)
           midx=rci;
        if(midx!=pi){
            swap(midx,pi);
            downheapify(midx);
        }

    }

    public int remove() throws Exception{
       UnderflowPointerException();
       int rele= this.arr.get(0);
       swap(0,noOfElements-1);
       this.arr.remove(noOfElements-1);
       downheapify(0);
       return rele;

    }

    public void upheapify(int ci){
      int pi= (ci-1)/2;
      if(compareTo(ci,pi)>0){
          swap(ci,pi);
          upheapify(pi);
      }
    }

}
