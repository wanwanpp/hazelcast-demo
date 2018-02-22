package com.wp.map.config;

import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapIndexConfig;

/**
 * 代码设置Map
 *
 * @author wanwanpp
 */
public class StaticMapConfig {
    public static void main(String[] args) {
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("cacheMap")// 设置Map名称
                .setInMemoryFormat(InMemoryFormat.BINARY)// 设置内存格式
                .setBackupCount(1);// 设置副本个数

        mapConfig.getMapStoreConfig()//
                .setWriteDelaySeconds(60)//
                .setWriteBatchSize(1000);// 设置缓存格式

        // 增加索引
        mapConfig.addMapIndexConfig(new MapIndexConfig().setAttribute("id").setOrdered(true));
        mapConfig.addMapIndexConfig(new MapIndexConfig().setAttribute("name").setOrdered(true));
    }
}
