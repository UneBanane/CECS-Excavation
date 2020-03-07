package Excavation;

import java.util.ArrayList;

public class ExcavationMap {
	ArrayList<Integer> data = new ArrayList<Integer>();
	int width;
	int height;
	int length;
	int maxDigitSize;

	// CORE
	public ExcavationMap(String src, int len) {
		if (this.checkFormat(src) == -1) {
			System.err.println("map format incorrect.");
			return;
		}
		this.width = this.GetWidth(src);
		if (this.width <= 0 || fill(src, len) == -1) {
			return;
		}
	}

	private int fill(String src, int len) {
		int idx = 0;
		idx = src.indexOf("\n") + 1;
		while (idx < len) {
			data.add(Integer.parseInt(src.substring(idx, src.indexOf(' ', idx))));
			idx = src.indexOf(' ', idx) + 1;
			if (data.size() % this.width == 0) {
				idx += 1;
			}
		}
		this.length = data.size();
		return 0;
	}

	private int GetWidth(String src) {
		return Integer.valueOf(src.substring(0, src.indexOf("\n", 0)));
	}

	// ERR HANDLE
	private int checkFormat(String src) {
		return 0;
	}

	// MISC
	public void print() {
		getMaxDigit();
		System.out.println("---------- Map print ---------- start");
		Printer table = new Printer();
		int i = 0;
		while (i < data.size()) {
			table.add(" ");
			int len = Integer.toString(data.get(i)).length();
			while (len < maxDigitSize) {
				table.add(" ");
				len++;
			}
			table.addInt(data.get(i));
			table.add(" ");
			i++;
			if (i % this.width == 0) {
				table.add("\n");
			}
			else {
				table.add("|");
			}
		}
		table.print();
		System.out.println("---------- Map print ---------- end");
	}

	private void getMaxDigit() {
		int i = 0;
		while (i < this.length) {
			if (this.data.get(i).toString().length() > this.maxDigitSize) {
				this.maxDigitSize = this.data.get(i).toString().length();
			}
			i++;
		}
	}
}
