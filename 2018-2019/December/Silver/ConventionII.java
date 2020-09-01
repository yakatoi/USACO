import java.util.*;
import java.io.*;

public class ConventionII {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
      int n = Integer.parseInt(br.readLine());
      Cow[] arr = new Cow[n];
      for (int i = 0; i < n; i++) {
         int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
         arr[i] = new Cow(i+1, inp[0], inp[1]);
         }

      Arrays.sort(arr, (a, b) -> a.t-b.t);

      PriorityQueue<Cow> pq = new PriorityQueue<Cow>();
      int longestWait = 0;
      int endTime = 0;
      int i = 0;
      while (i < n) {
         if (endTime < arr[i].t) {
            endTime = arr[i].t + arr[i].w;
            i++;
            }
         else {
            while (arr[i].t < endTime) {
               pq.add(arr[i]);
               i++;
               }
            while (!pq.isEmpty()) {
               Cow c = pq.poll();
               longestWait = Math.max(longestWait, endTime - c.t);
               endTime = endTime + c.w;
               }
            i++;
            }

         }
      pw.println(longestWait);
      pw.close();
      }

   public static class Cow implements Comparable<Cow> {

      int s = 0;
      int t = 0;
      int w = 0;

      public Cow(int s, int t, int w) {
         this.s = s;
         this.t = t;
         this.w = w;
         }

      public Cow(Cow c) {
         s = c.s;
         t = c.t;
         w = c.w;
         }

      public int compareTo(Cow c) {
         return s-c.s;
         }

      public String toString() {
         return "(" + s + ", " + t + ", " + w + ")";
         }

      }

   }
