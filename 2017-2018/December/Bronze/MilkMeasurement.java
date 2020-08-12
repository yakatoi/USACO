/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class MilkMeasurement {

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
      String input1 = "measurement.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);

      int n = sc.nextInt();

      HashMap<Integer, String> map = new HashMap<Integer, String>();
      for (int i = 0; i < n; i++) {
        String[] inps = sc.nextLine().split(" ");
        map.put(Int(inps[0]), (inps[1]+" " +inps[2]));
      }
      LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
      map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
      List<String> b = new ArrayList<String>(sortedMap.values());
      //println(Arrays.toString(inps));
      int[] count = new int[3];
      count[0] = 7;count[1] = 7;count[2] = 7;
      int numChange = 0;
      HashSet<Integer> top = new HashSet<Integer>();
      for (int counter = 0; counter < n; counter++) {
        b.set(counter, b.get(counter).replaceAll("Bessie", "0").replaceAll("Elsie", "1").replaceAll("Mildred", "2"));
        String[] inp = b.get(counter).split(" ");
        count[Int(inp[0])] = count[Int(inp[0])] + Int(inp[1]);
        if (!top.equals(new HashSet<Integer>(countTop(count)))) {
          numChange++;
        }
        top = new HashSet<Integer>(countTop(count));
      }
      pw.println(numChange);

      pw.close();

   }
  public static HashSet<Integer> countTop(int count[]) {
    int indexOfTop = -1;
    int max = -1;
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < count.length; i++) {
      if (count[i] > max) {
        indexOfTop = i;
        max = count[i];
      }
    }
    set.add(indexOfTop);
    for (int i = 0; i < count.length; i++) {
      if (count[i] == max && !set.contains(i)) {
        set.add(i);
      }
    }
    return set;

  }
}
