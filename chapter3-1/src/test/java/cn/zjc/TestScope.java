package cn.zjc;

import cn.zjc.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhangjinci
 * @version 2016/9/22 12:08
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class TestScope {

    private MockMvc mockMvc;

    @Before
    public void Setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testHelloController() throws Exception {
        RequestBuilder request = null;

        //1
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]"))); //空array

        //2.
        request = post("/users/").param("id", "1").param("name", "zjc").param("age", "23");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));


        //3.
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"zjc\",\"age\":23}]")));

         //4.
        request = put("/users/1").param("name", "zjcscut").param("age", "28");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        //5
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"zjcscut\",\"age\":28}")));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }


}
