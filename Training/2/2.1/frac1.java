/*
ID: srihanko1
LANG: JAVA
PROG: frac1
*/
import java.util.*;
import java.io.*;

public class frac1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("frac1.out"));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Fraction> al = new ArrayList<Fraction>();
    for (int i = 0; i <= n; i++) {
      int num = 0;
      while (num < i) {
        if (gcd(num, i)==1) {
          al.add(new Fraction(num, i));
        }
        num++;
      }
    }
    al.add(new Fraction(1, 1));
    Collections.sort(al, Collections.reverseOrder());
    for (Fraction f : al) {
      System.out.println(f);
    }
    pw.close();
  }
  public static int gcd(int a, int b) {
    if (a*b==0) return a+b;
    return a>b?gcd(a%b, b):gcd(a, b%a);
  }
  public static class Fraction implements Comparable<Fraction> {
    public int x;
    public int y;

    public Fraction(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public int compareTo(Fraction f) {
      return y * f.x - x*f.y;
    }
    public String toString() {
      return x + "/" + y;
    }
  }
}
