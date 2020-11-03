import java.util.*;
import java.io.*;

public class HighCardLowCard {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
    int n = Integer.parseInt(br.readLine());
    TreeSet<Integer> total = new TreeSet<Integer>();
    for (int i = 1; i <= 2*n; i++) total.add(i);
    ArrayList<Integer> b1 = new ArrayList<Integer>();
    ArrayList<Integer> b2 = new ArrayList<Integer>();
    ArrayList<Integer> e1 = new ArrayList<Integer>();
    ArrayList<Integer> e2 = new ArrayList<Integer>();
    for (int i = 0; i < n/2; i++) {
      int inp = Integer.parseInt(br.readLine());
      e1.add(inp);
      total.remove(inp);
    }
    for (int i = 0; i < n/2; i++) {
      int inp = Integer.parseInt(br.readLine());
      e2.add(inp);
      total.remove(inp);
    }
    while (b1.size() != e1.size()) {
      b1.add(total.last());
      total.remove(total.last());
    }
    for (int ele : total) {
      b2.add(ele);
    }
    Collections.sort(b1);
    Collections.sort(b2, Collections.reverseOrder());
    Collections.sort(e1);
    Collections.sort(e2, Collections.reverseOrder());
    // System.out.println(e1);
    // System.out.println(b1);
    // System.out.println(e2);
    // System.out.println(b2);
    int counter = 0;
    int i = 0;
    int j =0;
    while (i < n/2 && j < n/2) {
      if (b1.get(j) > e1.get(i)) {
        counter++;
        i++;
      }
      j++;

    }
    i = 0;
    j = 0;
    while (i < n/2 && j < n/2) {
      if (b2.get(j) < e2.get(i)) {
        counter++;
        i++;
      }
      j++;
    }
    pw.println(counter);
    pw.close();
  }
}
