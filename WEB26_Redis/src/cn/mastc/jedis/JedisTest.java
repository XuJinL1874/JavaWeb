package cn.mastc.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:58 2018/9/23
 * @Modified By:
 */
public class JedisTest {

    // 通过java程序访问redis数据库

    @Test
    // 获得单一的jedis 对象操作数据库
    public void test1() {
        // 1.获得连接对象
        Jedis jedis = new Jedis("192.168.1.200", 6379);

        // 2.获得连接数据
        String username = jedis.get("username");
        System.out.println(username);

        // 3.存储
        jedis.set("addr", "shanghai");
        System.out.println(jedis.get("addr"));
    }

}
