import java.util.Comparator;

class JobComparator implements Comparator<Job>{

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getFinishTime() > o2.getFinishTime()){
            // o2 higher priority
            return 1;
        } else {
            return -1;
        }
    }

}