import java.util.*;
import java.io.*;

public class SleepyCowHerding {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("herding.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int minans = minAns(arr, n);
    int maxans = Math.max(arr[n-2]-arr[0], arr[n-1]-arr[1]) - (n-2);
    pw.println(minans);
    pw.println(maxans);
    pw.close();
  }
  public static int minAns(int[] A, int N) {
    if (A[N-2]-A[0] == N-2 && A[N-1]-A[N-2]>2) {
      return 2;
    }
    if (A[N-1]-A[1] == N-2 && A[1]-A[0]>2) {
      return 2;
    }
    int j=0;
    int best=0;
    for (int i=0; i<N; i++) {
      while (j<N-1 && A[j+1]-A[i]<=N-1) {
        j++;
      }
      best = Math.max(best, j-i+1);
    }
    return N-best;
  }
}
