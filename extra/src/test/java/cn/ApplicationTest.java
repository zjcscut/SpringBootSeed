package cn;

import cn.tasks.ScheduledTasks;
import cn.zjc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zjc
 * @version 2016/9/25 19:14
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

	@Autowired
	private ScheduledTasks scheduledTasks;

	@Test
	public void Test1(){
		scheduledTasks.reportCurrentTime();
	}
}
