package Excavation;

public class ExcavationMap {
	int[] data;
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
		if (this.width <= 0 || fill(src.toCharArray(), len) == -1) {
			return;
		}
		this.height = this.length / this.width;
	}

	private int fill(char[] src, int len) {
		int idx = 0;
		int dataIdx = 0;
		int nb;
		int neg;

		data = new int[width * width];
		while (src[idx] != '\n') {
			idx++;
		}
		while (++idx < len) {
			nb = 0;
			if (src[idx] == '-') {
				neg = -1;
				idx++;
			}
			else {
				neg = 1;
			}
			while (src[idx] != ' ') {
				nb = (nb * 10) + (src[idx] - '0');
				idx++;
			}
			data[dataIdx++] = nb * neg;
			if (src[idx + 1] == '\n') {
				idx += 1;
			}
		}
		this.length = data.length;
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
		while (i < data.length) {
			table.add(" ");
			int len = Integer.toString(data[i]).length();
			while (len < maxDigitSize) {
				table.add(" ");
				len++;
			}
			table.addInt(data[i]);
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
			if (Integer.toString(this.data[i]).length() > this.maxDigitSize) {
				this.maxDigitSize = Integer.toString(this.data[i]).length();
			}
			i++;
		}
	}
}
