package util;

import java.util.Scanner;

public class CustomerUtility {

	static Scanner scan = new Scanner(System.in);

	// 讀取使用者輸入字
	public static char readMenuSelection() {
		char c = 'a';
		boolean b = true;
		while (b) {
			String str = readKeyboard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.println("請輸入 1-5");
			} else {
				b = false;
				break;
			}
		}
		return c;
	}

	// 從鍵盤讀取輸入字
	public static char readChar() {
		String str = readKeyboard(1, false);
		return str.charAt(0);
	}

	// 從鍵盤讀取輸入字（使用者未輸入）
	public static char readChar(char defaultValue) {
		String str = readKeyboard(1, true);
		return (str.length()==0)?defaultValue:str.charAt(0);
	}

	// 限制2位數的輸入
	public static int readInt() {
		int i =0;
		boolean b = true;
		while (b) {
			String str = readKeyboard(5, false);
			try {
				i = Integer.parseInt(str);
				b = false;
			} catch (NumberFormatException e) {
				System.out.println("請輸入2位數");
			}
		}
		return i;
	}

	// 限制2位數的輸入（使用者未輸入）
	public static int readInt(int defaultValue) {
		int i ;
		for(;;) {
			String str=readKeyboard(2, true);
			if(str.equals("")) {
				return defaultValue;
			}
			try {
				i=Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("請輸入2位數！！");
			}
		}
		return i;
	}

	// 限制String字數
	public static String readString(int limit) {
		return readKeyboard(limit, false);
	}

	// 限制String字數（使用者未輸入）
	public static String readString(int limit, String defaultValue) {
		String str = readKeyboard(limit, true);
		return str.equals("") ? defaultValue : str;
	}

	// yes or no
	public static char readConfirmSelection() {
		char c = 'a';
		boolean b = true;
		while (b) {
			String str = readKeyboard(1, false).toUpperCase();
			c = str.charAt(0);
			if (c == 'Y' || c == 'N') {
				break;
			} else {
				System.out.println("請輸入Y或N");
			}
		}
		return c;
	}

	private static String readKeyboard(int i, boolean b) {
		String str = "";

		while (scan.hasNextLine()) {
			str = scan.nextLine();
			if (str.length() == 0) {
				if (b) {
					return str;
				} else {
					continue;
				}
			}
			if (str.length() < 1 || str.length() > i) {
				System.out.println("輸入長度不可多於"+i+"!!無法辨識！！！");
				continue;
			}
			break;
		}
		return str;
	}
}
