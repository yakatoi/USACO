import java.util.*;
import java.io.*;

public class DanceMooves {
  static int n, k;
  static TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>();
  static TreeMap<Integer, TreeSet<Integer>> pos = new TreeMap<Integer, TreeSet<Integer>>();
  static int[] comp;
  static int[] arr;
  static int counter = 1;
  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  =new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new int[n];
    comp= new int[n];
    for (int i =0; i< n; i++) arr[i] = i;
    for (int i =0; i< n; i++) map.put(i, new TreeSet<Integer>(Collections.singleton(i)));
    for (int i = 0; i < k; i++) {
      st  =new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      a--;b--;
      map.get(arr[a]).add(b);
      map.get(arr[b]).add(a);
      int temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;

    }
    // for (int i = 0; i < n; i++) {
    //   System.out.println(map.get(i));
    // }
    for (int i = 0; i < n; i++) {
      if (comp[i] ==0 ) {
        dfs(i);
        counter++;
      }
    }
    for (int i = 1; i < counter; i++) {
      pos.put(i, new TreeSet<Integer>());
    }
    for (int i = 0; i < n; i++) {
      pos.get(comp[i]).addAll(map.get(i));
    }
    for (int i = 0; i < n; i++) {
      System.out.println(pos.get(comp[i]).size());
    }
  }
  static void dfs(int ind) {
    comp[ind] = counter;
    if (comp[arr[ind]] ==0) {
      dfs(arr[ind]);
    }
  }
}
