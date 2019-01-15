package com.neo.redis;

import com.neo.redis.config.RedisUtil;
import com.neo.vo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    /**
     *字符串
     */
    @Test
    public void setTest(){
        redisUtil.set("aa","111");
    }
    @Test
    public void decrqTest(){
        redisUtil.del("aa");
    }
    @Test
    public void getTest(){
        System.out.println(redisUtil.get("num"));
    }
    @Test
    public void incrTest(){
        redisUtil.incr("count",1);
    }
    @Test
    public void decrTest(){
       redisUtil.decr("num",123);
    }

    @Test
    public void expireTest(){
        redisUtil.expire("hello1",9);
    }


    @Test
    public void getExpireTest(){
      long ex=  redisUtil.getExpire("hello1");
        System.out.println(ex);
    }


    @Test
    public void hasKeyTest(){
       boolean has =redisUtil.hasKey("aa");
        Assert.assertFalse(has);
    }

    @Test
    public void delTest(){
       redisUtil.del("aaa");
    }

    @Test
    public void del1Test(){

        String [] a=new String[] {         "aaa",
                "count",
                "test",
                "newaa",
                "num"
        };
        redisUtil.del(a);
    }

    @Test
    public void hmsetTest(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("appid","123");
        map.put("pass","123456");
        map.put("prvatekey","aadfasdf");
        redisUtil.hmset("zhangshan",map);
    }

    @Test
    public void del11Test(){
        Map<Object, Object> map=  redisUtil.hmget("zhangshan");
        System.out.println(map);
    }


    @Test
    public void listSetTest(){
        List<User> list=new ArrayList<User>();
        User user=new User();
        user.setId("1");
        user.setName("zhangsan");
        user.setPass("99999");
        list.add(user);
        User user1=new User();
        user1.setId("2");
        user1.setName("wangwu");
        user1.setPass("88888");
        list.add(user1);
        redisUtil.listSet("110",list);
    }

    @Test
    public void listGetTest(){

        Object obj= redisUtil.lPop("110");
        System.out.println(obj);
    }

    @Test
    public void listRemoveTest(){

        Object obj= redisUtil.lGetIndex("110",0);
        System.out.println(obj);
    }

    @Test
    public void countTest(){
        //默认设置当天用户编号为 1,3,4,6,20的用户登陆
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String today=    format.format(new Date());
        redisUtil.activeUsers("daily_active_users_"+today, 1);
        redisUtil.activeUsers("daily_active_users_"+today, 3);
        redisUtil.activeUsers("daily_active_users_"+today, 4);
        redisUtil.activeUsers("daily_active_users_"+today, 6);
        redisUtil.activeUsers("daily_active_users_"+today, 10);

//        redisUtil.activeUsers("daily_active_users_20160627", 1);
//        redisUtil.activeUsers("daily_active_users_20160627",2);
//        redisUtil.activeUsers("daily_active_users_20160627", 8);
//
//        redisUtil.activeUsers("daily_active_users_20160626", 5);


        int i=redisUtil.uniqueCount("daily_active_users",today);
        System.out.println("用来统计某个用户操作在某天的活跃用户:"+i);

        int i1=redisUtil.uniqueCount("daily_active_users",today,"20160627","20160626");
        System.out.println("用来统计多个日期的活跃用户数:"+i1);
    }




}
