import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Week_5 {
    private int numOfInv = 0;
    private int[] arr;

    public  void CountSort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            CountSort(arr, l, m);
            CountSort(arr, m + 1, r);
            MergeCount(arr, l, m, r);
        }
    }

    public  void MergeCount(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int left[] = new int[n1];
        int right[] = new int[n2];
        
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
    public  static void main(String args[]) throws FileNotFoundException{
        // File f = new File("./GivenTest-5.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<instanceNum; i++){
            // TEST1 
            // System.out.println("Instance: " + i);
            int sizeOfArr = sc.nextInt();
            sc.nextLine();
            Week_5 inv = new Week_5();
            inv.arr = new int[sizeOfArr];

            for (int j = 0; j<sizeOfArr; j++){
                inv.arr[j] = sc.nextInt();
            }
            // already store the ints into arr[]
           
            inv.CountSort(inv.arr, 0, sizeOfArr-1);
            // reset numofinv after one instance
            
            System.out.println(inv.numOfInv);
            // printArray(inv.arr);

        }
        sc.close();
    }
 

}