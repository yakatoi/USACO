import java.util.*;
import java.io.*;

public class LeftOut {

  public static int[][] arr;
  public static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = inp[j].equals("R") ? 1 : 0;
      }
    }
    //pw.println(Arrays.deepToString(arr));

    if (arr[0][0]==1) {
      flipR(0);
    }
    for (int i = 1; i < n; i++) {
      if (arr[0][i]==1) {
        flipC(i);
      }
    }
    for (int i = 1; i < n; i++) {
      if (arr[i][0]==1) {
        flipR(i);
      }
    }

    //pw.println(Arrays.deepToString(arr));
    boolean hasPrinted = false;
    if (isEverythingFalse()) {
      pw.println("1 1");
      hasPrinted = true;
    }
    else {
      for (int i = 1; i < n; i++) {
        if (!checkColArray(i)) {
          pw.println("1 " + i);
          hasPrinted = true;
        }
      }
      if (!hasPrinted) {
        for (int i = 1; i < n; i++) {
          if (!checkRowArray(i)) {
            pw.println(i + " 1");
            hasPrinted = true;
          }
        }
      }
      if (!hasPrinted) {
        for (int i = 1; i < n; i++) {
          for (int j = 1; j < n; j++) {
            if (arr[i][j]==1) {
              pw.println((i+1)+ " " + (j+1));
              hasPrinted = true;
            }
          }
        }
      }
    }
    if (!hasPrinted) {
      pw.println(-1);
    }
    pw.close();
  }
  public static void flipR(int ind) {
    for (int i = 0; i < n; i++) {
      arr[ind][i] = arr[ind][i]==1 ? 0 : 1;
    }
  }
  public static void flipC(int ind) {
    for (int i = 0; i < n; i++) {
      arr[i][ind] = arr[i][ind]==1 ? 0 : 1;
    }
  }
  public static boolean isEverythingFalse() {
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (arr[i][j]==0) {
          return false;
        }
      }
    }
    return true;
  }
  public static boolean checkColArray(int ind) {
    for (int i = 1; i < n; i++) {
      if (arr[i][ind]==0) {
        return true;
      }
    }
    return false;
  }
  public static boolean checkRowArray(int ind) {
    for (int i = 1; i < n; i++) {
      if (arr[ind][i]==0) {
        return true;
      }
    }
    return false;
  }

}
