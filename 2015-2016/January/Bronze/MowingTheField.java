import java.util.*;
import java.io.*;

public class MowingTheField {
  public static int[][] arr = new int[2001][2001];
  public static int x = 1000;
  public static int y = 1000;
  public static int t = 0;
  public static boolean cross = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader    ("input.txt"));
    PrintWriter    pw = new PrintWriter   (new BufferedWriter(new FileWriter("mowing.out")));
    // I/O setup
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    String[] squery = new String[n];
    int[] nquery = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      squery[i] = st.nextToken();
      nquery[i] = Integer.parseInt(st.nextToken());
    }
    int lo  = 1;
    int hi  = 1000;
    int ans = 0;

    while(lo <= hi) {
        int mid = (lo+hi)/2;
        if(runSimulate(squery, nquery, mid)){
          ans = mid;
          lo  = mid + 1;
        }
        else{
          hi = mid-1;
        }
    }
    System.out.println(ans);




  }
  public static boolean simulate(String dir, int dist, int x) {
    if (dir.equals("N")) {
      for (int i = t; i < t + dist; i++) {
        if (arr[x][y+i-t+1]!=0) {
          cross = true;
        }
        if (arr[x][y+i-t+1]< i) {
          return false;
        }
        arr[x][y+i-t+1] = i;
      }
    }
    if (dir.equals("S")) {
      for (int i = t; i < t + dist; i++) {
        if (arr[x][y-(i-t+1)]!=0) {
          cross = true;
        }
        if (arr[x][y-(i-t+1)]< i) {
          return false;
        }
        arr[x][y-(i-t+1)] = i;
      }
    }
    if (dir.equals("E")) {
      for (int i = t; i < t + dist; i++) {
        if (arr[x+i-t+1][y]!=0) {
          cross = true;
        }
        if (arr[x+i-t+1][y]< i) {
          return false;
        }
        arr[x+i-t+1][y] = i;
      }
    }
    if (dir.equals("W")) {
      for (int i = t; i < t + dist; i++) {
        if (arr[x-(i-t+1)][y]!=0) {
          cross = true;
        }
        if (arr[x-(i-t+1)][y]< i) {
          return false;
        }
        arr[x-(i-t+1)][y] = i;
      }
    }
    return true;

  }
  public static boolean runSimulate(String[] squery, int[] nquery, int x) {
    boolean check = true;
    for (int i = 0; i < squery.length; i++) {
      check = simulate(squery[i], nquery[i], x);
    }
    return check;
  }
}
