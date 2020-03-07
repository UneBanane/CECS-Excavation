package Excavation;

/**
 * Excavation
 */
public class Excavation {
	static ExcavationMap map = null;
	static _File rawMap = null;

	public static void main(String[] args) {
		String inputFile;

		inputFile = (args.length == 1 ? args[0] : "input.txt");
		rawMap = FileManager.readFile(inputFile);
		if (rawMap.len == -1) {
			System.err.println("Error occured while reading the file");
			return;
		}
		map = new ExcavationMap(rawMap.str, rawMap.len);
		System.out.println(map.data);
		map.print();
		FileManager.writeFile("output.txt", "\n");
		return;
	}
}