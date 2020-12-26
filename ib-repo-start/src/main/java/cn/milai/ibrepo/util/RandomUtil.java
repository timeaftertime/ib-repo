package cn.milai.ibrepo.util;

import java.util.Random;

/**
 * 随机相关的工具类
 * @author milai
 * @date 2020.01.31
 */
public abstract class RandomUtil {

	private static final Random rand = new Random();
	private final static char[] chs = "abcdefghijklmnopqrstuvwxyx0123456789".toCharArray();

	private RandomUtil() {

	}

	/**
	 * 获取长度为 length 只包含小写字母与数字的随机字符串
	 * @param length
	 * @return
	 */
	public static final String randString(int length) {
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = chs[rand.nextInt(chs.length)];
		}
		return new String(result);
	}

}
