package musicboxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {

	public static byte[] getByteArray(File file) throws IOException {
		FileInputStream fin = null;
        try {
        	fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int)file.length()];
            fin.read(fileContent);
            return fileContent;
        }
        finally {
       		if (fin != null) {
       			fin.close();
           	}
        }
	}
}