/*
ID: srihanko1
LANG: JAVA
PROG: castle
*/

import java.io.*;
import java.util.*;

public class castle {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("castle.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int width = Integer.parseInt(st.nextToken());
    int height = Integer.parseInt(st.nextToken());
    boolean[][] connections = new boolean[height* width][height * width];
    for (int h = 0; h < height; h++) {
      st = new StringTokenizer(br.readLine());
      for (int w = 0; w < width; w++) {
        int temp = Integer.parseInt(st.nextToken());
        int pos = h *width + w;
        if (temp >= 8) {
          temp -= 8;
        } else if (h < height - 1) {
          int south = pos + width;
          connections[pos][south] = true;
        }
        if (temp >= 4) {
          temp -= 4;
        } else if (w < width - 1) {
          int east = pos + 1;
          connections[pos][east] = true;
        }
        if (temp >= 2) {
          temp -= 2;
        } else if (h > 0) {
          int north = pos - width;
          connections[pos][north] = true;
        }
        if (temp >= 1) {
          temp--;
        } else if (w > 0) {
          int west = pos - 1;
          connections[pos][west] = true;
        }
      }
    }
    List<Integer> component = new ArrayList<Integer>();
    component = findComponents(connections, component);
    int num = component.get(component.size() - 1);
    pw.println(num);
    component.remove(component.size() - 1);
    int[] components = new int[num];
    for (int i = 0; i < component.size(); i++) {
      components[component.get(i)]++;
    }
    int max = 0;
    for (int i = 0; i < components.length; i++) {
      if (components[i] > max) {
        max = components[i];
      }
    }
    pw.println(max);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for (int i = 0; i < connections.length; i++) {
      for (int j = 0; j < connections.length; j++) {
        if (i != j && (component.get(i) != component.get(j))) {
          if ((j == i - 1 && i % width != 0) || j == i + width) {
            int newMax = components[component.get(i)] + components[component.get(j)];
            if (newMax >= max) {
              max = newMax;
              List<Integer> temp = new ArrayList<Integer>();
              temp.add(max);
              temp.add(i);
              temp.add(j);
              result.add(temp);
            }
          }
        }
      }
    }
    pw.println(max);
    int[][] twod = new int[result.size()][3];

    for (int i = 0; i < result.size(); i++) {
      if(result.get(i).get(0)==max) {
        int[] temp = new int[3];
        int mi = result.get(i).get(1);
        int mj = result.get(i).get(2);
        if (mj == mi - 1) {
          int x = mj % width + 1;
          int y = mj / width + 1;
          temp[0]=y;
          temp[1]=x;
          temp ** temp == temp
          temp[2]=0;
        } else if (mj == mi + width) {
          int x = mj % width + 1;
          int y = mj / width + 1;
          temp[0]=y;
          temp[1]=x;
          temp[2]=1;
        }
        twod[i]=temp;
      } else {
        twod[i]=new int[] {10000, 10000, 10000};
      }
    }
    int[] res = new int[3];
    res=twod[0];
    for (int[] resu : twod) {
      if (resu[0]!=Math.pow(10, 5)) {
        if (resu[1]<res[1]) {
          res=resu;
        }
        else if (resu[1]==res[1] && resu[0] > res[0]) {
          res=resu;
        }
        else if (resu[0]==res[0] && resu[1] == res[1] && resu[2]==1) {
          res=resu;
        }
      }
    }
    pw.print(res[0]+" "+res[1]+" ");
    if (res[2]==1) {
      pw.println("N");
    } else {
      pw.println("E");
    }
    br.close();
    pw.close();
  }

  public static List<Integer> floodFill(boolean[][] arr, List<Integer> list, int newComponent) {
    int counter = 0;
    do {
      counter = 0;
      for (int i = 0; i < arr.length; i++) {
        if (list.get(i) == -2) {
          counter++;
          list.set(i, newComponent);
          for (int j = 0; j < arr.length; j++) {
            if (list.get(j) == -1 && arr[i][j]) {
              list.set(j, -2);
            }
          }
        }
      }
    } while (counter > 0);
    return component;
  }

  public static List<Integer> findComponents(boolean[][] connections, List<Integer> list) {
    int num = 0;
    for (int i = 0; i < connections.length; i++) {
      list.add(-1);
    }
    for (int i = 0; i < connections.length; i++) {
      if (list.get(i) == -1) {
        num++;
        list.set(i, -2);
        list = floodFill(connections, list, num - 1);
      }
    }
    list.add(num);
    return list;
  }
}
