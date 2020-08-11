/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class BovineGenomics {

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
      String input1 = "cownomics.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
      FastReader sc = new FastReader(input1);

      int n = sc.nextInt();
      int m = sc.nextInt();
      String[][] spotty = new String[n][m];
      String[][] plain = new String[n][m];
      for (int i = 0; i < n; i++) {
        String[] inp = sc.nextLine().split("");
        for (int j = 0; j < inp.length; j++) {
          spotty[i][j] = inp[j];
        }
      }
      for (int i = 0; i < n; i++) {
        String[] inp = sc.nextLine().split("");
        for (int j = 0; j < inp.length; j++) {
          plain[i][j] = inp[j];
        }
      }
      int counter = 0;
      boolean isThere = true;
      for (int i = 0; i < m; i++) {
        isThere = true;
        Set<String> set = new HashSet<String>();
        for (int j = 0; j < n; j++) {
          set.add(spotty[j][i]);
        }
        for (int j = 0; j < n; j++) {
          if (set.contains(plain[j][i])) {
            isThere = false;
          }
        }
        if (isThere) {
          counter++;
        }
      }
      pw.println(counter);

      pw.close();

   }
}
