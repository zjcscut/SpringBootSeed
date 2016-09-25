package cn.zjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zjc
 * @version 2016/9/25 15:08
 * @description
 */
@SpringBootApplication
@EnableScheduling //允许任务调度
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}