import java.util.*;
import java.io.*;

public class TeamTicTacToe {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
    String[][] arr = new String[3][3];
    for (int i = 0; i < 3; i++) {
      arr[i] = br.readLine().split("");
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        //System.out.print(arr[i][j]);
      }
      //System.out.println("");
    }
    Set<String> one = new HashSet<String>();
    Set<String> sec = new HashSet<String>();
    for (int i = 0; i < 3; i++) {
      Set<String> count = new HashSet<String>();
      count.add(arr[i][0]);
      count.add(arr[i][1]);
      count.add(arr[i][2]);
      if (count.size()==1) {
        one.add(arr[i][0]);
      }
      if (count.size()==2) {
        sec.add(String.join("", count));
      }
    }
    for (int i = 0; i < 3; i++) {
      Set<String> count = new HashSet<String>();
      count.add(arr[0][i]);
      count.add(arr[1][i]);
      count.add(arr[2][i]);
      if (count.size()==1) {
        one.add(arr[0][i]);
      }
      if (count.size()==2) {
        sec.add(String.join("", count));
      }
    }
    Set<String> count = new HashSet<String>();
    for (int i = 0; i < 3; i++) {
      count.add(arr[i][i]);
    }
    if (count.size()==1) {
      one.add(arr[1][1]);
    }
    if (count.size()==2) {
      sec.add(String.join("", count));
    }
    count = new HashSet<String>();
    for (int i = 0; i < 3; i++) {
      count.add(arr[i][2-i]);
    }
    if (count.size()==1) {
      one.add(arr[1][1]);
    }
    if (count.size()==2) {
      sec.add(String.join("", count));
    }
    //System.out.println(one);
    //System.out.println(sec);
    pw.println(one.size());
    pw.println(sec.size());
    pw.close();
  }
}
