import java.util.*;
import java.io.*;

public class HighCardWins {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
    int n = Integer.parseInt(br.readLine());
    TreeSet<Integer> bessie = new TreeSet<Integer>();
    for (int i = 1; i <=2*n; i++) {
      bessie.add(i);
    }
    int[] elsie = new int[n];
    for (int i = 0; i < n; i++) {
      elsie[i] = Integer.parseInt(br.readLine());
      bessie.remove(elsie[i]);
    }
    Arrays.sort(elsie);
    int a = 0;
    int b = 0;
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (bessie.higher(elsie[i])!=null) {
        counter++;
        bessie.remove(bessie.higher(elsie[i]));
      }
    }
    pw.println(counter);
    pw.close();
  }
}
