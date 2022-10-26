import java.util.Comparator;
import java.util.PriorityQueue;


public class Cache {
    private int capacity;
    private int size=0;
    private int pageFault;

    public int getPageFault() {
        return pageFault;
    }

    private int[] vals;
    private int[] nextInds;


    public Cache(int capacity) {
        this.capacity = capacity;
        this.vals = new int[capacity];
        this.nextInds = new int[capacity];
        pageFault = 0;
    }

    public void push(Page p){
        p.removeIndex();
        if (isFull()){
            // contain or not
            if (this.contains(p)){
                // do nothing
            } else{
                // not contain
                int page = getFurthestValIndex();
                
                pageFault++;
                System.out.println("ififelse");
                vals[page] = p.getVal();
                if (p.getIndex() == null){
                    nextInds[page] = 2147483647;
                }
                else{
                    nextInds[page] = p.getIndex();
                }
            }
        } else{
            vals[size] = p.getVal();
            
            if (p.getIndex() == null){
                nextInds[size] = 2147483647;
            }
            else{
                nextInds[size] = p.getIndex();
            }
            nextInds[size] = p.getIndex();
            pageFault++;
            System.out.println("ifelse");
            this.increaseSize();
            
        }
        
        printPageFault(p);
    }


    // return index with furthest nextInd
    private int getFurthestValIndex(){
        int output = -1;
        for (int i = 0; i<size; i++){
            
            if (output < nextInds[i])
                output = i;
        }
        return output;
    }

   
    public boolean contains(Page p){
        for (int i: vals){
            if (i == p.getVal()){
                return true;
            }
        }
       
        return false;
    }

    public boolean isFull(){
        if (size < capacity){
            return false;
        }
        return true;
    }
    
    public void printPageFault(Page p){
        System.out.println("Page Fault Found! Value: " + p.getVal() + "! ");
    }

    // private String toString(PriorityQueue<Page> pages){
    //     String s = " Current Queue: [";
    //     for (Page p: pages){
    //        s+= p.getVal() + ":" + p.getIndex() + " ;";
    //     }
    //     s+="]";
    //     return s;
    // }

    private void increaseSize(){
        if (size < capacity)
            size++;
    }
}
