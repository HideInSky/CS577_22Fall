import java.util.Comparator;

public class PageComparator implements Comparator<Page>{

    @Override
    public int compare(Page o1, Page o2) {
        // o2 -o1
        Integer i1 = o1.getIndex();
        Integer i2 = o2.getIndex();
        if (i1 == null) return 1;
        if (i2 == null) return -1;
        return i2-i1;
    }
    
}

