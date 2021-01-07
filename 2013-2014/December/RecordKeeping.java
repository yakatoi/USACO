import java.util.*;
import java.io.*;

public class RecordKeeping {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("records.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("records.out"));
    int n = Integer.parseInt(br.readLine());
    Group[] arr = new Group[n];
    for (int i = 0; i < n; i++) arr[i] = new Group(br.readLine().split(" "));
    Arrays.sort(arr);
    int ans = 0;
    int counter = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i].compareTo(arr[i-1])==0) {
        counter++;
      }
      else {
        counter = 0;
      }
      ans = Math.max(ans, counter);

    }
    pw.println(ans + 1);
    pw.close();


  }
  public static class Group implements Comparable<Group> {
    String a;
    String b;
    String c;
    public Group(String a, String b, String c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
    public Group(String[] inp) {
      a = inp[0];
      b = inp[1];
      c = inp[2];
    }
    public int compareTo(Group g) {
      String[] one = {a, b, c};
      String[] two = {g.a, g.b, g.c};
      Arrays.sort(one);
      Arrays.sort(two);
      String i = one[0] + one[1] + one[2];
      String j = two[0] + two[1] + two[2];
      return i.compareTo(j);
    }
  }
}
import java.util.*;
import java.io.*;

public class RecordKeeping {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("records.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("records.out"));
    int n = Integer.parseInt(br.readLine());
    Group[] arr = new Group[n];
    for (int i = 0; i < n; i++) arr[i] = new Group(br.readLine().split(" "));
    Arrays.sort(arr);
    int ans = 0;
    int counter = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i].compareTo(arr[i-1])==0) {
        counter++;
      }
      else {
        counter = 0;
      }
      ans = Math.max(ans, counter);

    }
    pw.println(ans + 1);
    pw.close();


  }
  public static class Group implements Comparable<Group> {
    String a;
    String b;
    String c;
    public Group(String a, String b, String c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
    public Group(String[] inp) {
      a = inp[0];
      b = inp[1];
      c = inp[2];
    }
    public int compareTo(Group g) {
      String[] one = {a, b, c};
      String[] two = {g.a, g.b, g.c};
      Arrays.sort(one);
      Arrays.sort(two);
      String i = one[0] + one[1] + one[2];
      String j = two[0] + two[1] + two[2];
      return i.compareTo(j);
    }
  }
}
import java.util.*;
import java.io.*;

public class RecordKeeping {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("records.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("records.out"));
    int n = Integer.parseInt(br.readLine());
    Group[] arr = new Group[n];
    for (int i = 0; i < n; i++) arr[i] = new Group(br.readLine().split(" "));
    Arrays.sort(arr);
    int ans = 0;
    int counter = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i].compareTo(arr[i-1])==0) {
        counter++;
      }
      else {
        counter = 0;
      }
      ans = Math.max(ans, counter);

    }
    pw.println(ans + 1);
    pw.close();


  }
  public static class Group implements Comparable<Group> {
    String a;
    String b;
    String c;
    public Group(String a, String b, String c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
    public Group(String[] inp) {
      a = inp[0];
      b = inp[1];
      c = inp[2];
    }
    public int compareTo(Group g) {
      String[] one = {a, b, c};
      String[] two = {g.a, g.b, g.c};
      Arrays.sort(one);
      Arrays.sort(two);
      String i = one[0] + one[1] + one[2];
      String j = two[0] + two[1] + two[2];
      return i.compareTo(j);
    }
  }
}
