import java.util.*;
import java.io.*;

public class MilkVisits {

  public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    String[] cows = br.readLine().split("");
    for (int i = 0; i < n; i++) {
      graph.put(i, new HashSet<Integer>());
    }
    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    //System.out.println(graph);
    boolean[] isPart = new boolean[n];
    int counter = 1;
    HashMap<Integer, Type> which = new HashMap<Integer, Type>();
    for (int i = 0; i < n; i++) {
      if (!isPart[i]) {
        HashSet<Integer> set = new HashSet<Integer>();
        String ident = cows[i];
        which.put(i, new Type(counter, ident));
        isPart[i] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        set.add(i);
        q.add(i);
        while (!q.isEmpty()) {
          int v = q.poll();
          for (int e : graph.get(v)) {
            if (!isPart[e] && cows[e].equals(ident)) {
              set.add(e);
              q.add(e);
              which.put(e, new Type(counter, ident));
              isPart[e] = true;
            }
          }
        }
        counter++;
      }
    }
    String ans = "";
    for (int i = 0; i < m; i++) {
      String[] inp = br.readLine().split(" ");
      int a = Integer.parseInt(inp[0])-1;
      int b = Integer.parseInt(inp[1])-1;
      String cow = inp[2];
      if (which.get(a).num == which.get(b).num && !cow.equals(which.get(a).t)) {
        ans+="0";
      }
      else {
        ans+="1";
      }
    }
    //System.out.println(which);
    pw.println(ans);
    pw.close();
  }
  public static class Type {
    public int num;
    public String t;

    public Type(int num, String t) {
      this.num = num;
      this.t = t;
    }
    public String toString() {
      return "(" + num + ", " + t + ")";
    }

    public int compareTo(Type type) {
      return type.num==num && type.t == t ? 0 : -1;
    }
  }
}
