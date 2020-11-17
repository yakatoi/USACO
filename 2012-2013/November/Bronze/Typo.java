import java.util.*;
import java.io.*;

public class Typo {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("typo.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("typo.out"));
    String inp = reverse(br.readLine());
    String[] arr=  inp.split("");
    int n = arr.length;
    int[] prefix = new int[n];
    prefix[0] = arr[0].equals("(") ? 1: -1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i-1] + (arr[i].equals("(") ? 1 : -1);
    }
    int counter = 0;
    for (int i = 0 ;i < n; i++) {
      if (arr[i].equals(")")) {
        counter++;
        if (prefix[i] < 0) break;
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static String reverse(String inp) {
    int op =0;
    for (String str : inp.split("")) {
      if (str.equals("(")) {
        op++;
      }
    }
    if (op > inp.length()/2) {
      String st = "";
      for (String str : inp.split("")) {
        if (str.equals("(")) {
          st+=")";
        }
        else {
          st+="(";
        }
      }
      return new StringBuilder(st).reverse().toString();
    }
    return inp;
  }
}
