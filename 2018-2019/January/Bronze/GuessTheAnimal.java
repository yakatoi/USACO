import java.util.*;
import java.io.*;

public class GuessTheAnimal {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("guess.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
    int n = Integer.parseInt(br.readLine());
    HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split(" ");
      HashSet<String> set = new HashSet<String>();
      for (int j = 0; j < Integer.parseInt(inp[1]); j++) {
        set.add(inp[j+2]);
      }
      map.put(inp[0], set);
    }

    int max = 0;
    for (String a: map.keySet()) {
      for (String b: map.keySet()) {
        if (!a.equals(b)) {
          int counter = 0;
          for (String c: map.get(a)) {
            if (map.get(b).contains(c)) {
              counter++;
            }
          }
          max = Math.max(counter, max);
        }
      }
    }
    pw.println(max+1);
    pw.close();
  }
}
