import java.util.*;
import java.io.*;

public class WhereAmI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
    int n = Integer.parseInt(br.readLine());
    String row = br.readLine();
    int smallest = n;
    for (int len = 1; len < n; len++) {
      boolean check = true;
      for (int i = 0; i < row.length()-len+1; i++) {
        String sub = row.substring(i, i+len);
        if (countOccurences(sub, row)!=1) {
          check = false;
        }
      }
      if (check) {
        smallest = len;
        break;
      }
    }
    pw.println(smallest);
    pw.close();

  }

  public static int countOccurences(String a, String b) {
    int counter = 0;
    for (int i = 0; i < b.length()-a.length()+1; i++) {
      if (a.equals(b.substring(i, i+a.length()))) {
        counter++;
      }
    }
    return counter;
  }
}
