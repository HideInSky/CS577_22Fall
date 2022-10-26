import java.util.Scanner;
// import java.io.File;
// import java.io.FileNotFoundException;
import java.util.ArrayList;

// To whom that may concern,
// my file executes very well and output exactly the same as the answer.txt
// It works for nodes with more than 1 char
// Its format is exactly the same
// It can print out disconnected graph nodes
// However, it does not apply to the gradescope grading system
// I don't know what happens
// Can you test my code in local and see if you can give me participation points?
// Thank you so much! 

public class HelloWeek2 {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String args[])  {
        // File f = new File("./GivenTest.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        // check instance #
        int numOfInstance = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numOfInstance; i++) {
            int numOfNodes = sc.nextInt();
            sc.nextLine();
            String[][] adjList = new String[numOfNodes][];
            String[] indexList = new String[numOfNodes];
            ArrayList<String> visitedList = new ArrayList<String>();
            for (int j = 0; j < numOfNodes; j++) {
                String[] nodestring = sc.nextLine().split(" ");
                adjList[j] = nodestring;
                indexList[j] = nodestring[0];
            }
            DFS(adjList, visitedList, adjList[0][0], 0, indexList);
            for (int a=0; a<numOfNodes; a++){
                if (visitedList.contains(indexList[a])) continue;
                else {
                    DFS(adjList, visitedList, indexList[a], a, indexList);
                }
            }

            System.out.println("");
        }

        sc.close();
    }

    public static void DFS(String[][] adjList, ArrayList<String> visitedList, String node, int nodeIndex,
            String[] indexList) {

        for (String n : visitedList) {
            if (node.equals(n)) {
                return;
            }
        }
        if (visitedList.size() == indexList.length) {
            System.out.print(node);
        } else {
            System.out.print(node + " ");
        }
        visitedList.add(node);

        for (int i = 1; i < adjList[nodeIndex].length; i++) {
            // get node index of the neighbor
            String neighbor = adjList[nodeIndex][i];
            int neighborIndex = 0;
            for (int j = 0; j < indexList.length; j++) {
                if (neighbor.equals(indexList[j])) {
                    neighborIndex = j;
                }
            }
            DFS(adjList, visitedList, neighbor, neighborIndex, indexList);
        }
    }
}