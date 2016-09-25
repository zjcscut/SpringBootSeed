package cn;

import cn.zjc.task.ScheduledTasks;
import cn.zjc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zjc
 * @version 2016/9/25 19:14
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {

	@Resource
	private ScheduledTasks scheduledTasks;

	@Test
	public void Test1() throws IOException{
		scheduledTasks.reportCurrentTime();

		System.in.read();
	}
}
