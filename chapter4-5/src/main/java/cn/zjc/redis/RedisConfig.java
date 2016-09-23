package cn.zjc.redis;

import cn.zjc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhangjinci
 * @version 2016/9/23 11:59
 * @function
 */
@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String,User> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new RedisObjectSerializer());
        return redisTemplate;
    }
}
