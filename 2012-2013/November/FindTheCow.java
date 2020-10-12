import java.util.*;
import java.io.*;

public class FindTheCow {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cowfind.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowfind.out"));
    String[] arr = br.readLine().split("");
    int n = arr.length;
    ArrayList<Integer> xs = new ArrayList<Integer>();
    ArrayList<Integer> ys = new ArrayList<Integer>();
    for (int i = 0; i < n-1; i++) {
      if ((arr[i] + arr[i+1]).equals("((")) {
        xs.add(i);
      }
      if ((arr[i] + arr[i+1]).equals("))")) {
        ys.add(i);
      }
    }
    //System.out.println(xs);
    //System.out.println(ys);
    int counter = 0;
    for (int x : xs) {
      for (int y: ys) {
        if (y > x) {
          counter++;
        }
      }
    }
    pw.println(counter);
    pw.close();
  }
}
