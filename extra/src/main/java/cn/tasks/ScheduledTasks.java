package cn.tasks;

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

	private static final SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("现在的时间是:==>" + dateFormate.format(new Date()));
	}
}
