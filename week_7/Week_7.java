import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Week_7 {

    public  void sortJobs(Job[] arr, int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sortJobs(arr, l, m);
            sortJobs(arr, m + 1, r);
            mergeJobs(arr, l, m, r);
        }
    }

    public  void mergeJobs(Job[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        Job[] left = new Job[n1];
        Job[] right = new Job[n2];
        
        // get left and right arr
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        // merge them 
        while (i < n1 && j < n2) {
            long fi_left = left[i].getFinish();
            long fi_right = right[j].getFinish(); //?

            if (fi_left <= fi_right) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public int findIndexI(Job[] arr, int jobNum, int indexJ){
        long st_j = arr[indexJ].getStart();
        
        for (int i = jobNum-1; i>=0; i--){
            long fi_i = arr[i].getFinish();
            if (fi_i <= st_j){
                return i;
            }
        }
        return -1;
    }
    
    public  static void main(String args[]) throws FileNotFoundException{
        // File f = new File("./GivenTest-7.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<instanceNum; i++){
            // TEST1 
            // System.out.println("Instance: " + i);
            int jobNum = sc.nextInt();
            if (jobNum == 0) continue;
            sc.nextLine();
            Job[] jobs = new Job[jobNum];
            for (int j=0; j<jobNum; j++){
                int start = sc.nextInt();
                int finish = sc.nextInt();
                int value = sc.nextInt();
                Job job = new Job(start, finish, value);
                jobs[j] = job;
            }
            Week_7 WIS = new Week_7();
            // sort jobs by finish time
            WIS.sortJobs(jobs, 0, jobNum-1);

            // create dp table
            long[] m = new long[jobNum];
            m[0] = jobs[0].getValue();
        
            // dp table for j       
            // job[], job[0] -> 1st job -> m[0]
            for (int j = 1; j<jobNum; j++){
                // find index i
                int indexI = WIS.findIndexI(jobs, jobNum, j);
                if (indexI == -1){
                    m[j] = Math.max(m[j-1], jobs[j].getValue());
                }
                else{
                    m[j] = Math.max(m[j-1], m[indexI] + jobs[j].getValue());
                }
            }

            System.out.println(m[jobNum-1]);
        }
        sc.close();
    }
 

}