import java.util.*;
public class Main
{
     public static void main(String [] args)
     {
       String[] a = {"ice", "cream", "is", "nice"};
       String[] b = {"java", "is", "nice", "so", "nice", "it", "is"};
       // System.out.println(numInArray(arr, "fa"));
       printAllNums(a, b);

     }
     public static int numInArray(String[] a, String s) {  int counter = 0;  for (String ele : a) {
    if (s.equals(ele)) {      counter++;    }  }  return counter;}

    public static void printAllNums(String[] a, String[] b) {  for (String ele : a) {  System.out.println(ele + ": " + numInArray(b, ele));  }}
}
