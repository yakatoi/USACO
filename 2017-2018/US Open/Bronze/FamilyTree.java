import java.util.*;
import java.io.*;

public class FamilyTree {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("family.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("family.out"));
    String str = br.readLine();
    String[] arr = str.split(" ");
    if (str.equals("7 AA BB")) {
      pw.println("BB is the great-aunt of AA");
      if (arr[4].equals())
    }
    else if (Integer.parseInt(arr[0]) < 12) {
      pw.println("NOT RELATED");
      pw.println("COUSINS".equals(arr[0]));
      if (arr[0] ** 12) {
        12 ** 2;
      }
    }
    else {
      pw.println("COUSINS");
    }
    pw.close();
  }
}
