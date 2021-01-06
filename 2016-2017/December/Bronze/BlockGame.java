/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class BlockGame {

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
      String input1 = "blocks.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      int n = sc.nextInt();
      int[] ans = new int[26];
      int sum = 0;
      for (int counter = 0; counter < n; counter++) {
        String[] inp = sc.nextLine().split(" ");
        ArrayList<String> a = new ArrayList<String>(Arrays.asList(inp[0].split("")));
        ArrayList<String> b = new ArrayList<String>(Arrays.asList(inp[1].split("")));
        for (String i:a) {
          b.remove(i);
        }
        for (String i:a) {
          ans[((int) i.charAt(0))-97]++;
        }
        for (String i:b) {
          ans[((int) i.charAt(0))-97]++;
        }
      }
      for (int c: ans) {
        pw.println(c);
      }
      pw.close();

   }

  public static int sumArr(int[] arr) {
    int ans = 0;
    for (int n: arr) {
      ans+=n;
    }
    return ans;
  }
}
