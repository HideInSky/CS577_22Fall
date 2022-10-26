import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Week_3 {
    
    public  static void main(String args[]) throws FileNotFoundException{
        // File f = new File("./GivenTest-1.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        
        for (int i=0; i<instanceNum; i++){
            // TEST1 
            // System.out.println("Instance: " + i);
            int jobsNum = sc.nextInt();
            sc.nextLine();
            
            // Create job priority queue,
            // sort the job in the ascending order of finish time
            PriorityQueue<Job> jobs = new PriorityQueue<Job>(jobsNum, new JobComparator());

            for (int j=0; j<jobsNum; j++){
                String[] job_string = sc.nextLine().split(" ");
                Job job = new Job(Integer.parseInt(job_string[0]), Integer.parseInt(job_string[1]));
                jobs.add(job);
            }
            
            // Create an arrayList for storing jobs
            // that are compatible to add into the internal schedule
            ArrayList<Job> jobList = new ArrayList<>();
            Job temp = jobs.poll();
            Job last;
            jobList.add(temp);

            // iterate through jobs priority queue and poll until empty
            while (temp != null){
                temp = jobs.poll();
                last = jobList.get(jobList.size() - 1);
                if (compatibleOrNot(temp, last)){
                    jobList.add(temp);
                }
            }
            System.out.println(jobList.size());
            // TEST2
            // for (Job jj: jobList){
            //     jj.printJob();
            // }
            
        }
        sc.close();
    }

    // If j1 should be added to the job schedule list,
    // j2 is the last job in the jobsList
    public static boolean compatibleOrNot(Job j1, Job j2){
        if (j1 == null || j2 == null) return false;

        if (j1.getStartTime() >= j2.getFinishTime()){
            return true;
        }
        else{
            return false;
        }
    }
}