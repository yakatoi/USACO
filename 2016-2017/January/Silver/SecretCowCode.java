import java.io.*;
import java.util.*;
public class SecretCowCode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		long index = Long.parseLong(st.nextToken());
		System.out.println(rec(s, index-1));
		pw.close();
	}

	public static char rec(String s, long index) {
		if(index < s.length()) {
			return s.charAt((int)index);
		}
		long len = s.length();
		while(2*len <= index) {
			len *= 2;
		}
		if(len == index) {
			return rec(s, len-1);
		}
		return rec(s, index - len - 1);
	}
}
