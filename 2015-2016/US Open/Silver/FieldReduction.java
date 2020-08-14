import java.util.*;
import java.io.*;

public class FieldReduction {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
    int n = Integer.parseInt(br.readLine());
    int maxx = 0;
    int maxy = 0;
    int minx = Integer.MAX_VALUE;
    int miny = Integer.MIN_VALUE;
    List<Integer> list = new ArrayList<Integer>();
    int[][] inp = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] inps = br.readLine().split(" ");
      inp[i][0] = Integer.parseInt(inps[0]);
      inp[i][1] = Integer.parseInt(inps[1]);
    }
    for (int i = 0; i < n; i++) {
      if (inp[i][0] > maxx)
    }
  }
}
