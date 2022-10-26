import java.util.LinkedList;
import java.util.Queue;

public class Page {

    private int val;
    private Queue<Integer> index= new LinkedList<Integer>();
       

    Page(int val, int currentIndex){
        this.val = val;
        this.index = new LinkedList<>();
        index.add(currentIndex);
    }

    public int getVal() {
        return this.val;
    }

    public Integer getIndex() {
        return this.index.peek();
    }

    public void addIndex(int index) {
        this.index.add(index);
    }

    public Integer removeIndex() {
        return this.index.poll();
    }

    public boolean equals(Page p1){
        if (p1.getVal() == this.getVal())
            return true;
        return false;
    }

    public void printPage(){
        System.out.println("Page value: " + this.val + " , Page Index: " + this.index);
    }

}

    
