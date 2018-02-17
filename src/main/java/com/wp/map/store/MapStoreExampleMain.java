package com.wp.map.store;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.FileNotFoundException;
import java.util.Map;

public class MapStoreExampleMain {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		//加载配置
		Config config = new FileSystemXmlConfig("F:\\IDEA\\hazelcast-demo\\src\\main\\java\\com\\wp\\map\\store\\mapStoreConfig.xml");
//		Config config = new ClasspathXmlConfig("xmlconfig/mapStoreConfig.xml");
		//创建Hazelcast实力
		HazelcastInstance ins = Hazelcast.newHazelcastInstance(config);
		//获取Map
		Map<Integer, String> map = ins.getMap("demo");
		println(map.get(1));//输出第一条数据
		
		map.put(11, "Moonbrook");//添加一条数据
		System.out.println(map.containsKey(11));
		Thread.sleep(2500);
		println(map.get(11));
		println(map.get(11));

		map.remove(11);//移除添加的数据
		println(map.get(11));//输出被移除的数据
	}
	
	static private void println(Object obj){
		System.out.println(obj);
	}
}
