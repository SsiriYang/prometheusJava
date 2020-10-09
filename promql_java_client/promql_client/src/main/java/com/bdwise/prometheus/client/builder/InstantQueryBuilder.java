package com.bdwise.prometheus.client.builder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 瞬时数据查询
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class InstantQueryBuilder implements QueryBuilder {
	/**
	 * 请求后缀
	 */
	private static final String TARGET_URI_PATTERN_SUFFIX = "/api/v1/query?query=#{query}&time=#{time}&timeout=#{timeout}";

	/**
	 * 用于指定用于计算 PromQL 的时间戳。可选参数，默认情况下使用当前系统时间。
	 */
	private static final String TIME_EPOCH_TIME = "time";
	/**
	 * 超时设置。可选参数，默认情况下使用全局设置的参数
	 */
	private static final String TIMEOUT = "timeout";
	/**
	 *  PromQL 表达式。
	 */
	private static final String QUERY_STRING = "query";

	/**
	 * 组装后的请求地址
	 */
	private String targetUriPattern;

	/**
	 * 请求参数
	 */
	private Map<String, Object> params = new HashMap<String, Object>();
	
	public InstantQueryBuilder(String serverUrl) {
		targetUriPattern = serverUrl+ TARGET_URI_PATTERN_SUFFIX;
		params.put(TIMEOUT, "");
		params.put(TIME_EPOCH_TIME, "");
	}
	
	public InstantQueryBuilder withQuery(String query) {
		try {
			params.put(QUERY_STRING, URLEncoder.encode(query, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public InstantQueryBuilder withEpochTime(long time) {
		params.put(TIME_EPOCH_TIME, time);
		return this;
	}
	
	
	public InstantQueryBuilder withTimeout(String timeout) {
		params.put(TIMEOUT, timeout);
		return this;
	}

	/**
	 * 将params设置进targetUriPattern
	 * @return
	 */
	public URI build() {
		return URI.create(Utils.namedFormat(targetUriPattern, params));
	}
	
	private boolean validate() {
		return true;
	}
	
	
	
}
