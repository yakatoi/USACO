/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class DontBeLast {

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
      String input1 = "notlast.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      Map<String, Integer> map = new HashMap<String, Integer>();
      map.put("Bessie", 0);
      map.put("Elsie", 0);
      map.put("Daisy", 0);
      map.put("Gertie", 0);
      map.put("Annabelle", 0);
      map.put("Maggie", 0);
      map.put("Henrietta", 0);
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        String[] inp = sc.nextLine().split(" ");
        map.replace(inp[0], map.get(inp[0]) + Int(inp[1]));
      }
      LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
      map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

      List<String> a = new ArrayList<String>(sortedMap.keySet());
      List<Integer> b = new ArrayList<Integer>(sortedMap.values());
      boolean stop = false;
      int min = b.get(0);
      int smin = -1;
      String ans = "";
      int notZero = 0;
      int notIndex = -1;
      for (int i = 0; i < b.size(); i++) {
        if (b.get(i)!=0) {
          notZero++;
          notIndex = i;
        }
      }
      if (notZero==1) {
        pw.println(a.get(notIndex));
      }
      else {
        for (int i = 0; i < b.size(); i++) {
          if (b.get(i)==0 && b.size()==7 && notZero!=2) {
            pw.println("0");
            stop = true;
            break;
          }
          if (smin==-1 && b.get(i)!=min) {
            smin = b.get(i);
            ans = a.get(i);
          }
        }
        if (smin==-1 && !stop) {
          pw.println("Tie");
          stop = true;
        }
        if (Collections.frequency(b, smin)>1) {
          if (!stop) {
            pw.println("Tie");
          }
        }
        else {
          if (!stop) {
            pw.println(ans);
          }
        }
      }
      //pw.println(sortedMap);
      //pw.println(a);
      //pw.println(b);
      pw.close();

   }
}
