import java.util.*;
import java.io.*;

public class MilkMeasurement {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
      String[] nandg = br.readLine().split(" ");
      int n = Integer.parseInt(nandg[0]);
      int g = Integer.parseInt(nandg[1]);
      Entry[] arr = new Entry[n];
      for (int i = 0; i < n; i++) {
         String[] inp = br.readLine().split(" ");
         arr[i] = new Entry(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
         }
      Arrays.sort(arr);
      for (int i = 0; i < n; i++) {
         //System.out.println(arr[i].a + " " + arr[i].b + " " + arr[i].c);
         }
      int max = g;
      int counter = 0;
      HashSet<HashSet<Integer>> ans = new HashSet<HashSet<Integer>>();
      HashSet<Integer> winners = new HashSet<Integer>();
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      boolean isEmpty = true;
      int beforecounter = 0;
      for (int i = 0; i < n; i++) {
        isEmpty = winners.isEmpty();
        beforecounter = counter;
         ans.add(winners);
         if (!map.keySet().contains(arr[i].b)) {
            map.put(arr[i].b, g + arr[i].c);
            if (g+arr[i].c >= max) {
               counter++;
               if (g+arr[i].c > max) {
                  winners.clear();
                  }
               winners.add(arr[i].b);
               max = g + arr[i].c;
               }
            }
         else {
            map.replace(arr[i].b, map.get(arr[i].b) + arr[i].c);
            if (winners.contains(arr[i].b) & map.get(arr[i].b) < max) {
               winners.remove(arr[i].b);
               counter++;
               }
            else {
               if (map.get(arr[i].b) > max) {
                  max = map.get(arr[i].b);
                  if (!winners.contains(arr[i].b)) {
                     winners.clear();
                     counter++;
                     winners.add(arr[i].b);
                     }
                  }
               else if (map.get(arr[i].b) == max & !winners.contains(arr[i].b)) {
                  max = map.get(arr[i].b);
                  if (!winners.contains(arr[i].b)) {
                     counter++;
                     }
                  }
               }
            }
            if (beforecounter==counter) {
              if (winners.isEmpty()!= isEmpty) {
                counter++;
              }
            }
         }
      /*
      1 1 2
      4 2 -1
      7 3 3
      9 3 -1
      */
      for (HashSet<Integer> st: ans) {
        System.out.println(st);
      }
      //pw.close();

      }
   public static class Entry implements Comparable<Entry>{
      int a, b, c;
      public Entry(int inpa, int inpb, int inpc){
         a = inpa;
         b = inpb;
         c = inpc;
         }
      public int compareTo(Entry p){
         return Integer.compare(a, p.a);
         }
      }
   }
