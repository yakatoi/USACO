import java.util.*;
import java.io.*;

public class Typo {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("typo.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("typo.out"));
    String[] inp = br.readLine().split("");
    int n = inp.length;
    int[] arr = new int[n];
    int end = 0;
    int beg = 0;
    if (int i = 0; i )
    for (int i = 0; i < n; i++) {
      arr[i] = inp[i].equals("(") ? 1 : -1;
      if (arr[i]==1) {
        beg++;
      }
      else {
        end++;
      }
    }
    int ans;
    if (beg > end) {
      for (int i = 0; i < n; i++) {
        arr[i]*=-1;
      }
      for (int i = 0; i < n/2-1; iw++) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
      }
    }
    int places = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i]==-1) {
        places++;
      }
      sum+=arr[i];
      if (sum < 0) {
        break;
      }
    }
    ans =places;
    if (end==beg) {
      ans = 0;
    }
    pw.println(ans);
    pw.close();

  }
}
