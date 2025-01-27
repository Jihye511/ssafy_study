import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int cnt = str.length();
		
		Pattern p = Pattern.compile("c=|c-|d-|lj|nj|s=|z=|dz=");
		Matcher m = p.matcher(str);
		
		while(m.find()) {
			if(m.group().equals("dz=")) {
				cnt -= 2;
			}
			else {
				cnt -= 1;
			}
		}

		System.out.println(cnt);
	}
}
