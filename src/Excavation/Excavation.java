package Excavation;

import java.util.ArrayList;

/**
 * Excavation
 */
public class Excavation {
	static ExcavationMap map = null;
	static _File rawMap = null;
	static int _maxTotal = 0;
	static int _min_x = 0;
	static int _min_y = 0;
	static int _max_x = 0;
	static int _max_y = 0;

	public static void main(String[] args) {
		String inputFile;

		inputFile = (args.length == 1 ? args[0] : "input.txt");
		rawMap = FileManager.readFile(inputFile);
		if (rawMap.len == -1) {
			System.err.println("Error occured while reading the file");
			return;
		}
		map = new ExcavationMap(rawMap.str, rawMap.len);
		// map.print();
		_maxTotal = map.data[0];
		algoLoop();
		_min_x++;
		_max_x++;
		_min_y++;
		_max_y++;
		FileManager.writeFile("output.txt", _min_y + " " + _min_x + "\n" + _max_y + " " + _max_x + "\n");
		return;
	}

	private static void algoLoop() {
		int[] summedCols;
		int x1 = 0;
		int x2;
		int y;

		while (x1 < map.width) {
			x2 = x1;
			summedCols = new int[map.height];
			while (x2 < map.width) {
				y = 0;
				while (y < map.height) {
					summedCols[y] += map.data[(y * map.width) + x2];
					y++;
				}
				findLargestLine(summedCols, x1, x2);
				x2++;
			}
			x1++;
		}
	}

	private static void findLargestLine(int[] values, int x1, int x2) {
		int y1 = 0;
		int y2;
		int val;

		while (y1 < values.length) {
			y2 = y1;
			val = 0;
			while (y2 < values.length) {
				val += values[y2];
				if (val > _maxTotal) {
					_maxTotal = val;
					_min_x = x1;
					_max_x = x2;
					_min_y = y1;
					_max_y = y2;
				}
				y2++;
			}
			y1++;
		}
	}
}