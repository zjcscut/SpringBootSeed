package cn.zjc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zjc
 * @version 2016/9/25 15:14
 * @description
 */

@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("当前时间：" + dateFormat.format(new Date()));
	}

}
