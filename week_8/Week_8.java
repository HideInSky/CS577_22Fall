import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Week_8 {

    static int knapSack(int W, Item[] items){
        int n = items.length;
        int M[][] = new int[n+1][W+1];
        for (int i = 0; i<=n; i++){
            for (int w = 0; w<=W; w++){
                if (i==0 || w==0){
                    M[i][w] = 0;
                }
                else if (items[i-1].getWeight() <= w){
                    M[i][w] = Math.max(items[i-1].getValue() + M[i-1][w - items[i-1].getWeight()], M[i-1][w]);
                }
                else{
                    M[i][w] = M[i-1][w];
                }
            }
        }
        return M[n][W];
    }
    
    public  static void main(String args[]) throws FileNotFoundException{
        // File f = new File("./GivenTest-4.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<instanceNum; i++){
            // TEST1 
            // System.out.println("Instance: " + i);
            // get item Num and capacity
            int itemNum = sc.nextInt();
            int capacity = sc.nextInt();
            sc.nextLine();
            // add each item's weight and value to the items list
            Item[] items = new Item[itemNum];
            for (int j = 0; j<itemNum; j++){
                int weight = sc.nextInt();
                int value = sc.nextInt();
                Item item = new Item(weight, value);
                items[j] = item;
            }
            System.out.println(knapSack(capacity, items));
        }
        sc.close();
    }
 

}