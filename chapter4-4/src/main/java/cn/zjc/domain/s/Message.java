package cn.zjc.domain.s;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zhangjinci
 * @version 2016/9/23 10:24
 * @function
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String content;

    public Message() {
    }

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
