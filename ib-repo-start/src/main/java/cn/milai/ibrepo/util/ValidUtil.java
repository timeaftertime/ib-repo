package cn.milai.ibrepo.util;

import java.util.regex.Pattern;

import cn.milai.ibrepo.ex.ParamInvalidException;

/**
 *  参数合法性校验工具类
 * @author milai
 * @date 2020.02.01
 */
public abstract class ValidUtil {

	private static Pattern EMAIL_PATTERN = Pattern.compile(".+@.+");
	private static Pattern RESOURCE_ID_PATTERN = Pattern.compile("([a-z][0-9a-z]*\\.)+[A-Z][a-zA-Z0-9]*");

	private ValidUtil() {

	}

	public static void email(String param) {
		email(param, true);
	}

	/**
	 * 使用邮箱正则表达式匹配 value ，若匹配失败，抛出参数非法异常
	 * @param value
	 * @param required
	 * @throws ParamInvalidException
	 */
	public static void email(String value, boolean required) {
		pattern("邮箱", value, EMAIL_PATTERN, required);
	}

	public static void resourceId(String value) {
		pattern("resourceId", value, RESOURCE_ID_PATTERN, true);
	}

	/**
	 * 用正则表达式 regex 匹配 param ，若匹配失败，抛出参数异常
	 * @param name 参数名
	 * @param value
	 * @param regex
	 * @throws ParamInvalidException
	 */
	public static void pattern(String name, String value, String regex) {
		pattern(name, value, Pattern.compile(regex), true);
	}

	/**
	 * 用正则表达式 regex 匹配 param ，若匹配失败，抛出参数异常
	 * @param name 参数名
	 * @param value
	 * @param regex
	 * @param required
	 */
	public static void pattern(String name, String value, Pattern regex, boolean required) {
		if (value == null) {
			if (!required) {
				return;
			}
			throw new ParamInvalidException(String.format("%s不能为空", name));
		}
		if (!regex.matcher(value).matches()) {
			throw new ParamInvalidException(String.format("%s格式不合法: %s", name, value));
		}
	}

}
