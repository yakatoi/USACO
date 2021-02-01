import java.util.*;
import java.io.*;

public class CitiesAndStates {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("citystate.out"));
    int n = Integer.parseInt(br.readLine());
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String str = st.nextToken().substring(0, 2) + st.nextToken();
      if (map.keySet().contains(reverse(str))) {
        map.put(reverse(str), map.get(reverse(str)) + 1);
      }
      else {
        map.put(str, 0);
      }
    }
    int ans = 0;
    for (int ele: map.values()) {
      ans+=ele;
    }
    pw.println(ans);
    pw.close();
  }
  static String reverse(String str) {
    return str.substring(2, 4) + str.substring(0, 2);
  }
}
