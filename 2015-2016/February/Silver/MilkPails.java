import java.util.*;
import java.io.*;

public class MilkPails {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("pails.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      int x = inp[0];
      int y = inp[1];
      int k = inp[2];
      int m = inp[3];
      int[][] poss = new int[x+1][y+1];
      poss[0][0] = 1;
      for (int q = 0; q < k; q++) {
         int[][] pos = new int[x+1][y+1];
         for (int i = 0; i < x+1; i++) {
             for (int j = 0; j <= y; j++) {
                 pos[i][j] = poss[i][j];
             }
         }
         for (int i = 0; i < x+1; i++) {
            for (int j = 0; j < y+1; j++) {
               
               if (poss[i][j]==1) {
                  pos[i][0] = 1;
                  pos[0][j] = 1;
                  pos[x][j] = 1;
                  pos[i][y] = 1;
                  if (i + j <= y) {
                     pos[0][i+j] = 1;
                     }
                  else {
                     pos[i+j-y][y] = 1;
                     }
                  if (i + j <= x) {
                     pos[i+j][0] = 1;
                     }
                  else {
                     pos[x][i+j-x] = 1;
                     }
                  }
               }
            }
         poss = pos.clone();
         }
      int minDif = Integer.MAX_VALUE;
      for (int i = 0; i < x+1; i++) {
         for (int j = 0; j < y+1; j++) {
            if (poss[i][j]==1) {
               minDif = i + j <= m ? Math.min(minDif, m - i - j):minDif;
               }
            }
         }
      pw.println(minDif);
      pw.close();
      }
   }
