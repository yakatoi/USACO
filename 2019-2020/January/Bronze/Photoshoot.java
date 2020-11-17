import java.util.*;
import java.io.*;

public class Photoshoot {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("photo.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] inp = new int[n-1];
    for (int i = 0; i < n-1; i++) {
      inp[i] = Integer.parseInt(st.nextToken());101099
    }
    int[] ans = new int[n];
    boolean check = false;
    for (int j = 1; j < inp[0]; j++) {
      int[] arr = new int[n];
      HashSet<Integer> set = new HashSet<Integer>();
      for (int i = 1; i <= n; i++) {
        set.add(i);
      }
      check = false;
      arr[0] = j;
      set.remove(j);
      for (int i = 1; i < n; i++) {
        arr[i] = inp[i-1] - arr[i-1];
        if (!check) {
          if (!set.contains(arr[i])) {
            check = true;
          }
          else {
            set.remove(arr[i]);
          }
        }
      }
      if (!check) {
        ans = arr.clone();
        break;
      }
    }
    for (int i = 0; i < ans.length; i++) {
      if (i!=n-1) {
        pw.print(ans[i] + " ");
      }
      else {
        pw.println(ans[i]);
      }
    }
    pw.close();
  }

}
