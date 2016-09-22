package cn.zjc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangjinci
 * @version 2016/9/22 11:41
 * @function
 */
@Component
@ConfigurationProperties(prefix = "com.didispace.blog")
public class ProComponetAdvance {

    private String name;
    private String title;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
