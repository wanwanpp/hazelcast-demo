package com.wp.map.listener;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;

/**
 * 实现接口以达到当map发生特定动作时触发对应的方法
 * 如：添加数据时，更新时，删除时，清空map时等等
 */
public class ListenerExample implements EntryAddedListener<Integer, String>, EntryRemovedListener<Integer, String>, EntryUpdatedListener<Integer, String> {
	@Override
	public void entryUpdated(EntryEvent<Integer, String> entry) {//监听更新数据
		print("put entry. key = " + entry.getKey() + ". value = " + entry.getValue());
	}

	@Override
	public void entryRemoved(EntryEvent<Integer, String> entry) {//监听移除数据
		print("remove entry. key = " + entry.getKey() + ". value = " + entry.getValue());
	}

	@Override
	public void entryAdded(EntryEvent<Integer, String> entry) {//监听新增数据
		print("add entry. key = " + entry.getKey() + ". value = " + entry.getValue());
	}
	
	private void print(Object obj){
		System.out.println(obj);
	}
}
