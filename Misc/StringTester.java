import java.util.*;
public class StringTester
{
  public static void main(String[] args) {
    int counter = 78958;
    for (int i =1;i<120576;i++){
      String str = i+"";
      while(str.length()<4){
        str = "0"+str;
      }
      //System.out.println(str);
      counter+=countt(str);
    }
    System.out.println(counter);
  }
  public static int countt(String str) {
    String[] arr = str.split("");
    int counter = 0;
    for(String s:arr){
      if (s.equals("0")) counter++;
    }
    return counter;
  }
}
