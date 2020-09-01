import java.util.*;
import java.io.*;

public class Convention {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("convention.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    int c = Integer.parseInt(inp[2]);
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    Arrays.sort(arr);
    int lo = 0;
    int hi = 1000000000;
    //int hi = 9;
    int mid = (lo+hi)/2;
    while (lo<=hi) {
      mid = (lo+hi)/2;
      if (check(arr, mid, n, m, c)) {
        hi = mid-1;
        mid = (lo+hi)/2;
      }
      else {
        lo = mid+1;
        mid = (lo+hi)/2;
      }
    }
    mid++;
    pw.println(mid);
    pw.close();

  }

  public static boolean check(int[] arr, int mid, int n, int m, int c) {
    int wagons = 1;
	  int firstArrival = arr[0];
	  int firstIndex = 0;
	  for(int i=1; i<n; i++) {
		if(arr[i] - firstArrival > mid || i + 1 - firstIndex > c) {
			wagons += 1;
			firstArrival = arr[i];
			firstIndex = i;
		}
	}
	return (wagons <= m);
  }
}
