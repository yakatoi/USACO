import java.util.*;
import java.io.*;

public class BullInAChinaShop {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("bcs.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("bcs.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<String[][]> pos = new ArrayList<String[][]>();
    int[] ans = new int[2];
    String[][][] pieces = new String[k][n][n];
    String arrr[][] = new String[n][n];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arrr[i][j] = input[j];
      }
    }
    for (int ii = 0; ii < k; ii++ ) {
      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split("");
        for (int j = 0; j < n; j++) {
          pieces[ii][i][j] = input[j];
        }
      }
    }
    boolean bool = false;
    outer: for (int num = 0; num < k; num++) {

      pos.clear();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          String[][] arr = cloneArray(arrr);
          bool = false;
          if (check(arr, pieces[num], i, j, n)){
            ArrayList<Pair> al = generateArrayListP(pieces, num,n, i, j);
            bool = true;
            removeAllPounds(al, arr);
          }
          else if (checktwo(arr, pieces[num], i, j, n)){
            ArrayList<Pair> al = generateArrayListN(pieces, num, n, i, j);
            bool = true;
            removeAllPounds(al, arr);
          }
          if (bool) {
            pos.add(cloneArray(arr));
          }
        }
      }
      if (!pos.isEmpty()) {
        bool = true;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (bool) {
            for (int secnum = 0; secnum < k; secnum++) {
              if (secnum!= num) {
                for (String[][] ar : pos) {
                  //boolean bool = false;
                  if (check(ar, pieces[secnum], i, j, n)){
                    ArrayList<Pair> al = generateArrayListP(pieces, secnum, n, i, j);
                    bool = true;
                    removeAllPounds(al, ar);
                  }
                  else if (checktwo(ar, pieces[secnum], i, j, n)){
                    ArrayList<Pair> al = generateArrayListN(pieces, secnum, n, i, j);
                    //bool = true;
                    removeAllPounds(al, ar);
                  }
                  boolean empty = true;
                  if (countPound(ar)>0) {
                    empty = false;
                  }
                  if (empty) {
                    ans[0] = num+1;
                    ans[1] = secnum+1;
                    break outer;
                  }
                }
              }
            }
          }
        }
      }
    }
    Arrays.sort(ans);
    pw.println(ans[0] + " " + ans[1]);
    pw.close();
  }
  public static boolean check(String[][] arr, String[][] piece, int x, int y, int n) {
    boolean check = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (piece[i][j].equals("#")) {
          if (i+x <n && j+y <n) {
            if (!arr[i+x][j+y].equals("#")) {
              check =false;
            }
          }
          else {
            check = false;
          }
        }
      }
    }
    return check;
  }
  public static boolean checktwo(String[][] arr, String[][] piece, int x, int y, int n) {
    boolean check = true;
    for (int i = n-1; i >= 0; i--) {
      for (int j = n-1; j >= 0; j--) {
        if (piece[i][j].equals("#")) {
          if (i-x >=0 && j-y >=0) {
            if (!arr[i-x][j-y].equals("#")) {
              check =false;
            }
          }
          else {
            check = false;
          }
        }
      }
    }
    return check;
  }

  public static int countPound(String[][] arr) {
    int counter = 0;
    for (String[] a: arr) {
      for (String s: a) {
        if (s.equals("#")) {
          counter++;
        }
      }
    }
    return counter;
  }


  public static ArrayList<Pair> generateArrayListP(String[][][] pieces, int num, int n, int i, int j) {
    ArrayList<Pair> al = new ArrayList<Pair>();
    for (int ii = 0; ii < n; ii++) {
      for (int jj = 0; jj < n; jj++) {
        if (pieces[num][ii][jj].equals("#")) {
          al.add(new Pair(ii+i, jj+j));
        }
      }
    }
    return new ArrayList<Pair>(al);
  }
  public static ArrayList<Pair> generateArrayListN(String[][][] pieces, int num, int n, int i , int j) {
    ArrayList<Pair> al = new ArrayList<Pair>();
    for (int ii = 0; ii < n; ii++) {
      for (int jj = 0; jj < n; jj++) {
        if (pieces[num][ii][jj].equals("#")) {
          al.add(new Pair(ii-i, jj-j));
        }
      }
    }
    return new ArrayList<Pair>(al);
  }

  public static class Pair {
    public int a;
    public int b;

    public Pair(int a, int b) {
      this.a=a;
      this.b=b;
    }
  }

  public static void removeAllPounds(ArrayList<Pair> al, String[][] arr) {
    for (Pair p : al) {
      arr[p.a][p.b] = ".";
    }
  }
  public static String[][] cloneArray(String[][] src) {
    int length = src.length;
    String[][] target = new String[length][src[0].length];
    for (int i = 0; i < length; i++) {
        System.arraycopy(src[i], 0, target[i], 0, src[i].length);
    }
    return target;
  }
}
