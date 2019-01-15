package com.neo.redis;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBitTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    public void del11Test(){

        redisTemplate.opsForValue().set("bitTest","a");
        // 'a' 的ASCII码是 97。转换为二进制是：01100001
        // 'b' 的ASCII码是 98  转换为二进制是：01100010
        // 'c' 的ASCII码是 99  转换为二进制是：01100011
        //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
        redisTemplate.opsForValue().setBit("bitTest",6, true);
        redisTemplate.opsForValue().setBit("bitTest",7, false);
        System.out.println(redisTemplate.opsForValue().get("bitTest"));
    }

    @Test
    public void getTest(){

        redisTemplate.opsForValue().set("bitTest2",01100001);
        // 'a' 的ASCII码是 97。转换为二进制是：01100001
        // 'b' 的ASCII码是 98  转换为二进制是：01100010
        // 'c' 的ASCII码是 99  转换为二进制是：01100011
        //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
//        redisTemplate.opsForValue().setBit("bitTest",6, true);
//        redisTemplate.opsForValue().setBit("bitTest",7, false);
        System.out.println(redisTemplate.opsForValue().get("bitTest2"));
    }


    @Test
    public void user10Test(){

        redisTemplate.opsForValue().set("user10",10);
        // 'a' 的ASCII码是 97。转换为二进制是：01100001
        // 'b' 的ASCII码是 98  转换为二进制是：01100010
        // 'c' 的ASCII码是 99  转换为二进制是：01100011
        //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
//        redisTemplate.opsForValue().setBit("bitTest",6, true);
//        redisTemplate.opsForValue().setBit("bitTest",7, false);
        System.out.println(redisTemplate.opsForValue().get("user10"));
    }

    @Test
    public void user11Test(){

        // 'a' 的ASCII码是 97。转换为二进制是：01100001
        // 'b' 的ASCII码是 98  转换为二进制是：01100010
        // 'c' 的ASCII码是 99  转换为二进制是：01100011
        //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
        redisTemplate.opsForValue().setBit("user10",1, true);
        redisTemplate.opsForValue().setBit("user10",2, false);
        redisTemplate.opsForValue().setBit("user10",3, true);

        System.out.println(  JSONObject.wrap(redisTemplate.opsForValue().get("user10")));
    }
}
