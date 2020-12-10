import java.util.*;
import java.io.*;

public class SecretCode {
  public static String get(String inp, int i, int j) {
    return inp.substring(i, j+1);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("scode.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("scode.out"));
    String input = br.readLine();
    pw.println(recurse(input));
    pw.close();
  }
  public static int recurse(String inp) {
    if (inp.length() <= 2) return 1;
    if (inp.length() == 3) return find(inp);
    int ans = 0;
    int len = inp.length();
    int mid = len/2;
    if (get(inp, 0, mid-1).equals(get(inp, mid, len-2))) {
      ans+=recurse(get(inp, mid, len-1))+1;
    }
    if (get(inp, 0, mid-1).equals(get(inp, mid+1, len-1))) {
      ans+=recurse(get(inp, 0, mid))+1;
    }
    if (get(inp, 0, mid-1).equals(get(inp, mid+1, len-1))) {
      ans+=recurse(get(inp, mid, len-1))+1;
    }
    if (get(inp, 1, mid).equals(get(inp, mid+1, len-1))) {
      ans+=recurse(get(inp, 0, mid))+1;
    }
    return ans;
  }
  public static int find(String str) {
    if (get(str, 0, 0).equals(get(str, 2, 2)) && get(str, 1, 1).equals(get(str, 0, 0))) {
      return 4;
    }
    if (get(str, 0, 0).equals(get(str, 2, 2))) {
      return 2;
    }
    if (!get(str, 0, 0).equals(get(str, 1, 1)) && !get(str, 1, 1).equals(get(str, 2, 2)) && !get(str, 0, 0).equals(get(str, 2, 2))) {
      return 0;
    }
    return 1;
  }
}
