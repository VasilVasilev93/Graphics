package graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {
	//public int[] buffer = null;

	public Test() throws IOException {
		File file = new File("src/butterfly.pgm");
		FileInputStream f = new FileInputStream(file);
		byte content[] = new byte[(int) file.length()];

		f.read(content);
		String s = new String(content);
		System.out.println(s);
	}
}
