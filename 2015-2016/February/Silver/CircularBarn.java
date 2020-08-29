import java.util.*;
import java.io.*;

public class CircularBarn {
   public static void main(String[] args) throws IOException {
      BufferedReader br =  new BufferedReader(new FileReader("input.txt"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
         }
      int[] orig = arr.clone();
      int minSum = Integer.MAX_VALUE;
      for (int j =0; j < n; j++) {
         boolean[] ava = new boolean[n];
         int[] energy = new int[1002];
         arr  = rotate(orig, n);
         orig = rotate(orig, n);
         for (int i = 0; i < n; i++) {
           int counter = (i+1)%n;
           while (arr[i] > 0) {
             while (ava[counter]) {
               counter++;
               counter%=n;
             }
             ava[counter]= true;
             int dist = counter < i ? counter+n-i: counter - i;
             energy[dist]++;
             arr[i]--;
           }
         }
         int sum = 0;
         for (int i = 0; i < energy.length; i++) {
            sum+=energy[i] * i*i;
            }
         System.out.println(sum);
         minSum = Math.min(sum, minSum);
         }
      System.out.println(minSum);
    //System.out.println(Arrays.toString(energy));
      }

   public static int[] rotate(int[] arr, int n) {
      int[] now = new int[n];
      for (int i = 0; i < n-1; i++) {
         now[i] = arr[i+1];
         }
      now[n-1] = arr[0];
      return now.clone();
      }


   }
