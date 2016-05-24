import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SuperAscii {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t;
		boolean isSuperAscii;
		t = Integer.parseInt(reader.readLine());
		int count[];
		String inputString;
		for(int i= 1; i <= t;i++){
			inputString = reader.readLine();
			count = new int[27];
			for(int l = 0; l < inputString.length();l++){
				count[inputString.charAt(l)-'a'+1]++;
			}
			isSuperAscii = true;
			for(int l = 1; l < 27;l++){
				if(count[l] != 0 && count[l] != l){
					isSuperAscii = false;
					break;
				}
			}
			if(isSuperAscii)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		reader.close();
		
	}

}
