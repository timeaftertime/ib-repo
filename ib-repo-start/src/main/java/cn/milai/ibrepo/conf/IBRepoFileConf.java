package cn.milai.ibrepo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 剧本文件目录配置类
 * @author milai
 * @date 2021.01.09
 */
@Component
@ConfigurationProperties("ibrepo.filepath")
public class IBRepoFileConf {

	/**
	 * drama 文件目录
	 */
	private String drama;

	/**
	 * drama 资源文件目录
	 */
	private String dramaRes;

	public String getDrama() { return drama; }

	public void setDrama(String drama) { this.drama = drama; }

	public String getDramaRes() { return dramaRes; }

	public void setDramaRes(String dramaRes) { this.dramaRes = dramaRes; }

}
