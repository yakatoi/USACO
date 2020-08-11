/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class CowTipping {

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
      String input1 = "cowtip.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      int n = sc.nextInt();
      String[][] arr = new String[n][n];
      for (int i = 0; i < n; i++) {
        String[] inp = sc.nextLine().split("");
        for (int j = 0; j < n; j++) {
          arr[i][j] = inp[j];
        }
      }
      int counter = 0;
      for (int i = n-1; i >=0; i--) {
        for (int j = n-1; j >=0; j--) {
          if (arr[i][j].equals("1")) {
            arr = invert(arr, i, j).clone();
            counter++;
          }
        }
      }
      pw.println(counter);
      pw.close();

   }

  public static String[][] invert(String[][] arr, int a, int b) {
    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {
        if (arr[i][j].equals("1")) {
          arr[i][j]= "0";
        }
        else {
          arr[i][j] = "1";
        }
      }
    }
    return arr;
  }
}
