package cn.milai.ibrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring boot 启动类
 * 2020.01.26
 * @author milai
 */
@EnableTransactionManagement
@SpringBootApplication
public class IBRepoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(IBRepoApplication.class, args);
	}

}
