import java.util.*;
import java.io.*;

public class ShellGame {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("shell.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
    int n = Integer.parseInt(br.readLine());
    int[][] inp = new int[n][3];
    for (int i = 0; i < n; i++) {
      String[] inps = br.readLine().split(" ");
      inp[i][0] = Integer.parseInt(inps[0])-1;
      inp[i][1] = Integer.parseInt(inps[1])-1;
      inp[i][2] = Integer.parseInt(inps[2])-1;
    }
    int[] i = new int[3];
    i[0] = 0; i[1] = 0; i[2] = 1;
    int ans = simulate(i.clone(), inp, n);
    swap(i, 1, 2);
    ans = Math.max(ans, simulate(i.clone(), inp, n));
    swap(i, 0, 1);
    ans = Math.max(ans, simulate(i.clone(), inp, n));
    pw.println(ans);
    pw.close();
  }

  public static int simulate(int[] arr, int[][] inp, int n) {
    int counter = 0;

    for (int i = 0; i < n; i++) {
      swap(arr, inp[i][0], inp[i][1]);
      if (arr[inp[i][2]]==1) {
        counter++;
      }
    }
    return counter;
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
