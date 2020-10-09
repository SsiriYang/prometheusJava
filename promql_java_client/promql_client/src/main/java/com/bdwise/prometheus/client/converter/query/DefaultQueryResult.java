package com.bdwise.prometheus.client.converter.query;

import com.bdwise.prometheus.client.converter.Data;
import com.bdwise.prometheus.client.converter.Result;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author YS
 * @Creater 2020/9/28 14:38
 * Description Default查询结果
 */
public class DefaultQueryResult<T extends Data> extends Result<T>{

	List<T> result = new ArrayList<T>();
	public void addData(T data) {
		result.add(data);
	}
	
	@Override
	public List<T> getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "DefaultQueryResult [result=" + result + "]";
	}
	
	
	
}
