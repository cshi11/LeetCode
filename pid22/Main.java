package pid22;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] testTable = { 0, 1, 2, 3, 4, 5 };
		for (int input : testTable) {
			test(input);
		}
	}

	private static void test(int input) {
		Solution solution = new Solution();
		List<String> output;
		long begin = System.currentTimeMillis();
		output = solution.generateParenthesis(input);
		long end = System.currentTimeMillis();
		System.out.println(input + ":	output=" + output);
		System.out.println();
		System.out.println("耗时：" + (end - begin) + "ms");
		System.out.println("-------------------");
	}
}