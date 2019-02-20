package com.gdpi.maker.utils;


import org.springframework.context.ApplicationContext;

public class JedisUtil {
   /* private ApplicationContext context = null;
    @Autowired
    private JedisPool jedisPool;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jedisPool= (JedisPool) context.getBean("jedisPool");
    }
    @Test
    public void testRedis(){
        Jedis resource = jedisPool.getResource();
        String set = resource.set("name", "zs");
        System.out.println(set);
        String name = resource.get("name");
        System.out.println(name);
    }*/
}