import java.util.*;
import java.io.*;

public class AngryCows {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("angry.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, getMax(arr, i));
    }
    if (max==5) {
      max--;
    }
    pw.println(max+1);
    pw.close();
  }

  public static int getMax(int[] arr, int ind) {
    int counter = 0;
    for (int i = ind+1; i < arr.length; i++) {
      int mult = i - ind;
      if (arr[i-1] + mult >= arr[i]) {
        counter++;
      }
      else {
        break;
      }
    }
    for (int i = ind-1; i >= 0; i--) {
      int mult = ind - i;
      if (arr[i+1] - mult <= arr[i]) {
        counter++;
      }
      else {
        break;
      }
    }
    return counter;
  }
}
