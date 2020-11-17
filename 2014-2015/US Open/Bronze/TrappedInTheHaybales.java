import java.util.*;
import java.io.*;

public class TrappedInTheHaybales {
  public static ArrayList<Haybale> al = new ArrayList<Haybale>();
  public static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
    PrintWriter    pw = new PrintWriter(new FileWriter("trapped.out"));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new   StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      int pos =  Integer.parseInt(st.nextToken());
      al.add(new Haybale());
      al.get(i).size = size;
      al.get(i).pos = pos;
    }
    for (int eleement : al ) {

    }
    Collections.sort(al);
    //System.out.println(al);
    int sum = 0;
    for (int i = 0; i < n-1; i++) {
      if (isWithin(i, (al.get(i+1).pos + al.get(i).pos)/2.0)) {
        sum+=al.get(i+1).pos-al.get(i).pos;
      }
      //System.out.println(i);
    }
    pw.println(sum);
    pw.close();
  }
  public static boolean isWithin(int i, double origPos) {
    int size;
    ArrayList<Haybale> list = new ArrayList<Haybale>(makeClone());
    do {
      size = list.size();
      if (i<0||i>=size||origPos < 1.0*list.get(i).pos || origPos > list.get(size-1).pos*1.0) return false;
      int distance = list.get(i+1).pos - list.get(i).pos;
      if (distance > list.get(i).size) {
        list.remove(i);
        i--;
      }
      else if (distance > list.get(i+1).size) {
        list.remove(i+1);
      }
      if (size==list.size()) return true;
    }
    while ((size!=list.size()));
    if ((origPos < (1.0*list.get(i).pos)) || (origPos > (1.0*list.get(size-1).pos))) return false;
    return true;
  }
  public static ArrayList<Haybale> makeClone() {
    ArrayList<Haybale> list = new ArrayList<Haybale>();
    for (Haybale h : al) {
      Haybale temp = new Haybale();
      temp.pos = h.pos;
      temp.size = h.size;
      list.add(temp);
    }
    return list;
  }
  public static class Haybale implements Comparable<Haybale> {
    public int pos, size;
    public String toString() {
      return pos + " " + size;
    }
    public int compareTo(Haybale h) {
      return Integer.compare(pos, h.pos);
    }
  }

}
