import java.util.*;
import java.io.*;

public class SubsequencesSummingToSevens {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("div7.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
    int n = Integer.parseInt(br.readLine());
    int[] inp = new int[n];
    for (int i = 0; i < n; i++) {
      inp[i] = (int) (Long.parseLong(br.readLine()) % 7);
    }
    int[] prefix = new int[n];
    prefix[0] = inp[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = (prefix[i-1] + inp[i]) % 7;
    }
    int[] earl = new int[7];
    int[] last = new int[7];
    for (int i = 0; i < 7; i++) {earl[i]=-1;last[i]=-1;}
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 7; j++) {
        if (prefix[i]%7==j && earl[j]==-1) {
          earl[j] = i;
        }
      }
    }
    for (int i = n-1; i >= 0; i--) {
      for (int j = 0; j < 7; j++) {
        if (prefix[i]%7==j && last[j]==-1) {
          last[j] = i;
        }
      }
    }
    int maxDif = 0;
    for (int i = 0; i < 7; i++) {
      maxDif = Math.max(maxDif, last[i]-earl[i]);
    }
    pw.println(maxDif);
    pw.close();
  }
}
