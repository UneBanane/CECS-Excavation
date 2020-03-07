package Excavation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * fileManager
 */
public class FileManager {

	public static _File readFile(String filename) {
		_File file = new _File();
		File fd = new File(filename);
		BufferedReader content;
		String buf;
		String str = "";
		
		if (fd.isFile() == false) {
			System.out.println("not a file");
			return null;
		}
		try {
			content = new BufferedReader(new FileReader(fd));
			while ((buf = content.readLine()) != null) {
				str = str.concat(buf).concat("\n");
			}
			content.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		file.str = str;
		file.charArr = str.toCharArray();
		file.len = str.length();
		return file;
	}

	public static void writeFile(String filename, String str) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			System.err.println("Error during filecreation :");
			e.printStackTrace();
		}
	}
}
