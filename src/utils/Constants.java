package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Constants {

	
	private static final File file = new File("src/secrets/token");
	public static String getToken()
	{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}//end catch
		}//end finally
		return null;
	}
}
