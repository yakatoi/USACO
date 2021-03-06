/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class CowSignal {

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
      String input1 = "cowsignal.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      int m = sc.nextInt();
      int n = sc.nextInt();
      int k = sc.nextInt();
      String[][] arr = new String[m][n];
      for (int i = 0; i < m; i++) {
        String[] inp = sc.nextLine().split("");
        for (int j = 0; j < n; j++) {
          arr[i][j] = inp[j];
        }
      }
      for (int i = 0; i < m; i++) {
        for (int b = 0; b < k; b++) {
          for (int j = 0; j < n; j++) {
            for (int a = 0; a < k; a++) {
              pw.print(arr[i][j]);
            }
          }
          pw.println("");
        }

      }
      pw.close();

   }
}
