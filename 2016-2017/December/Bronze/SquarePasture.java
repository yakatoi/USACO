/*
ID: srihank1
LANG: JAVA
PROG: square
*/
import java.util.*;
import java.io.*;

public class SquarePasture {

  public static class FastReader {/* Fast class in order to quickly read inputs*/

     BufferedReader br;StringTokenizer st;
      FastReader(InputStream stream) {
         try {br = new BufferedReader(new InputStreamReader(stream));}
         catch (Exception e) {e.printStackTrace();}}
      public FastReader(String str) throws IOException {br = new BufferedReader(new FileReader(str));}
      String next() {
         while (st == null || !st.hasMoreElements()) {
            try {st = new StringTokenizer(br.readLine());}
            catch (IOException  e) {e.printStackTrace();}}
         return st.nextToken();}
      int nextInt() {
         return Integer.parseInt(next());}
      long nextLong() {
         return Long.parseLong(next());}
      double nextDouble() {
         return Double.parseDouble(next());}
      char nextChar() {
         return (next().charAt(0));}
      String nextLine() {String str = "";
         try {str = br.readLine();}
         catch (IOException e) {e.printStackTrace();}
         return str;}}
  public static void println(Object o) {
    System.out.println(o);
  }
  public static void print(Object o) {
    System.out.print(o);
  }
  public static int Int(String s) {
    return Integer.parseInt(s);
  }
  public static String str(Object x) {
    return x+"";
  }
  public static int max(int... x) {
    int curr = x[0];
    for (int n:x) {
      curr = Math.max(curr, n);
    }
    return curr;
  }

  public static int min(int... x) {
     int curr = x[0];
     for (int n:x) {
           curr = Math.min(curr, n);
        }
     return curr;
     }



   public static void main(String[] args) throws IOException{
      String input1 = "square.in";
      String input2 = "input.txt";
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

      int[] a = new int[4];
      int[] b = new int[4];

      for (int i = 0; i < 4; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < 4; i++) {
        b[i] = sc.nextInt();
      }

      int lbound = min(a[0], b[0]);
      int rbound = max(a[2], b[2]);
      int ubound = max(a[3], b[3]);
      int bbound = min(a[1], b[1]);

      int side = max(rbound-lbound, ubound-bbound);

      pw.println(side*side);


      pw.close();

   }
}
