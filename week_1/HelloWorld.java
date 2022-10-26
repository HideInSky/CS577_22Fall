import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloWorld {
    public  static void main(String args[]) throws FileNotFoundException{
        File f = new File("./SmallTest.txt");
        Scanner myObj = new Scanner(f);
        int nextInt = myObj.nextInt();
        myObj.nextLine();
        for (int i=0; i<nextInt; i++){
            String nextLine = myObj.nextLine();
            System.out.println("Hello, "+ nextLine + "!");
        }
    }
}