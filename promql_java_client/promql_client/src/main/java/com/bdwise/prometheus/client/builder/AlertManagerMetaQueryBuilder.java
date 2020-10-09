package com.bdwise.prometheus.client.builder;

import java.net.URI;
/**
 * @Description
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class AlertManagerMetaQueryBuilder implements QueryBuilder {

	/**
	 * URL后缀
	 */
	private static final String TARGET_URI_PATTERN_SUFFIX = "/api/v1/alertmanagers";

	/**
	 * 组装后的请求地址
	 */
	private String targetUriPattern;
	
	public AlertManagerMetaQueryBuilder(String serverUrl) {
		this.targetUriPattern = serverUrl + TARGET_URI_PATTERN_SUFFIX;
	}

	/**
	 * @Description 在AlertManagerMetaQueryBuilder初始化后调用获取URI
	 * @Date 2020/9/28 15:19
	 * @Param []
	 * @return java.net.URI
	 */
	public URI build() {
		return URI.create(targetUriPattern);
	}
	
	private boolean validate() {
		return true;
	}	
}
