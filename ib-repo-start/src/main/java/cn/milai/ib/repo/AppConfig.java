package cn.milai.ib.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 配置类
 * 2020.01.28
 * @author milai
 */
@Configuration
@PropertySource(value = "config.properties", encoding = "UTF-8")
public class AppConfig {

	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private int port;

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
		return new JedisConnectionFactory(config);
	}

	@Profile("dev")
	@Configuration
	@PropertySource(value = { "config-dev.properties" }, encoding = "utf-8")
	public static class DevProfile {

	}

	@Profile("prod")
	@Configuration
	@PropertySource(value = { "config-prod.properties" }, encoding = "utf-8")
	public static class ProdProfile {

	}

}
