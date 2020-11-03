import java.util.*;
import java.io.*;

public class SnowBoots {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
    PrintWriter pw= new PrintWriter(new FileWriter("snowboots.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    //System.out.println(Arrays.toString(arr));
    Queue<Boot> q = new LinkedList<Boot>();
    for (int i = 0; i < b; i++) {
      st = new StringTokenizer(br.readLine());
      int ain = Integer.parseInt(st.nextToken());
      int bin = Integer.parseInt(st.nextToken());
      q.add(new Boot(ain, bin));
    }
    Boot cur = new Boot(q.poll());
    //System.out.println(q);
    int i = 0;
    int j = i;
    while (i < n) {
      j = i + cur.s;
      if (j >= n) break;
      while (arr[j] > cur.p) {
        j--;
      }

      if (j<=i) {
        cur = new Boot(q.poll());
      }
      else {
        i = j;
      }
    }
    pw.println(b - q.size()-1);
    pw.close();
  }
  public static class Boot {
    public int p;
    public int s;
    public Boot(int a, int b) {
      p = a;
      s = b;
    }
    public Boot(Boot b) {
      p = b.p;
      s = b.s;
    }
    public String toString() {
      return "(" + p + ", " + s + ")";
    }
  }
}
