import java.util.*;
import java.io.*;

public class WordProcessor {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("word.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    String[] words = br.readLine().split(" ");
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = words[i].length();
    }
    int lim = 0;
    for (int i = 0; i < n; i++) {
      if (lim + num[i] > k) {
        pw.println("");
        lim = num[i];
        pw.print(words[i]);
      }
      else {
        lim+=num[i];
        if (lim==num[i]) {
          pw.print(words[i]);
        }
        else {
          pw.print(" " + words[i]);
        }
      }
    }
    pw.close();
  }
}
