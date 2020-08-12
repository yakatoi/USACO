/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class BlockedBillboardII {

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
  public static void println(Object o) {System.out.println(o);}
  public static void print(Object o) {System.out.print(o);}
  public static int Int(String s) {return Integer.parseInt(s);}
  public static int max(int... x) {int curr = x[0];for (int n:x) {curr = Math.max(curr, n);}return curr;}
  public static int min(int... x) {int curr = x[0];for (int n:x) {curr = Math.min(curr, n);}return curr;}


   public static void main(String[] args) throws IOException{
      String input1 = "billboard.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);

      int[] a = new int[4];
      int[] b = new int[4];
      for (int i = 0; i < 4; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < 4; i++) {
        b[i] = sc.nextInt();
      }
      pw.println(areaLeft(a, b));


      pw.close();

   }

   public static boolean isBet(int x, int y, int z) {
     return (x <= z && y >= z) || (x >= z && y <= z);
   }

  public static int areaLeft(int[] a, int[] b) {
    if (isBet(b[0], b[2], a[0]) && isBet(b[0], b[2], a[2]) && isBet(b[1], b[3], a[1]) && isBet(b[1], b[3], a[3])) {
      return 0;
    }
    if (isBet(a[0], a[2], b[0]) && isBet(a[0], a[2], b[2]) && isBet(a[1], a[3], b[1]) && isBet(a[1], a[3], b[3])) {
      return (a[3]-a[1])*(a[2]-a[0]);
    }
    if (isBet(b[1], b[3], a[1]) && isBet(b[1], b[3], a[3]) && isBet(a[0], a[2], b[0])) {
      return (a[3]-a[1])*(b[0]-a[0]);
    }
    if (isBet(b[0], b[2], a[0]) && isBet(b[0], b[2], a[2]) && isBet(b[1], b[3], a[3])) {
      return (a[2]-a[0])*(b[1]-a[1]);
    }
    if (isBet(b[1], b[3], a[1]) && isBet(b[1], b[3], a[3]) && isBet(a[0], a[2], b[2])) {
      return (a[3]-a[1])*(a[2]-b[2]);
    }
    if (isBet(b[0], b[2], a[0]) && isBet(b[0], b[2], a[2]) && isBet(b[1], b[3], a[1])) {
      return (a[2]-a[0])*(a[3]-b[3]);
    }
    return (a[3]-a[1])*(a[2]-a[0]);

  }


}
