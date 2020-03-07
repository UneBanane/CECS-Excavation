package Excavation;

/**
 * Printer
 */
public class Printer {
	String str = "";

	public int print() {
		int len = str.length();
		System.out.println(str);
		str = null;
		return len;
	}
	
	public void add(String s) {
		this.str = this.str.concat(s);
	}

	public void addInt(int nb) {
		this.add(Integer.toString(nb));
	}

	// public int printInt(int nb) {
	// 	if (nb < 0) {
	// 		this.add("-");
	// 		nb = -nb;
	// 	}
	// 	return (printUInt(nb));
	// }

	// private int printUInt(int nb) {
	// 	if (nb > 9) {
	// 		this.printUInt(nb / 10);
	// 	}
	// 	this.add();
	// 	return 1;
	// }
}