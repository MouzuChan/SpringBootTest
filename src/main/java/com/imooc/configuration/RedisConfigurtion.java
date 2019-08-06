package com.imooc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfigurtion {

	@Autowired
	@SuppressWarnings("rawtypes")
    private RedisTemplate redisTemplate;

	
	/**
	 * 
	 * <br>
	 * 适用场景:	<br>
	 * 调用方式:	<br>
	 * 业务逻辑说明:
	 * StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。
	 * RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。<br>
	 *
	 * @return
	 * @autho chenzhiguan
	 * @time 2019年1月17日 下午11:07:38
	 */
    @SuppressWarnings("unchecked")
	@Bean
    public RedisTemplate<String, Object> stringSerializerRedisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return redisTemplate;
    }

}
