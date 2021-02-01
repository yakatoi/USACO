import java.util.*;
import java.io.*;

public class NoTimeToPaint {
  static int n, q;
  static String[] inp;
  static ArrayList<HashSet<String>> al = new ArrayList<HashSet<String>>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    inp = br.readLine().split("");
    for (int i = 0; i < n; i++) {
      al.add(new HashSet<String>());
    }
    al.get(0).add(inp[0]);
    for (int i = 1; i < n; i++) {
      al.get(i).addAll(al.get(i-1));
      al.get(i).add(inp[i]);
    }
    for (int i = 0; i < n; i++) {
      System.out.println(al.get(i));
    }
  }
}
