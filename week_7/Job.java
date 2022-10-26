public class Job {
    private long start;
    private long finish;
    private long value;


    public Job(long start, long finish, long value) {
        this.start = start;
        this.finish = finish;
        this.value = value;
    }

    public long getStart() {
        return this.start;
    }


    public long getFinish() {
        return this.finish;
    }

    public long getValue() {
        return this.value;
    }

}
