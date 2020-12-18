import java.util.*;
import java.io.*;

public class Teleportation {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt")));
    PrintWriter pw = new PrintWriter(new FileWriter("teleport.out"));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> al = new ArrayList<Integer>();
    int[][] inp = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      al.add(a); al.add(a+1); al.add(a-1);
      al.add(b); al.add(b+1); al.add(b+1);
      al.add((a+b)/2);
      inp[i][0] = a;
      inp[i][1] = b;
    }
  }
}
