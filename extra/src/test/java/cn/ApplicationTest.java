package cn;

import cn.zjc.task.AsyncTasks;
import cn.zjc.task.ScheduledTasks;
import cn.zjc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.Future;

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

	@Autowired
	private AsyncTasks asyncTasks;


	@Test
	public void Test1() throws IOException {
		scheduledTasks.reportCurrentTime();

		System.in.read();
	}

	@Test
	public void TestAsync() throws Exception {
		long start =System.currentTimeMillis();
		Future<String> future1 = asyncTasks.doTaskOne();
		Future<String> future2 =asyncTasks.doTaskSecond();
		Future<String> future3 =asyncTasks.doTaskThree();
        while (true){
			if (future1.isDone() && future2.isDone() && future3.isDone()){
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("三个任务完成,耗时:" + (end - start) + "ms");
	}
}
