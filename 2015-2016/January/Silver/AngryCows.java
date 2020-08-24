import java.util.*;
import java.io.*;

public class AngryCows {

  public static TreeSet<Integer> loc = new TreeSet<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("angry.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      loc.add(Integer.parseInt(br.readLine()));
    }

    int lo = 0;
    int hi = loc.last() - loc.first();

    int ans = 0;

    while(lo <= hi) {
      int mid = (lo + hi)/2;
      if (!doSimulation(mid, n, k)) {
        ans = mid;
        lo = mid+1;
      }
      else {
        hi = mid-1;
      }
    }
    pw.println(ans+1);
    pw.close();
  }
  public static boolean doSimulation(int r, int n, int k) {
    TreeSet<Integer> al = new TreeSet<Integer>(loc);
    for (int i = 0; i < k; i++) {
      int min = al.first();
      al = removeAllBelowACertainIndice(al, min + 2*r);
      if (al.isEmpty()) {
        return true;
      }
    }
    return false;

  }

  public static TreeSet<Integer> removeAllBelowACertainIndice(TreeSet<Integer> al, int below) {
    while (!al.isEmpty() && al.first() <= below) {
      al.remove(al.first());
    }
    return al;
  }
}
