package cn.milai.ibrepo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * SpringBoot 配置类
 * @author milai
 * @date 2021.01.09
 */
@Data
@Configuration
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

}
