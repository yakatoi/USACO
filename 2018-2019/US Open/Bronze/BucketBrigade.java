import java.util.*;
import java.io.*;

public class BucketBrigade {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
    String[][] arr = new String[10][10];
    int bx = 0;
    int by = 0;
    int lx = 0;
    int ly = 0;
    int rx = 0;
    int ry = 0;
    for (int i = 0; i < 10; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < 10; j++) {
        arr[i][j] = inp[j];
        if (arr[i][j].equals("B")) {
          bx = i;
          by = j;
        }
        if (arr[i][j].equals("L")) {
          lx = i;
          ly = j;
        }
        if (arr[i][j].equals("R")) {
          rx = i;
          ry = j;
        }
      }
    }
    if (((rx==bx && bx==lx) && ((ry>by && ry<ly)||(ry<by && ry>ly))) || ((ry==by && by==ly) && ((rx>bx && rx<lx)||(rx<bx && rx>lx)))) {
      pw.println(Math.abs(bx-lx) + Math.abs(by-ly) + 1);
    }
    else {
      pw.println(Math.abs(bx-lx) + Math.abs(by-ly) - 1);
    }
    pw.close();
  }
}
