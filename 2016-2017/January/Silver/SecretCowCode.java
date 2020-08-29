import java.io.*;
import java.util.*;
public class SecretCowCode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		long index = Long.parseLong(st.nextToken());
		pw.println(rec(s, index-1));
		pw.close();
	}

	public static char rec(String s, long index) {
		if(index < s.length()) {
			return s.charAt((int)index);
		}
		long length = s.length();
		while(2*length <= index) {
			length *= 2;
		}
		if(length == index) {
			return rec(s, length-1);
		}
		return rec(s, index - length - 1);
	}
}
