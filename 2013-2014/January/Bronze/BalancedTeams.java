import java.util.*;
import java.io.*;

public class BalancedTeams {
  public static int min(int a, int b, int c, int d) {
    int x = Math.min(a, b);
    int y = Math.min(c, d);
    return Math.min(x, y);
  }
  public static int max(int a, int b, int c, int d) {
    int x = Math.max(a, b);
    int y = Math.max(c, d);
    return Math.max(x, y);
  }
  public static int ans = Integer.MAX_VALUE;
  public static int one, two, three, four;
  public static int oneSum, twoSum, threeSum, fourSum;
  public static ArrayList<Integer> al = new ArrayList<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("bteams.out"));
    for (int i = 0; i <12; i++) {
      al.add(Integer.parseInt(br.readLine()));
    }
    recurse(0);
    System.out.println(ans);
    pw.close();

  }
  public static void recurse(int n) {
    if (n==12) {
      int S = max(oneSum, twoSum, threeSum, fourSum);
      int s = min(oneSum, twoSum, threeSum, fourSum);
      ans = Math.min(ans, S-s);
      return;
    }
    if (one < 3) {
      oneSum+=al.get(n);
      one++;
      recurse(n+1);
      oneSum-=al.get(n);
      one--;
    }
    if (two < 3) {
      twoSum+=al.get(n);
      two++;
      recurse(n+1);
      twoSum-=al.get(n);
      two--;
    }
    if (three < 3) {
      threeSum+=al.get(n);
      three++;
      recurse(n+1);
      threeSum-=al.get(n);
      three--;
    }
    if (four < 3) {
      fourSum+=al.get(n);
      four++;
      recurse(n+1);
      fourSum-=al.get(n);
      four--;
    }

  }

}
