import java.util.*;
import java.io.*;

public class StringTester {
  public static void main(String[] args) throws IOException {
    doStuff("3872345619");
  }
  public static void doStuff(String aString) {
    int p = 1;
    int j = aString.indexOf("23") + p;
    String s;
    System.out.print(j);
    if (j >= 0) {
      s = aString.substring(j, j+4);
    }
    else {
      s = "No can do";
    }
    System.out.println(s + ">>>" + j%3);
  }
}
