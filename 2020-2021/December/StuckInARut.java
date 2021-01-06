import java.util.*;
import java.io.*;
  public class StuckInARut {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      char[] dir = new char[n];
      for (int j = 0; j < n; j++) {
        dir[j] = in.next().charAt(0);
        x[j] = in.nextInt();
        y[j] = in.nextInt();
      }
      int[] ans = new int[n];
      Arrays.fill(ans, Integer.MAX_VALUE);
      ArrayList<Integer> al = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          al.add(Math.abs(x[k] - x[j]));
          al.add(Math.abs(y[k] - y[j]));
        }
      }
      Collections.sort(al);
      for (int d : al) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (dir[i] == 'E' && dir[j] == 'N' && x[i] < x[j] && y[j] < y[i]) {
              if (x[i] + d == x[j] && y[j] + Math.min(ans[j], d) > y[i]) {
                ans[i] = Math.min(ans[i], d);
              } else if (y[j] + d == y[i] && x[i] + Math.min(ans[i], d) > x[j]) {
                ans[j] = Math.min(ans[j], d);
              }
            }
          }
        }
      }
      for (int i = 0; i < n; i++) {
        System.out.println(ans[i] == Integer.MAX_VALUE ? "Infinity" : ans[i]);
      }
    }
  }
