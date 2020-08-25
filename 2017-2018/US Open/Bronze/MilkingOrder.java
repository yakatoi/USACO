import java.util.*;
import java.io.*;

public class MilkingOrder {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    int k = Integer.parseInt(inp[2]);
    int[] arr = new int[n];
    int[] cond = new int[m];
    String[] inp1 = br.readLine().split(" ");
    for (int i = 0; i < m; i++) {
      cond[i] = Integer.parseInt(inp1[i]);
    }
    for (int i = 0; i < k; i++) {
      String[] inp2 = br.readLine().split(" ");
      arr[Integer.parseInt(inp2[1])-1] = Integer.parseInt(inp2[0]);
    }
    TreeSet<Integer> set = new TreeSet<Integer>();
    for (int i = 0; i < n; i++) {
      if (arr[i]==0) {
        set.add(i);
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(cond));
    System.out.println(set);

    for (int index : set) {
      int[] a = arr.clone();
      a[index] = 1;
      TreeSet<Integer> s = new TreeSet<Integer>(set.clone());
      for (int it: s) {
        
      }
    }



  }

  public static boolean in(int[] arr, int val) {
    for (int i: arr) {
      if (i==val) {
        return true;
      }
    }
    return false;
  }
}
