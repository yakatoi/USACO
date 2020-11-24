import java.util.*;
import java.io.*;

public class SecretCode {
  public static String get(String str, int i) {
    return str.substring(i, i+1);
  }
  public static ArrayList<Integer> al = new ArrayList<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("scode.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("scode.out"));
    String str = br.readLine();
    recurse(str);
    int ans = 0;
    for (int ele : al) {
      ans+=ele;
    }
    pw.println(ans);
    pw.close();
  }
  public static void recurse(String str) {
    int mid = str.length()/2;
    if (str.length() <= 3) {
      rectwo(str);
      return;
    }
    int sum = 0;
    if (check1(str, mid)) {
      sum++;
      recurse(get(str,0) + str.substring(1, mid) + get(str, str.length()-1));
    }
    if (check2(str, mid)) {
      sum++;
      recurse(get(str, mid) + str.substring(0, mid-1) + get(str, mid-1));
    }
    if (check3(str, mid)) {
      sum++;
      recurse(get(str,0) + str.substring(1, mid) + get(str, str.length()-1));
    }
    if (check4(str, mid)) {
      sum++;
      recurse(get(str, 0) + str.substring(1, mid) + get(str, mid));
    }
    if (sum!=0) al.add(sum);
  }
  public static void rectwo(String str) {
    int sum = 0;
    if (get(str, 0).equals(get(str, 2))) sum++;
    if (get(str, 1).equals(get(str, 2))) sum++;
    if (get(str, 0).equals(get(str, 2))) sum++;
    if (get(str, 0).equals(get(str, 1))) sum++;
    if (sum!=0) al.add(sum);
  }
  public static boolean check1(String str, int mid) {
    return get(str, mid).equals(get(str, str.length()-1)) && str.substring(1, mid).equals(str.substring(mid+1, str.length()-1));
  }
  public static boolean check2(String str, int mid) {
    return get(str, mid-1).equals(get(str, str.length()-1)) && str.substring(0, mid-1).equals(str.substring(mid+1, str.length()-1));
  }
  public static boolean check3(String str, int mid) {
    return get(str, 0).equals(get(str, mid)) && str.substring(1, mid).equals(str.substring(mid+1, str.length()-1));
  }
  public static boolean check4(String str, int mid) {
    return get(str, 0).equals(get(str, str.length()-1)) && str.substring(1, mid).equals(str.substring(mid+2, str.length()));
  }
}
