import java.util.*;
import java.io.*;

public class PaintingTheFence {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("paint.in"));
    PrintWriter pw= new PrintWriter(new FileWriter("paint.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int inp = Integer.parseInt(st.nextToken());
      if (st.nextToken().equals("L")) inp*=-1;
      arr[i] = inp;
    }
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    map.put(0,0);
    int x = 0;
    for (int ele: arr) {
      x+=ele;
      map.put(x, 0);
    }
    x = 0;
    for (int ele : arr) {
      if (ele > 0) {
        map.put(x, map.get(x)+1);
        x+=ele;
        map.put(x, map.get(x)-1);
      }
      else {
        map.put(x, map.get(x)-1);
        x+=ele;
        map.put(x, map.get(x)+1);
      }
    }
    int prevval = 0;
    for (int key: map.keySet()) {
      map.put(key, map.get(key)+prevval);
      prevval = map.get(key);
    }
    ArrayList<Integer> values = new ArrayList<Integer>();
    int sum = 0;
    int start = Integer.MAX_VALUE;
    for (int key : map.keySet()) {
      int val = map.get(key);
      if (start==Integer.MAX_VALUE && val >= k) {
        start = key;
      }
      else if (start!=Integer.MAX_VALUE && val < k) {
        values.add(start);
        values.add(key);
        start = Integer.MAX_VALUE;
      }
    }
    for (int i = 1; i < values.size(); i+=2) {
      sum+=values.get(i)-values.get(i-1);
    }
    pw.println(sum);
    pw.close();
    // System.out.println(values);
    // System.out.println(map);
  }
}
