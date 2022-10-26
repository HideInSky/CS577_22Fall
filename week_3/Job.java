public class Job implements Comparable<Job>{
    private int startTime;
    private int finishTime;

    Job (int startTime, int finishTime){
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getFinishTime() {
        return this.finishTime;
    }

    public void printJob(){
        System.out.println("Start time: " + this.startTime +
        "; Finish time: " + this.finishTime);
    }

    @Override
    public int compareTo(Job o) {
        if (this.getFinishTime() < o.getFinishTime()){
            return -1;
        }
        else {
            return 1;
        }
    }

}
