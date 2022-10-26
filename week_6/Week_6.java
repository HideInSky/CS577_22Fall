import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * Hi, I'm stuck at debugging.
 * My idea for week_6 is to change week_5 a bit.
 * Firstly, merge sort array_q in ascending order,
 * also changing the order of array_p corresponding to array_q,
 * And then, sort the array_p, count the inversion of it.
 * I don't know somehow my code stuck at this point.
 * I think the problem is that I don't know 
 * how to figure out the invertcount method
 * and at the same time not to extend the array boundary.
 * Can you give me participation points for this~ ?
 * Thank you! Have a nice day!
 * 
 */
public class Week_6 {
    private int numOfInv = 0;
    private long[] arr_q;
    private long[] arr_p;
    private long[] temp;

    public  void CountSort(long arr1[], long arr2[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            CountSort(arr1, arr2, l, m);
            CountSort(arr1, arr2, m + 1, r);
            MergeCount(arr1, arr2, l, m, r);
            temp = new long[l+1];
            for (int i = 0; i<l+1; i++){
                temp[i] = arr2[i];
            }
            InvCount(temp, l, m, r);
        }
    }
    public void InvCount(long arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        long left[] = new long[n1];
        long right[] = new long[n2];
        
        // get left and right arr
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        // merge them 
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
                // if from B, c = c + |A|
                numOfInv += (n1 - i);
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
    public  void MergeCount(long arr[], long arr2[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        // q
        long left[] = new long[n1];
        long right[] = new long[n2];
        
        // p
        long left2[] = new long[n1];
        long right2[] = new long[n2];

        // get left and right arr of p
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];
        // get left and right arr of q
        for (int i = 0; i < n1; i++)
            left2[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right2[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        // merge them 
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                arr2[k] = left2[i];
                i++;
            }
            else {
                arr[k] = right[j];
                arr2[k] = right2[j];
                j++;
                // // if from B, c = c + |A|
                // numOfInv += (n1 - i);
            }
            k++;
        }

        // if empty
        while (i < n1) {
            arr[k] = left[i];
            arr2[k] = left2[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = right[j];
            arr2[k] = right2[j];
            j++;
            k++;
        }
    }
    public  static void main(String args[]) throws FileNotFoundException{
        File f = new File("./GivenTest-3.txt");
        Scanner sc = new Scanner(f);
        // Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<instanceNum; i++){
            // TEST1 
            // System.out.println("Instance: " + i);
            int pairNum = sc.nextInt();
            sc.nextLine();
            Week_6 inv = new Week_6();
            inv.arr_q = new long[pairNum];
            inv.arr_p = new long[pairNum];

            // store p & q
            // O(n)
            for (int q=0; q<pairNum; q++){
                inv.arr_q[q] = sc.nextInt();
            }
            for (int p=0; p<pairNum; p++){
                inv.arr_p[p] = sc.nextInt();
            }
            
           
            inv.CountSort(inv.arr_q, inv.arr_p, 0, pairNum);
            // reset numofinv after one instance
            
            System.out.println(inv.numOfInv);
            // printArray(inv.arr);

        }
        sc.close();
    }
 

}