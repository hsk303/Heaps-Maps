import java.util.LinkedList;
public class HashMap{
    private class Node{
      Integer key=null;
      Integer value=null;

      Node(Integer key, Integer value){
           this.key=key;
           this.value=value;
      }
    }

    private LinkedList<Node>[]Buckets;
    private int bucketLength=0;
    private int totalNoOfNodes=0;

    public void initialise(int size){
        bucketLength=size;
        Buckets= new LinkedList[size];
        for(int i=0;i<size;i++){
            Buckets[i]= new LinkedList<Node>();
        }
        totalNoOfNodes=0;
    }

    public void rehash(){
      LinkedList<Node>[]temp= this.Buckets;
       initialise((int)(this.bucketLength*2));
       for(int i=0;i<temp.length;i++){
           LinkedList<Node>group= temp[i];
           int size=group.size();
           while(size-->0){
               Node node= group.removeFirst();
               put(node.key, node.value);
           }
       }
    }
    
    public int size(){
      return this.bucketLength;
    }

    public boolean isEmpty(){
        return this.bucketLength==0;
    }

    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        int temp= totalNoOfNodes;
        sb.append("[");
        for(int i=0;i<bucketLength;i++){
            LinkedList<Node>group= Buckets[i];
            int size=group.size();
            while(size-->0){
                 Node node= group.getFirst();
                 sb.append("("+node.key+"="+node.value+")");
                 group.addLast(node);
                 temp--;
                 if(temp!=0){
                     sb.append(",");
                 }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void put(Integer key, Integer value){
        boolean res= containsKey(key);
        LinkedList<Node>group= getgroup(key);
        if(res){
            group.getFirst().value=value;
        }else{
             Node node= new Node(key, value);
             group.addLast(node);
             totalNoOfNodes++;
             double lambda= group.size() / 1* bucketLength;
             if(lambda>0.4){
                 rehash();
             }
        }
    }

    public void putIfAbsent(Integer key, Integer defaultvalue){
        boolean res= containsKey(key);
        LinkedList<Node>group= getgroup(key);
        if(!res){
            Node node= new Node(key, defaultvalue);
            group.addLast(node);
            totalNoOfNodes++;
        }
    }

    public Integer get(Integer key){
      boolean res= containsKey(key);
      LinkedList<Node>group= getgroup(key);
      return res ? group.removeFirst().value : null;
    }

    public Integer getOrDefault(Integer key, int defaultValue){
        Integer val=get(key);
        return val!=null ? val : null;
    }

    public Integer remove(Integer key){
     boolean res= containsKey(key);
     LinkedList<Node>group= getgroup(key);
     if(res){
         totalNoOfNodes--;
        return group.removeFirst().value;
     }
     
     return null;
    }

    public boolean containsKey(Integer key){
        LinkedList<Node>group= getgroup(key);
        int gs= group.size();
        boolean res= false;
        while(gs-->0){
            if(group.removeFirst().key.equals(key)){
                res=true;
                break;
            }else{
                group.addLast(group.removeFirst());
            }
        }
        return res;
    }

    public  LinkedList<Node> getgroup(Integer key){
        int hc= getHashCode(key);
        return Buckets[hc];
    }

    public int getHashCode(Integer key){
        return Math.abs((key.hashCode()) % bucketLength);
    }
}