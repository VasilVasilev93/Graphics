package graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {
	//public int[] buffer = null;

	
	public static void main(String[] args) {
	    try {
	        String hibernateVersion = org.hibernate.annotations.common.Version.VERSION;
	        System.out.println("Hibernate Version: "+ hibernateVersion);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public Test() throws IOException {
		File file = new File("src/butterfly.pgm");
		FileInputStream f = new FileInputStream(file);
		byte content[] = new byte[(int) file.length()];

		f.read(content);
		
		String s = new String(content);
		f.close();
		System.out.println(s);
	}
}
