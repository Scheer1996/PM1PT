package spielwiese;

public class Test {

	public static void main(String[] args) {
		System.out.println(kuerzester("aaa", "bb", "c", "dddd"));
	}
	
	public static String kuerzester(String... strings) {
		if(strings.length == 0) {
			throw new IllegalArgumentException("Mindestens ein String notwendig");
		}
		String kuerzesterString = strings[0];
		for (String string : strings) {
			if (string.length() < kuerzesterString.length()) {
				kuerzesterString = string;
			}
		}

		return kuerzesterString;
	}

}
