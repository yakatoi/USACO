import java.util.*;
import java.io.*;
import java.math.*;
public class BreedAssignment {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("assign.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("assign.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    /*
    for (int i = 0; i < n; i++) {graph.put(i, new HashSet<Edge>());}
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      graph.get(a).add(new Edge(b, type));
      graph.get(b).add(new Edge(a, type));
    }
    System.out.println(graph);
    System.out.println(Arrays.toString(b3(9L)));
    */
    int[][] inp = new int[k][3];
    ArrayList<Pair> same = new ArrayList<Pair>();
    ArrayList<Pair> diff= new ArrayList<Pair>();
    for (int i = 0; i < k; i++) {
      String[] s = br.readLine().split(" ");
      if (s[0].equals("S")) {
        same.add(new Pair(Integer.parseInt(s[1])-1, Integer.parseInt(s[2])-1));
      }
      else {
        diff.add(new Pair(Integer.parseInt(s[1])-1, Integer.parseInt(s[2])-1));
      }
    }
    long hi = 1;
    for (int i = 1; i <= n; i++) {
      hi *=3;
    }
    long counter = 0;
    for (long i = 0L; i < hi; i++) {
      String[] three = b3(i, n);
      boolean check = true;
      for (int j =0 ; j < same.size(); j++) {
        if (!three[same.get(j).a].equals(three[same.get(j).b])) {
          check = false;
          break;
        }
      }
      if (check) {
        for (int j =0 ; j < diff.size(); j++) {
          if (three[diff.get(j).a].equals(three[diff.get(j).b])) {
            check = false;
            break;
          }
        }
      }
      if (check) {
        counter++;
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static String[] b3(long num, int n) {
    long ret = 0;
    long factor = 1;
    while (num > 0) {
        ret += num % 3 * factor;
        num /= 3;
        factor *= 10;
    }
    String ans = ret + "";
    while (ans.length()!=n) {
      ans = "0" + ans;
    }
    return ans.split("");
  }
  public static class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b=b;
    }
    public String toString() {
      return "(" + a + ", " + b + ")";
     }
  }
}
