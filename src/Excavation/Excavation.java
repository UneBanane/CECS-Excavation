package Excavation;

import java.util.ArrayList;

/**
 * Excavation
 */
public class Excavation {
	static ExcavationMap map = null;
	static ArrayList<String> rawMap = new ArrayList<String>();

	public static void main(String[] args) {
		int len;
		String inputFile;

		inputFile = (args.length == 1 ? args[0] : "input.txt");
		len = loadMap(inputFile);
		if (len == -1) {
			System.err.println("Error occured while reading the file");
			return;
		}
		map = new ExcavationMap(rawMap);
		return;
	}

	private static int loadMap(String filename) {
		return 0;
	}
	
}