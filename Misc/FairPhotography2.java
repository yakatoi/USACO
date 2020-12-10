import java.util.*;
import java.io.*;

public class FairPhotography2 {
  static int n;
  static int[][] arr;
  static int max = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("fairphoto.out"));
    n = Integer.parseInt(br.readLine());
    if (n >= 300) {
      arr = new int[4][n+1]; arr[0][0] = -1; arr[1][0] = -1;
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
        StringTokenizer st= new StringTokenizer(br.readLine());
        int pos = Integer.parseInt(st.nextToken());
        int breed = st.nextToken().equals("G") ? 1: 0;
        arr[0][i+1] = pos;
        map.put(pos, breed);
      }
      Arrays.sort(arr[0]);
      for (int i = 1; i <= n; i++) {
        arr[1][i] = map.get(arr[0][i]);
      }
      for (int i = 1; i <=n; i++) {
        if (arr[1][i] == 1) arr[2][i]++;
        if (arr[1][i] == 0) arr[3][i]++;
        arr[2][i]+=arr[2][i-1];
        arr[3][i]+=arr[3][i-1];
      }
      // for (int[] row :arr) {
      //   System.out.println(Arrays.toString(row));
      // }
      // System.out.println(5 + " " + Arrays.binarySearch(arr[0], 5));
      // System.out.println(7 + " " + Arrays.binarySearch(arr[0], 7));
      // System.out.println(1 + " " + Arrays.binarySearch(arr[0], 1));
      // System.out.println(0 + " " + Arrays.binarySearch(arr[0], 0));
      int lo = 0;
      int hi = arr[0][n] - arr[0][1];
      while (lo != hi) {
        int mid = (lo+hi+1)/2;
        boolean one = works(mid);
        boolean two = worksTwo(mid);
        if (one || two) {
          lo = mid;
        }
        else {
          hi = mid-1;
        }
      }
      //System.out.println(max);
      pw.println(max);
    }
    else {
      Cow[] arr = new Cow[n+1];
      arr[0] = new Cow(-1, "");
      int[] g = new int[n+1];
      int[] h = new int[n+1];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int in = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        arr[i+1] = new Cow(in, str);
      }
      Arrays.sort(arr, (a, b) -> (Integer.compare(a.p, b.p)));
      // for (int i = 0; i <= n; i++) {
      //   System.out.println(arr[i].p + " " + arr[i].b);
      // }
      // System.out.println(Arrays.toString(g));
      // System.out.println(Arrays.toString(h));
      for (int i = 1; i <= n; i++) {
        if (arr[i].b== 1) g[i]++;
        else h[i]++;
        g[i]+=g[i-1];
        h[i]+=h[i-1];
      }
      int i = 1;
      int j = n;
      int max = 0;
      while (i < j) {
        int dif = (g[j] - g[i-1]) - (h[j] - h[i-1]);
        if (dif == 0 || g[j]-g[i-1]==0 || h[j]-h[i-1]==0)  {
          max = Math.max(max, arr[j].p -arr[i].p);
          i++;j--;
        }
        else if (dif > 0) {
          if (arr[i].b == 0 && arr[j].b==0) {i++;j--;continue;}
          if (arr[i].b == 1 && arr[j].b==0) {i++;continue;}
          if (arr[i].b == 0 && arr[j].b==1) {j--;continue;}
          if (arr[i].b == 1 && arr[j].b==1) {
            if (arr[j].p - arr[j-1].p < arr[i+1].p - arr[i].p) {j--;continue;}
            else {i++;continue;}
          }
        }
        else {
          if (arr[i].b == 1 && arr[j].b==1) {i++;j--;continue;}
          if (arr[i].b == 0 && arr[j].b==1) {i++;continue;}
          if (arr[i].b == 1 && arr[j].b==0) {j--;continue;}
          if (arr[i].b == 0 && arr[j].b==0) {
            if (arr[j].p - arr[j-1].p < arr[i+1].p - arr[i].p) {j--;continue;}
            else {i++;continue;}
          }
        }
      }
      pw.println(max);
    }
    pw.close();
  }
  static class Cow {
    int p, b;
    public Cow(int x, String y) {
      p=x;
      b=y.equals("G") ? 1 : 0;
      if (y.length()==0) b = -1;
    }
    public String toString() {
      return p + " " + b;
    }
  }
  static boolean works(int x) {
    for (int i = 1; i <= n; i++) {
      int startIndex = i;
      int endIndex = i+x-1;
      if (endIndex > n) continue;
      if ((arr[2][endIndex] - arr[2][startIndex-1]) == (arr[3][endIndex] - arr[3][startIndex-1]) || (arr[3][endIndex] - arr[3][startIndex-1])==0 || (arr[2][endIndex] - arr[2][startIndex-1]) ==0) {
        max = Math.max(max, arr[0][endIndex] - arr[0][startIndex]);
        return true;
      }
    }
    return false;
  }
  static boolean worksTwo(int x) {
    for (int i = n; i >= 1; i--) {
      int startIndex = i-x;
      int endIndex = i;
      if (startIndex < 1) continue;
      if ((arr[2][endIndex] - arr[2][startIndex-1]) == (arr[3][endIndex] - arr[3][startIndex-1]) || (arr[3][endIndex] - arr[3][startIndex-1])==0 || (arr[2][endIndex] - arr[2][startIndex-1]) ==0) {
        max = Math.max(max, arr[0][endIndex] - arr[0][startIndex]);
        return true;
      }
    }
    return false;
  }
}
