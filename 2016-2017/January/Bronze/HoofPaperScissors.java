/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class HoofPaperScissors {

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
      String input1 = "hps.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
      FastReader sc = new FastReader(input2);
      //FastReader sc = new FastReader(System.in);
      int n = sc.nextInt();
      int[][] inp = new int[n][2];
      for (int i = 0; i < n; i++) {
        inp[i][0] =  sc.nextInt();
        inp[i][1] =  sc.nextInt();
      }
      int max = -1;

      int count = 0;
      for (int i = 0; i < n; i++) {
        if (inp[i][0]==1 && inp[i][1]==2) {
          count++;
        }
        else if(inp[i][0]==2 && inp[i][1]==3) {
          count++;
        }
        else if (inp[i][0]==3 && inp[i][1]==1) {
          count++;
        }
      }
      max = max(max, count);
      count = 0;
      for (int i = 0; i < n; i++) {
        if (inp[i][0]==2 && inp[i][1]==1) {
          count++;
        }
        else if(inp[i][0]==3 && inp[i][1]==2) {
          count++;
        }
        else if (inp[i][0]==1 && inp[i][1]==3) {
          count++;
        }
      }
      max = max(max, count);
      println(count);
      pw.close();

   }
}
