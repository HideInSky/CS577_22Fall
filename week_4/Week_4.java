import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To whom that may concern,
 * I've been working on it for more than 5 hours. 
 * But it does not work anyway.
 * I think the problem is that,
 * I have a priority queue to choose which cache page to kick out,
 * it contains some Pages, and kickout the one with furthest next index Page,
 * but it cannot work correctly if the Page's next index is null.
 * I googled and still could not figure it out.
 * Since this assignment is for participation,
 * hope you can give me credits for this one.
 * Have a nice daaaaay!!! Thank you~
 */
public class Week_4 {
    
    public  static void main(String args[]) throws FileNotFoundException{
        File f = new File("./GivenTest-1.txt");
        Scanner sc = new Scanner(f);
        // Scanner sc = new Scanner(System.in);

        // instance num: num to print in the end
        int instanceNum = sc.nextInt();
        sc.nextLine();

        
        for (int i=0; i<instanceNum; i++){
            
            int cacheSize = sc.nextInt();
            int pageReqSize = sc.nextInt();
            sc.nextLine();
            // System.out.println("Instance get! CacheSize: " + cacheSize + "! PageReqSize: " + pageReqSize + "!");
            
            // [page, page, page ..., page] size=pageReqSize
            ArrayList<Page> storedPages = store(sc, pageReqSize);
            
            Cache cache = new Cache(cacheSize);
            for (int j=0; j<pageReqSize; j++){
                cache.push(storedPages.get(j));
            }
            System.out.println(cache.getPageFault());
        }
        
        sc.close();
    }

    public  static ArrayList<Page>  store(Scanner sc, int pageReqSize){
        ArrayList<Page> pages = new ArrayList<>();
        ArrayList<Page> pageSet = new ArrayList<>();
        for (int i=0; i<pageReqSize; i++){
            int pageVal = sc.nextInt();
            Page which = new Page(pageVal, i);
            boolean contain = false;

            // if which already exists
            for (Page temp: pageSet){
                if (temp.equals(which)){
                    temp.addIndex(i);
                    which = temp;
                    contain = true;
                }
            }
            // if not exist
            if (!contain){
                pageSet.add(which);
            }
            
            // add to pagesInorder
            pages.add(which);
           
        }
        return pages;
    }

}