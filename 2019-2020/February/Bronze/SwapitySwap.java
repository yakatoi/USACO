import java.util.*;
import java.io.*;

public class SwapitySwap {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("swap.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int a1 = Integer.parseInt(st.nextToken())-1;
    int a2 = Integer.parseInt(st.nextToken())-1;
    st = new StringTokenizer(br.readLine());
    int b1 = Integer.parseInt(st.nextToken())-1;
    int b2 = Integer.parseInt(st.nextToken())-1;
    int[] smallrev = new int[n];
    for (int i = 0; i < n; i++) {
      smallrev[i] = smallestRepetition(a1, a2, b1, b2, n, i);
    }
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = doNrepetitions(a1, a2, b1, b2, i, k%smallrev[i], n);
    }
    for (int in: ans) {
      pw.println(in+1);
    }
    pw.close();


  }
  public static int smallestRepetition(int a1, int a2, int b1, int b2, int n, int index) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {arr[i]=i;}
    int[] orig = arr.clone();
    int counter = 1;
    changeArray(arr, a1, a2);
    changeArray(arr, b1, b2);
    while (orig[index]!=arr[index]) {
      changeArray(arr, a1, a2);
      changeArray(arr, b1, b2);
      counter++;
    }
    return counter;

  }

  public static void changeArray(int[] arr, int i1, int i2) {
    for (int i = i1; i <= (i1+i2)/2; i++) {
      int temp = arr[i];
      arr[i] = arr[i1+i2-i];
      arr[i1+i2-i] = temp;
    }
  }

  public static int doNrepetitions(int a1, int a2, int b1, int b2, int index, int rep, int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {arr[i]=i;}
    for (int i = 0; i < rep; i++) {
      changeArray(arr, a1, a2);
      changeArray(arr, b1, b2);
    }
    return arr[index];
  }

}
