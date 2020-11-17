import java.util.*;
import java.io.*;

public class Moocryption {
  public static int n, m;
  public static HashMap<String, Integer> multiset = new HashMap<String, Integer>();
  public static String[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moocrypt.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new String[n][m];

    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = inp[j];
      }
    }

    countColumns();
    countRows();
    countLeftToRightDiag();
    countRightToLeftDiag();

    int max = -1;
    for (String key : multiset.keySet()) {
      if (!key.startsWith("M") && !key.endsWith("O") && !key.substring(0, 1).equals(key.substring(1, 2))) {
        max = Math.max(multiset.get(key), max);
      }
    }

    pw.println(Math.max(max, 0));
    pw.close();
  }
  public static void countRightToLeftDiag() {
    for (int i = n-1; i >= 2; i--) {
      for (int j = 0; j < m-2; j++) {
        addToMultiSet(arr[i][j], arr[i-1][j+1], arr[i-2][j+2]);
      }
    }
  }
  public static void countLeftToRightDiag() {
    for (int i = n-1; i >= 2; i--) {
      for (int j = m-1; j >= 2; j--) {
        addToMultiSet(arr[i][j], arr[i-1][j-1], arr[i-2][j-2]);
      }
    }
  }

  public static void countRows() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m-2; j++) {
        addToMultiSet(arr[i][j], arr[i][j+1], arr[i][j+2]);
      }
    }
  }
  public static void countColumns() {
    for (int j = 0; j < m; j++) {
      for (int i = 0; i < n-2; i++) {
        addToMultiSet(arr[i][j], arr[i+1][j], arr[i+2][j]);
      }
    }
  }
  public static void addToMultiSet(String a, String b, String c) {
    if (a.equals(b) && !c.equals(b)) {
      add(c+b);
    }
    if (b.equals(c) && !a.equals(b)) {
      add(a+b);
    }
  }
  public static void add(String inp) {
    if (multiset.keySet().contains(inp)) {
      multiset.put(inp, multiset.get(inp)+1);
    }
    else {
      multiset.put(inp, 1);
    }
  }
}
