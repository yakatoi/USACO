import java.util.*;
import java.io.*;

public class FieldReduction {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
    int n = Integer.parseInt(br.readLine());
    int b1 = 40001;int b2 = 40001;int t1 = 0;int t2 = 0;int l1 = 40001;int l2 = 40001;int r1 = 0;int r2 = 0;
    int ib1=0;int ib2=0;int it1=0;int it2 = 0;int il1 = 0;int il2 = 0;int ir1 = 0;int ir2 = 0;
    int[][] queries = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      queries[i][0] = Integer.parseInt(st.nextToken());
      queries[i][1] = Integer.parseInt(st.nextToken());
      int x = queries[i][0];
      int y = queries[i][1];
      if (x > r1) {
        r1 = x;
        ir1 = i;
      }
      else if (x > r2) {
        r2 = x;
        ir2 = i;
      }
      if (x < l1) {
        l1 = x;
        il1 = i;
      }
      else if (x < l2) {
        l2 = x;
        il2 = i;
      }
      if (y > t1) {
        t1 = y;
        it1 = i;
      }
      else if (y > t2) {
        t2 = y;
        it2 = i;
      }
      if (y < b1) {
        b1= y;
        ib1 = i;
      }
      else if (y < b2) {
        b2 = y;
        ib2 = i;
      }
    }
    /**
    System.out.println("t1: " + t1);
    System.out.println("t2: " + t2);
    System.out.println("b1: " + b1);
    System.out.println("b2: " + b2);
    System.out.println("l1: " + l1);
    System.out.println("l2: " + l2);
    System.out.println("r1: " + r1);
    System.out.println("r2: " + r2);
    **/
    int a = findAreaWithOneIndiceRemoved(queries, ib1);
    int b = findAreaWithOneIndiceRemoved(queries, it1);
    int c = findAreaWithOneIndiceRemoved(queries, il1);
    int d = findAreaWithOneIndiceRemoved(queries, ir1);
    pw.println(Math.min(Math.min(a, b), Math.min(c, d)));
    pw.close();
  }
  public static int findAreaWithOneIndiceRemoved(int[][] queries, int index) {
    int b1 = 40001;int b2 = 40001;int t1 = 0;int t2 = 0;int l1 = 40001;int l2 = 40001;int r1 = 0;int r2 = 0;
    for (int i = 0; i < queries.length; i++) {
      if (i!=index) {
        int x = queries[i][0];
        int y = queries[i][1];
        if (x > r1) {
          r1 = x;
        }
        else if (x > r2) {
          r2 = x;
        }
        if (x < l1) {
          l1 = x;
        }
        else if (x < l2) {
          l2 = x;
        }
        if (y > t1) {
          t1 = y;
        }
        else if (y > t2) {
          t2 = y;
        }
        if (y < b1) {
          b1= y;
        }
        else if (y < b2) {
          b2 = y;
        }
      }
    }
    return (t1-b1)*(r1-l1);
  }
}
