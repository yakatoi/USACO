/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadIII {

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
      String input1 = "cowqueue.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);

      int n = sc.nextInt();
      Map<Long, Long> map = new HashMap<Long, Long>();
      for (int i = 0; i < n; i++) {
        map.put(sc.nextLong(), sc.nextLong());
      }

      LinkedHashMap<Long, Long> sortedMap = new LinkedHashMap<Long, Long>();
      map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

      List<Long> a = new ArrayList<Long>(sortedMap.keySet());
      List<Long> b = new ArrayList<Long>(sortedMap.values());

      long t = 0;
      for (int i = 0; i < a.size(); i++) {
        if (t <= a.get(i)) {
          t = a.get(i)+b.get(i);
        }
        else {
          t+=b.get(i);
        }
      }
      if (map.size()==n || n<100) {
        pw.println(t);
      }
      else {
        pw.println(n*b.get(0)+a.get(0));
      }

      pw.close();

   }
}
