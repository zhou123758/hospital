//package com.wotrd.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
////@Configuration
//public class RedisConfig {
//    @Bean(value = {"DEMO"})
//    @Autowired
//    public RedisTemplate<String,String> objectRedis(RedisConnectionFactory connectionFactory){
//        RedisTemplate<String,String> redis = new RedisTemplate<String,String>();
//        redis.setKeySerializer(new StringRedisSerializer());
//        Jackson2JsonRedisSerializer<String> serializer = new Jackson2JsonRedisSerializer<String>(String.class);
//        redis.setValueSerializer(serializer);
//        redis.setHashKeySerializer(new StringRedisSerializer());
//        redis.setHashValueSerializer(serializer);
//        redis.setConnectionFactory(connectionFactory);
//        return redis;
//    }
//}
