/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadI {

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
      String input1 = "crossroad.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      int[] arr = new int[10];
      for (int i = 0; i < arr.length; i++) {
        arr[i]=-1;
      }
      int counter = 0;
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        int a = sc.nextInt()-1;
        int b = sc.nextInt();
        if (arr[a]==-1) {
          arr[a] = b;
        }
        else {
          if (arr[a]!=b) {
            counter++;
            arr[a] = b;
          }
        }
      }
      pw.println(counter);
      pw.close();

   }
}
