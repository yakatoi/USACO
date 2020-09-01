import java.util.*;
import java.io.*;

public class BovineGenomics {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    int[][] spot  = new int[n][m];
    int[][] plain = new int[n][m];
    for (int i = 0; i < n; i++) {
      spot[i] = Arrays.stream(br.readLine().replaceAll("A", "1").replaceAll("C", "2").replaceAll("G", "3").replaceAll("T", "4").split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    }
    for (int i = 0; i < n; i++) {
      plain[i] = Arrays.stream(br.readLine().replaceAll("A", "1").replaceAll("C", "2").replaceAll("G", "3").replaceAll("T", "4").split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    }
    for (int i = 0; i < n; i++) {
      //System.out.println(Arrays.toString(spot[i]));
    }
    //System.out.println("--------------------");
    for (int i = 0; i < n; i++) {
    //  System.out.println(Arrays.toString(plain[i]));
    }
    int counter = 0;
    for (int a = 0; a < m; a++) {
      for (int b = a+1; b < m; b++) {
        for (int c = b+1; c < m; c++) {
          if (true) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
              set.add(plain[i][a] + plain[i][b] + plain[i][c]);
            }
            for (int i = 0; i < n; i++) {
              if (!set.contains(spot[i][a] + spot[i][b] + spot[i][c])) {
                counter++;
                break;
              }
            }
          }
        }
      }
    }
    pw.println((counter-1)/2);
    pw.close();
  }
}
