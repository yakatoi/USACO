import java.util.*;
import java.io.*;

public class LivestockLineup {
   public static TreeSet<String> set = new TreeSet<String>();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
      int n = Integer.parseInt(br.readLine());
      String[][] queries = new String[n][2];
      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine().replace(" must be milked beside ", " ").replace("Beatrice", "1").replace("Belinda", "2").replace("Bella", "3").replace("Bessie", "4").replace("Betsy", "5").replace("Blue", "6").replace("Buttercup", "7").replace("Sue", "8"));
         queries[i][0] = (st.nextToken());
         queries[i][1] = (st.nextToken());
         }
      perm("", "12345678", queries);
      String[] ans = set.first().split("");
      for (int i = 0; i < ans.length; i++) {
        if (ans[i].equals("1")) {pw.println("Beatrice");}
        if (ans[i].equals("2")) {pw.println("Belinda");}
        if (ans[i].equals("3")) {pw.println("Bella");}
        if (ans[i].equals("4")) {pw.println("Bessie");}
        if (ans[i].equals("5")) {pw.println("Betsy");}
        if (ans[i].equals("6")) {pw.println("Blue");}
        if (ans[i].equals("7")) {pw.println("Buttercup");}
        if (ans[i].equals("8")) {pw.println("Sue");}
      }
      pw.close();

      }

   public static void perm(String news, String rem, String[][] queries) {
      if(rem.length()==0) {
         boolean yes = true;
         for (int i = 0; i < queries.length; i++) {
            if (!isNext(queries[i][0], queries[i][1], news)) {
               yes = false;
               }
            }
         if (yes) {
            set.add(news);
            }
         }
      for(int i=0; i<rem.length(); i++) {
         String newr = rem.replaceFirst(rem.charAt(i)+"", "");
         perm(news + rem.charAt(i), newr, queries);
         }
      }
   public static boolean isNext(String a, String b, String c) {
      String[] arr = c.split("");
      //pw.println(a + " " + b + " " + c);
      int index = 0;
      for (int i = 0; i < arr.length; i++) {
         if (a.equals(arr[i])) {
            index = i;
            break;
            }
         }
      if (index==0) {
         return b.equals(arr[1]);
         }
      if (index==arr.length-1) {
         return b.equals(arr[arr.length-2]);
         }
      return (b.equals(arr[index-1])) || (b.equals(arr[index+1]));
      }
   }
