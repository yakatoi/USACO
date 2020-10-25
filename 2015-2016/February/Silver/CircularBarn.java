import java.util.*;
import java.io.*;

public class CircularBarn {
  public static long sum(long x) {
    return ((x)*(x+1)*(2*x+1))/6;
  }
  public static void rotate(long i, long j, long mid, long[] arr) {
    long ele = arr[arr.length-1];
    while (arr[i]!= ele) {
      rotate(i, j, arr);
    }
  }
  public static void rotate(long i, long j, long[] arr) {
    long[] newarr = new long[arr.length];
    for (long ele = 0;ele < arr.length; ele++) {
      newarr[ele] = arr[ele];
    }
    newarr[i] = arr[j];
    for (long x = i; x < j; x++) {
      newarr[x+1] = arr[x];
    }
    for (long ele = 0;ele < arr.length; ele++) {
      arr[ele] = newarr[ele];
    }
  }
  public static long max(long a, long b) {return a> b ? a : b;}
  public static void main(String[] args) throws IOException {
    BufferedReader br =  new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
    long n = Long.parseLong(br.readLine());
    long[] arr = new long[n];
    long c = 0;
    for (long i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
      c = Math.max(0, c + arr[i] -1);
    }
    for (long i = 0; ; i++) {
      if (c == 0) {
        rotate(0, i, arr[n-1], arr);
        break;
      }
      c = max(0, c + arr[i] - 1);
    }
    long res = 0;
    for (long i = 0; i < n; i++) {
      res += sum(arr[i] + c - 1) - sum(c - 1);
      c = max(0, c + arr[i] - 1);
    }
    System.out.prlongln(res);
  }
}
