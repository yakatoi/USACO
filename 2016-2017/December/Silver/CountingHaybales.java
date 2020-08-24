import java.util.*;
import java.io.*;

public class CountingHaybales {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][2];
    String[] str = br.readLine().split(" ");
    Arrays.sort(str);
    for (int i = 0; i < n; i++) {
      arr[i][0] = Integer.parseInt(str[i]);
      arr[i][1] = i+1;
    }
    for (int count = 0; count < q; count++) {
      String[] inp = br.readLine().split(" ");

      double fir = getIndex(arr, Integer.parseInt(inp[0]), n);
      double sec = getIndex(arr, Integer.parseInt(inp[1]), n);
      int ans = 0;
      if (fir==sec) {
        ans = 0;
      }
      else {
        if (fir==-1.0 && sec==-2.0) {
          ans = n;
        }
        else if (sec==-2.0) {
          ans = n-(arr[(int) Math.floor(fir)][1]);
        }
        else if (fir==-1.0) {
          ans = (arr[(int) Math.floor(sec)][1]);
        }
        else {
          ans = arr[(int) Math.floor(sec)][1] - arr[(int) Math.floor(fir)][1];
        }
      }

      System.out.println(ans);
    }
    //pw.close();

  }
  public static double getIndex(int[][] arr, int fir, int n) {
    if (fir <= arr[0][0]) {
      return -1.0;
    }
    if (fir >= arr[n-1][0]) {
      return -2.0;
    }
    int lo = 0;
    int hi = n-1;
    int mid = (lo + hi)/2;
    while(lo <= hi) {
      mid = (lo + hi)/2;
      if (arr[mid][0] == fir) {
        break;
      }
      else if (arr[mid][0] > fir) {
        hi = mid-1;
      }
      else {
        lo = mid+1;
      }
    }
    if (arr[mid][0]==fir) {
      return (double) mid;
    }
    return mid-0.5;
  }

}
