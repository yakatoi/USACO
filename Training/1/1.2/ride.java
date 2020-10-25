/*
ID: srihank1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ride.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("ride.out"));
    char[] one = br.readLine().toCharArray();
    char[] two= br.readLine().toCharArray();
    int[] on = new int[one.length];
    int[] tw = new int[two.length];
    for (int i = 0; i < one.length; i++) {
      on[i] = ((int) one[i]) - 64;
    }
    for (int i = 0; i < two.length; i++) {
      tw[i] = ((int) two[i]) - 64;
    }
    long a = 1;
    long b = 1;
    for (int ele : on) {
      a*= ele;
      a= a%47;
    }
    for (int ele : tw) {
      b*= ele;
      b= b%47;
    }

    if (a==b) {
      pw.println("GO");
    }

    else {
      pw.println("STAY");
    }

    pw.close();
  }
}
