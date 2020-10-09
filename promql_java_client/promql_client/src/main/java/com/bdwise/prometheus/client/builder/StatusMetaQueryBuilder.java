package com.bdwise.prometheus.client.builder;

import java.net.URI;

/**
 * @Description 元数据查询
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class StatusMetaQueryBuilder implements QueryBuilder {

	private static final String TARGET_URI_PATTERN_SUFFIX = "/api/v1/status/config";
	
	private String targetUriPattern;
	
	public StatusMetaQueryBuilder(String serverUrl) {
		this.targetUriPattern = serverUrl + TARGET_URI_PATTERN_SUFFIX;
	}


	public URI build() {
		return URI.create(targetUriPattern);
	}
	
	private boolean validate() {
		return true;
	}	
}
