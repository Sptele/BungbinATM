package Main;

public class StringUtils {
	public static String toCapitalCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
}
