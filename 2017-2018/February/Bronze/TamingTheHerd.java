import java.util.*;
import java.io.*;

public class TamingTheHerd {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("taming.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int min = 0;
    int max = 0;
    boolean crazy = false;
    String[] b = new String[n];
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        b[i] = "B";
      }
      else {
        b[i] = "?";
      }
    }
    b[0] = "B";
    outer: for (int i = n-1; i >= 1; i--) {
      if (arr[i] > 0) {
        b[i] = "N";
        int counter = i;
        while (counter > i - arr[i] + 1) {
          counter--;
          b[counter] = "N";
        }
        counter--;
        b[counter] = "B";
      }
    }
    for (String s : b) {
      if (s.equals("B")) {
        min++;
        max++;
      }
      else if (s.equals("?")) {
        max++;
      }
    }
    pw.println(min + " " + max);
    pw.close();
  }
}
