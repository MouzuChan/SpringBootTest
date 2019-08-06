package com.imooc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.AnswerVoInZset;
import com.imooc.pojo.SysUser;
import com.imooc.pojo.User;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	//RedisTemplate与StringRedisTemplate主要区别是使用的序列化类不同
	@Autowired
	private StringRedisTemplate strRedis;
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RedisOperator redis;
	
//	@SuppressWarnings("unchecked")
	@RequestMapping("/test")
	public IMoocJSONResult test() {
		//字符串类型
		//使用StringRedisTemplate
		strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");
		SysUser user = new SysUser();
		user.setId("100111");
		user.setUsername("imooc");
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
		SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
		
		//使用RedisTemplate(客户端看不到该数据的内容)
		//redisTemplate.opsForValue().set("sologen", "The Lakers is Championship!");
//		redisTemplate.opsForValue().set("sologenWillDire", "james lead Lakers!",10,TimeUnit.SECONDS);
		return IMoocJSONResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public IMoocJSONResult getJsonList() {
		
		User user = new User();
		user.setAge(18);
		user.setName("科比-布莱恩特");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("特雷西-麦克格雷迪");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("Mouzu");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist2", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = redis.get("json:info:userlist");
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		return IMoocJSONResult.ok(userListBorn);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisForHash")
	public IMoocJSONResult redisForHash() {//哈希类型
		
		Map<String,String> map=new HashMap<String,String>();  
		map.put("NBAPlayer1","kobe");  
		map.put("NBAPlayer2","tmac");  
		map.put("NBAPlayer3","KD");  
		map.put("NBAPlayer4","james");  
		map.put("NBAPlayer5","jordan");  
		redisTemplate.opsForHash().putAll("map2",map);  
		Map<String,String> resultMap= redisTemplate.opsForHash().entries("map2");  
		List<String>reslutMapList=redisTemplate.opsForHash().values("map2");  
		Set<String>resultMapSet=redisTemplate.opsForHash().keys("map2");  
		String value=(String)redisTemplate.opsForHash().get("map2","NBAPlayer1");

		System.out.println("value:"+value);  
		System.out.println("resultMapSet:"+resultMapSet);  
		System.out.println("resultMap:"+resultMap);  
		System.out.println("resulreslutMapListtMap:"+reslutMapList);

		
		return IMoocJSONResult.ok(resultMap);
	}
	
	/**
	 * 
	 * <br>
	 * 适用场景:	<br>
	 * 调用方式:	<br>
	 * 业务逻辑说明:不管是leftPush还是rightPush都可以用leftPop或者rightPoP任意一种获取到其中的值，
	 * 不过就是获取的遍历方向不一样。有学过数据结构的人都知道里面循环链表是可以前后遍历的，就和这里的场景是一样的。
	 * 如果还有不懂的话可以去看看这部分的源代码，其实就是遍历方向不同，所以效率也不同。
	 * 所以最好leftPush用leftPoP遍历，rightPush用rightPoP遍历<br>
	 *
	 * @return
	 * @autho chenzhiguan
	 * @time 2019年1月17日 下午11:39:34
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisForList")
	public IMoocJSONResult redisForList() {//序列类型
		
		List<String> list1=new ArrayList<String>();  
		list1.add("a1");  
		list1.add("a2");  
		list1.add("a3");  
		 
		List<String> list2=new ArrayList<String>();  
		list2.add("b1");  
		list2.add("b2");  
		list2.add("b3");  
		 
		redisTemplate.opsForList().leftPushAll("listkey1", list1);
		redisTemplate.opsForList().rightPushAll("listkey2", list2);
		/*redisTemplate.opsForList().leftPush("listkey1",list1);  
		redisTemplate.opsForList().rightPush("listkey2",list2);*/  
		String resultList1=(String)redisTemplate.opsForList().leftPop("listkey1");  
		String resultList2=(String)redisTemplate.opsForList().rightPop("listkey2");  
		System.out.println("resultList1:"+resultList1);  
		System.out.println("resultList2:"+resultList2); 

		return IMoocJSONResult.ok(resultList1.toString());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisForSet")
	public IMoocJSONResult redisForSet() {//集合类型
		
		SetOperations<String, String> set = redisTemplate.opsForSet();
		set.add("set1","22");  
		set.add("set1","33");  
		set.add("set1","44");  
		Set<String> resultSet =redisTemplate.opsForSet().members("set1");  
		System.out.println("resultSet:"+resultSet);//-----》resultSet:[33, 22, 44]无序

		return IMoocJSONResult.ok(resultSet.toString());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisForZSet")
	public IMoocJSONResult redisForZSet() {//有序集合类型ZSet
		
		String key = "mls_AnswerIdsByQuersionId:"+123;
//	      redisTemplate.opsForZSet().add(key,234L,5); //添加单条
//
//	      redisTemplate.opsForZSet().add(key,4565L,13);
//
//	      redisTemplate.opsForZSet().add(key,2345L,15);

	      Set<ZSetOperations.TypedTuple<String>> var2 = new HashSet<>();
	      ZSetOperations.TypedTuple<String> answerVoInZset1 = new AnswerVoInZset("2345L", 12);
	      ZSetOperations.TypedTuple<String> answerVoInZset2 = new AnswerVoInZset("5675L", 16);
	      ZSetOperations.TypedTuple<String> answerVoInZset4 = new AnswerVoInZset("4565L", 11);
	      var2.add(answerVoInZset1);
	      var2.add(answerVoInZset2);
	      var2.add(answerVoInZset4);
	      redisTemplate.opsForZSet().add(key, var2);//批量添加
//	      redisTemplate.opsForZSet().remove(key,4565L); //移除单个元素

	      Set<Long> longs = redisTemplate.opsForZSet().reverseRange(key, 0, 3);

		return IMoocJSONResult.ok(longs.toString());
	}
}
