import java.util.*;
import java.io.*;

public class CowBaseball {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("baseball.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("baseball.out"));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    //System.out.println(Arrays.toString(arr));
    int counter = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j< n; j++) {
        int dist = arr[j] - arr[i];
        int a = Arrays.binarySearch(arr, arr[j] + dist);
        int b = Arrays.binarySearch(arr, arr[j] + 2*dist);
        if (a < 0) {
          a*=-1;
          a--;
        }
        if (b < 0) {
          b*=-1;
          b-=2;
        }
        // System.out.println((arr[j] + dist)+" "+(arr[j]+2*dist));
        // System.out.println("(" + arr[i] +", " + arr[j]+")" + ": "+a + " "+ b);
        counter+=b-a+1;
      }
    }
    pw.println(counter);
    pw.close();
  }
}
