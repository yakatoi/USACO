import java.util.*;
import java.io.*;

public class CircularBarn {
  public static long sum(long x) {
    return ((x)*(x+1)*(2*x+1))/6;
  }
  public static void rotate(int i, int j, long mid, long[] arr) {
    long ele = arr[arr.length-1];
    while (arr[i]!= ele) {
      rotate(i, j, arr);
    }
  }
  public static void rotate(int i, int j, long[] arr) {
    long[] newarr = new long[arr.length];
    for (int ele = 0;ele < arr.length; ele++) {
      newarr[ele] = arr[ele];
    }
    newarr[i] = arr[j];
    for (int x = i; x < j; x++) {
      newarr[x+1] = arr[x];
    }
    for (int ele = 0;ele < arr.length; ele++) {
      arr[ele] = newarr[ele];
    }
  }
  public static long max(long a, long b) {return a> b ? a : b;}
  public static void main(String[] args) throws IOException {
    BufferedReader br =  new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n];
    long c = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
      c = Math.max(0, c + arr[i] -1);
    }
    for (int i = 0; ; i++) {
      if (c == 0) {
        rotate(0, i, arr[n-1], arr);
        break;
      }
      c = max(0, c + arr[i] - 1);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      res += sum(arr[i] + c - 1) - sum(c - 1);
      c = max(0, c + arr[i] - 1);
    }
    pw.println(res);
    pw.close();
  }
}
