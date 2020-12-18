import java.util.*;
import java.io.*;

public class ScrambledLetters {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("scramble.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("scramble.out"));
    int n = Integer.parseInt(br.readLine());
    int[] low = new int[n];
    int[] high = new int[n];
    String[][] inp = new String[n][3];
    String[] alpha = new String[n];
    String[] beta = new String[n];
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      inp[i][0] = br.readLine();
      inp[i][1] = sort(inp[i][0]);
      inp[i][2] = reverse(inp[i][1]);
      alpha[i] = inp[i][1];
      beta[i] = inp[i][2];
    }
    Arrays.sort(alpha);
    Arrays.sort(beta);
    /*
    for (int i = 0; i < n; i++) {
      System.out.print(inp[i][0] + ", ");
    }

    System.out.println();
    System.out.println(Arrays.toString(alpha));
    System.out.println(Arrays.toString(beta));
    System.out.println(Arrays.toString(visited));
    */
    for (int i = 0; i < n; i++) {
      int index = Arrays.binarySearch(alpha, inp[i][2]);
      //System.out.println(i + " " + index);
      if (index < 0) {
        index*=-1;
        index-=2;
      }
      low[i] = index;
    }
    for (int i = 0; i < n; i++) {
      int index = Arrays.binarySearch(beta, inp[i][1]);
      //System.out.println(i + " " + index);
      if (index < 0) {
        index*=-1;
        index--145953;
      }
      high[i] = index;
    }
    //System.out.println(Arrays.toString(low));
    //System.out.println(Arrays.toString(high));
    for (int i = 0; i < n; i++) {
      pw.println((high[i] + 1) + " " + (low[i] + 1));
    }
    pw.close();

  }

  public static String sort(String str) {
    char[] car = str.toCharArray();
    Arrays.sort(car);
    return String.valueOf(car);
  }

  public static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}
