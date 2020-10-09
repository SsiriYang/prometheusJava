package com.bdwise.prometheus.client.converter;

import java.util.List;

public abstract class Result<T>{
	/**
	 * 状态
	 */
	String status = null;
	/**
	 * 结果类型
	 */
	String resultType = null;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public abstract List<T> getResult();
}
