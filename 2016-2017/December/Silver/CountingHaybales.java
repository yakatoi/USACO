import java.util.*;
import java.io.*;

public class CountingHaybales {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int q = Integer.parseInt(inp[1]);
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    Arrays.sort(arr);
    for (int qw = 0; qw < q; qw++) {
      String[] inp1 = br.readLine().split(" ");
      int a = Integer.parseInt(inp1[0]);
      int b = Integer.parseInt(inp1[1]);
      int ai = binSearch(arr, a-1);
      int bi = binSearch(arr, b);
      /*
      System.out.println(a + ": " + ai);
      System.out.println(b + ": " + bi);
      System.out.println("____");
      */
      pw.println(bi - ai);
    }
    pw.close();
  } // 2  3  5  7
  //   0  1  2  3
  public static int binSearch(int[] list, int limit) {
		if(list[0] > limit) {
			return 0;
		}
		int min = 0;
		int max = list.length-1;
		// list[min] is guaranteed to be <= limit
		while(min != max) {
			int mid = (min+max+1)/2;
			if(list[mid] <= limit) {
				min = mid;
			}
			else {
				max = mid-1;
			}
		}
		return min + 1;
	}
}
