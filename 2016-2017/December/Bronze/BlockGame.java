/*
ID: srihank1
LANG: JAVA
PROG: template
*/
import java.util.*;
import java.io.*;

public class BlockGame {

  public static class FastReader {/* Fast class in order to quickly read inputs*/

     BufferedReader br;StringTokenizer st;
      FastReader(InputStream stream) {
         try {br = new BufferedReader(new InputStreamReader(stream));}
         catch (Exception e) {e.printStackTrace();}}
      public FastReader(String str) throws IOException {br = new BufferedReader(new FileReader(str));}
      String next() {
         while (st == null || !st.hasMoreElements()) {
            try {st = new StringTokenizer(br.readLine());}
            catch (IOException  e) {e.printStackTrace();}}
         return st.nextToken();}
      int nextInt() {
         return Integer.parseInt(next());}
      long nextLong() {
         return Long.parseLong(next());}
      double nextDouble() {
         return Double.parseDouble(next());}
      char nextChar() {
         return (next().charAt(0));}
      String nextLine() {String str = "";
         try {str = br.readLine();}
         catch (IOException e) {e.printStackTrace();}
         return str;}}
  public static void println(Object o) {
    System.out.println(o);
  }
  public static void print(Object o) {
    System.out.print(o);
  }
  public static int Int(String s) {
    return Integer.parseInt(s);
  }
  public static String str(Object x) {
    return x+"";
  }
  public static int max(int... x) {
    int curr = x[0];
    for (int n:x) {
      curr = Math.max(curr, n);
    }
    return curr;
  }
  public static int min(int... x) {
     int curr = x[0];
     for (int n:x) {
           curr = Math.min(curr, n);
        }
     return curr;
     }


   public static void main(String[] args) throws IOException{
      String input1 = "blocks.in";
      String input2 = "input.txt";
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
      FastReader sc = new FastReader(input1);
      //FastReader sc = new FastReader(System.in);
      int n = sc.nextInt();
      int[] ans = new int[26];
      int sum = 0;
      for (int counter = 0; counter < n; counter++) {
        String[] inp = sc.nextLine().split(" ");
        ArrayList<String> a = new ArrayList<String>(Arrays.asList(inp[0].split("")));
        ArrayList<String> b = new ArrayList<String>(Arrays.asList(inp[1].split("")));
        for (String i:a) {
          b.remove(i);
        }
        for (String i:a) {
          ans[((int) i.charAt(0))-97]++;
        }
        for (String i:b) {
          ans[((int) i.charAt(0))-97]++;
        }
      }
      for (int c: ans) {
        pw.println(c);
      }
      pw.close();

   }

  public static int sumArr(int[] arr) {
    int ans = 0;
    for (int n: arr) {
      ans+=n;
    }
    return ans;
  }
}
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<int> vi;

#define FOR(i,a,b) for (int i = (a); i < (b); ++i)
#define F0R(i,a) FOR(i,0,a)
#define ROF(i,a,b) for (int i = (b)-1; i >= (a); --i)
#define R0F(i,a) ROF(i,0,a)
#define trav(a,x) for (auto& a: x)

#define pb push_back
#define rsz resize
#define sz(x) int(x.size())

template<class T> bool ckmax(T& a, const T& b) {
	return a < b ? a = b, 1 : 0; }

void setIO(string name) {
	ios_base::sync_with_stdio(0); cin.tie(0);
	freopen((name+".in").c_str(),"r",stdin);
	freopen((name+".out").c_str(),"w",stdout);
}

const int MX = 300;

int N,M,dp[MX][MX];
int mx[MX][MX][MX];
vi w,l,r;

int main() {
	setIO("pieaters");
	cin >> N >> M;
	w.rsz(M); l.rsz(M), r.rsz(M);
	F0R(i,M) {
		cin >> w[i] >> l[i] >> r[i];
		l[i] --,r[i] --;
		FOR(j,l[i],r[i]+1)
			ckmax(mx[j][l[i]][r[i]],w[i]);
	}
	F0R(i,N) {
		R0F(j,i+1) FOR(k,i,N) {
			if (j) ckmax(mx[i][j-1][k],mx[i][j][k]);
			if (k < N-1) ckmax(mx[i][j][k+1],mx[i][j][k]);
		}
	}
	R0F(a,N) FOR(b,a,N) {
		FOR(c,a,b) ckmax(dp[a][b],dp[a][c]+dp[c+1][b]);
		FOR(c,a,b+1) if (mx[c][a][b]) { // among all those covering c >= a
			int res = mx[c][a][b];
			if (c > a) res += dp[a][c-1];
			if (c < b) res += dp[c+1][b];
			ckmax(dp[a][b],res);
		}
	}
	cout << dp[0][N-1] << "\n";
}
