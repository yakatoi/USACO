import java.util.*;
import java.io.*;

public class TheMooParticle {
  public static ArrayList<Integer> parent = new ArrayList<Integer>();
  public static ArrayList<Integer> size = new ArrayList<Integer>();

  public static void initialize(int n) {
    for (int i = 0; i < n; i++) {
      parent.add(i);
      size.add(1);
    }
  }

  public static int root(int i) {
    while(parent.get(i) != i) {
      parent.set(i, parent.get(parent.get(i)));
      i = parent.get(i);
    }
    return i;
  }

  public static void union(int a , int b) {
    int ra = root(a);
    int rb = root(b);
    if (size.get(ra) < size.get(rb)) {
      parent.set(ra, parent.get(rb));
      size.set(rb, size.get(rb) + size.get(ra));
    }
    else {
      parent.set(rb, parent.get(ra));
      size.set(ra, size.get(ra) + size.get(rb));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("moop.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moop.out"));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[i][0] = i;
      arr[i][1] = x;
      arr[i][2] = y;
    }
    initialize(n);
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if ((arr[i][1] >= arr[j][1] && arr[i][2] >= arr[j][2]) || (arr[j][1] >= arr[i][1] && arr[j][2] >= arr[i][2])) {
          union(arr[i][0], arr[j][0]);
        }
      }
    }
    HashSet<Integer> set = new HashSet<Integer>();
    for (int child : parent) {
      set.add(child);
    }
    pw.println(set.size());
    pw.close();
  }
}
