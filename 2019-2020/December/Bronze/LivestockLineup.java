import java.util.*;
import java.io.*;

public class LivestockLineup {
   public static TreeSet<String> set = new TreeSet<String>();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
      int n = Integer.parseInt(br.readLine());
      String[][] inp = new String[n][2];
      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine().replace(" must be milked beside ", " ").replace("Beatrice", "1").replace("Belinda", "2").replace("Bella", "3").replace("Bessie", "4").replace("Betsy", "5").replace("Blue", "6").replace("Buttercup", "7").replace("Sue", "8"));
         inp[i][0] = (st.nextToken());
         inp[i][1] = (st.nextToken());
         }
      permutation("", "12345678", inp);
      String[] ans = set.first().split("");
      for (int i = 0; i < ans.length; i++) {
        if (ans[i].equals("1")) pw.println("Beatrice");
        if (ans[i].equals("2")) pw.println("Belinda");
        if (ans[i].equals("3")) pw.println("Bella");
        if (ans[i].equals("4")) pw.println("Bessie");
        if (ans[i].equals("5")) pw.println("Betsy");
        if (ans[i].equals("6")) pw.println("Blue");
        if (ans[i].equals("7")) pw.println("Buttercup");
        if (ans[i].equals("8")) pw.println("Sue");
      }
      pw.close();

      }

   public static void permutation(String news, String str, String[][] inp) {
      if(str.length()==0) {
         boolean yes = true;
         for (int i = 0; i < inp.length; i++) {
            if (!isNext(inp[i][0], inp[i][1], news)) {
               yes = false;
               }
            }
         if (yes) {
            set.add(news);
            }
         }
      for(int i=0; i< str.length(); i++) {
         String neww = str.replaceFirst(str.charAt(i)+"", "");
         permutation(news + str.charAt(i), neww, inp);
         }
      }
  public static boolean isNext(String a, String b, String c) {
      String[] array = c.split("");
      //pw.println(a + " " + b + " " + c);
      int in = 0;
      for (int i = 0; i < array.length; i++) {
          if (a.equals(array[i])) {
            in = i;
            break;
          }
        }
      if (in==0) {
         return b.equals(array[1]);
         }
      if (in==array.length-1) {
         return b.equals(array[array.length-2]);
         }
      return (b.equals(array[in-1])) || (b.equals(array[in+1]));
      }
   }
