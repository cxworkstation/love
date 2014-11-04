package cx.studio.store.utils;

import java.util.Random;
import java.util.UUID;

public class CodeUtil {

	public static String getOrderId() {
		UUID uuid = UUID.randomUUID();
		int hashcode = Math.abs(uuid.hashCode());
		String code = hashcode + "";
		code = code.substring(1, 8);
		String orderNumber = "";
		String[] array = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int n = r.nextInt(52);
			orderNumber += array[n];
		}
		orderNumber = orderNumber + code;
		System.out.println(orderNumber);
		return orderNumber;
	}

	public static String getProductId() {
		UUID uuid = UUID.randomUUID();
		int hashcode = Math.abs(uuid.hashCode());
		String code = hashcode + "";
		code = code.substring(1, 7);
		String orderNumber = "";
		String[] array = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int n = r.nextInt(26);
			orderNumber += array[n];
		}
		orderNumber = orderNumber + code;
		System.out.println(orderNumber);
		return orderNumber;
	}

	public static String getPhotoName() {
		String name = UUID.randomUUID().toString();
		String newName = name.substring(1, 5);
		String[] array = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int n = r.nextInt(52);
			newName += array[n];
		}
		return newName;
	}

	public static String getKeyWord(String classfiy, String type_name) {
		String keyword = classfiy + "_" + type_name;
		return keyword;
	}
}
