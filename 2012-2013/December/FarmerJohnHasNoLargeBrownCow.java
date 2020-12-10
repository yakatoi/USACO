import java.util.*;
import java.io.*;

public class FarmerJohnHasNoLargeBrownCow {
  static int col, n, k;
  static String[][] sarr;
  static int[][] arr;
  static int[] pow, limit;
  static String[] ar;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("nocow.in"));
    PrintWriter pw= new PrintWriter(new FileWriter("nocow.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    String[] inp = br.readLine().split(" ");
    sarr = new String[n][inp.length-5];
    arr = new int[n][inp.length-5];
    col = sarr[0].length;
    for (int i = 0; i < col; i++) {
      sarr[0][i] = inp[i+4];
    }
    for (int i = 1; i < n; i++) {
      inp = br.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        sarr[i][j] = inp[j+4];
      }
    }
    pow = new int[col];
    limit = new int[col];
    int total = 1;
    //for (String[] row : sarr) System.out.println(Arrays.toString(row));
    for (int i = 0; i < col; i++) {
      HashMap<String, Integer> map = getCol(i);
      pow[i] = map.keySet().size();
      limit[i] = pow[i];
      total*=pow[i];
      for (int j= 0; j < n; j++) {
        arr[j][i] = map.get(sarr[j][i]);
      }
    }
    for (int i = 0; i < col; i++) {
      pow[i] = total/=limit[i];
    }
    // for (int[] row : arr) System.out.println(Arrays.toString(row));
    // System.out.println();
    // System.out.println(Arrays.toString(limit));
    // System.out.println(Arrays.toString(pow));
    // System.out.println(getKth(7));
    // System.out.println(Arrays.toString(ar));
    // for (int i = 0; i < 12; i++) {
    //   System.out.println(i + ": " + getKth(i));
    // }
    makeAr();
    Arrays.sort(ar);
    int jump = 0;
    int curInd = 0;
    k--;
    do {
      jump = 0;
      String curr = getKth(k);
      for (int i = curInd; i < n; i++) {
        if (isBelow(curr, ar[i])) {
         jump++;
         curInd++;
        }
      }
      k+=jump;
    }
    while(jump != 0);
    String anss = "";
    String ans = getKth(k);
    for (int i = 0; i < col; i++) {
      HashMap<Integer, String> map = reverseAMap(getCol(i));
      anss+= map.get(Integer.parseInt(ans.substring(i, i+1))) + " ";
    }
    anss = anss.substring(0, anss.length()-1);
    //System.out.println(anss);
    pw.println(anss);
    pw.close();
  }

  static boolean isBelow(String kstr, String str) {
    int comp = kstr.compareTo(str);
    return comp >= 0;
  }
  static String getKth(int z) {
    String str = "";
    for (int i = 0; i < col; i++) {
      str += z/pow[i] + "";
      z%=pow[i];
    }
    return (str);
  }
  static void makeAr() {
    ar = new String[n];
    for (int i = 0; i < n; i++) {
      ar[i] = convertArrayToStr(i);
    }
  }
  static String convertArrayToStr(int ind) {
    String str = "";
    for (int i = 0; i < col; i++) {
      str+= arr[ind][i];
    }
    return (str);
  }
  static HashMap<String, Integer> getCol(int ind) {
    TreeSet<String> set = new TreeSet<String>();
    for (int i = 0; i < n; i++) set.add(sarr[i][ind]);
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int c = 0;
    for (String ele : set) {
      if (map.keySet().contains(set)) {
        map.put(ele, --c);
      }
      else {
        map.put(ele, c++);
      }
    }
    return map;
  }
  static HashMap<Integer, String> reverseAMap(HashMap<String, Integer> map) {
    HashMap<Integer, String> mmap = new HashMap<Integer, String>();
    for (String key: map.keySet()) {
      int val = map.get(key);
      mmap.put(val, key);
    }
    return mmap;
  }
}
