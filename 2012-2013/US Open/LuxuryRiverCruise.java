import java.util.*;
import java.io.*;

public class LuxuryRiverCruise {
  static int n, m;
  static long k;
  static int[][] dir;
  static HashMap<Integer, Integer> graph = new HashMap<Integer, Integer>();
  static int[] group;
  static int counter = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cruise.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cruise.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Long.parseLong(st.nextToken());
    dir = new int[n][2];
    group = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      dir[i][0] = a;
      dir[i][1] = b;
    }
    int[] inp = Arrays.stream(br.readLine().replaceAll("L", "0").replaceAll("R", "1").split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    for (int i = 0; i < n; i++) {
      int end = i;
      for (int ele: inp) {
        end = dir[end][ele];
      }
      graph.put(i, end);
    }
    for (int i = 0; i < n; i++) {
      if (group[i] ==0 ){
        dfs(i);
        counter++;
      }
    }
    System.out.println(Arrays.toString(group));
    long[] countG = new long[n+1];
    for (int ele : group) countG[ele]++;
    long result = 1;
    for (long ele : countG) {
      if (ele != 0) {
        result = (ele*result)/gcd(ele, result);
      }
    }
    if (k > 5000000L) {
      k = k % result;
    }
    int end = 0;
    for (int i = 0; i < k; i++) {
      end = graph.get(end);
    }
    System.out.println(end+1);
    pw.println(end+1);
    pw.close();
  }
  static long gcd(long a, long b) {
    if (a*b==0) return a+b;
    if (a > b) return gcd(a%b, b);
    return gcd(a, b%a);
  }
  static void dfs(int node) {
    group[node] = counter;
    int ele = graph.get(node);
    if (group[ele] == 0) {
      dfs(ele);
    }

  }
}
