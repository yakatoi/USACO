import java.util.*;
import java.io.*;

public class OutOfSorts {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
    int n = Integer.parseInt(br.readLine());
    int[] fir = new int[n];
    for (int i = 0; i < n; i++) {
      fir[i] = Integer.parseInt(br.readLine());
    }
    int[] arr = fir.clone();
    Arrays.sort(arr);
    System.out.println(Arrays.toString(fir));
    System.out.println(Arrays.toString(arr));
    int maxDif = 0;
    for (int q = 0; q < n; q++) {
      System.out.println(q + ":" + (q-Arrays.binarySearch(arr, fir[q])));
      maxDif = Math.max(Math.abs(q - Arrays.binarySearch(arr, fir[q])), maxDif);
    }
    System.out.println(maxDif+1);
    pw.close();
  }
  public static void swap(int[] arr, int a, int b) {
    int temp = arr[b];
    arr[b] = arr[a];
    arr[a] = temp;
  }

  public static int binSearch(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length-1;
    int mid = (lo+hi)/2;
    while (lo!=hi) {
      mid = (lo+hi)/2;
      if (arr[mid]==key) {
        return mid;
      }
      if (arr[mid] > key) {
        hi = mid - 1;
        mid = (lo+hi)/2;
      }
      else {
        lo = mid + 1;
        mid = (lo+hi)/2;
      }
    }
    return mid;
  }
}
