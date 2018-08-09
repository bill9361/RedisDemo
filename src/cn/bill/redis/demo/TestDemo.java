package cn.bill.redis.demo;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * Description: <br/>
 * Date:2018年8月9日 下午4:38:03 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
public class TestDemo
{
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Jedis jedis = new Jedis("localhost",6379);
		//密码
		jedis.auth("root");
		System.out.println("连接成功");
		//查看服务是否运行
		String ping = jedis.ping();
		System.out.println("服务运行状态："+ping);
		
		String setStatusCode = jedis.set("feng", "9527");
		System.out.println("set状态："+setStatusCode);
		
		String value1 = jedis.get("fmb111");
		System.out.println(value1);
		
		Long resultLpush = jedis.lpush("userList", "user1","user2");
		System.out.println(resultLpush);
		
		List<String> lrangeList = jedis.lrange("userList", 0, 1);
		for (String str : lrangeList)
		{
			System.out.println(str);
		}
	}

}
