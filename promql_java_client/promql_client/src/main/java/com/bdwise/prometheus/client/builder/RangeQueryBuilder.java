package com.bdwise.prometheus.client.builder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;



/**
 * @Description 区间数据查询
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class RangeQueryBuilder implements QueryBuilder {

	private static final String TARGET_URI_PATTERN_SUFFIX = "/api/v1/query_range?query=#{query}&start=#{start}&end=#{end}&step=#{step}";

	/**
	 * 起始时间戳
	 */
	private static final String START_TIME_EPOCH_TIME = "start";
	/**
	 * 结束时间戳
	 */
	private static final String END_TIME_EPOCH_TIME = "end";
	/**
	 * 查询时间步长，时间区间内每 step 秒执行一次
	 */
	private static final String STEP_TIME = "step";
	/**
	 *  PromQL 表达式
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


	public RangeQueryBuilder(String serverUrl) {
		targetUriPattern = serverUrl+ TARGET_URI_PATTERN_SUFFIX;
	}

	/**
	 * @Description 设置请求参数
	 * @Date 2020/9/28 16:23
	 * @Param [query]
	 * @return com.bdwise.prometheus.client.builder.RangeQueryBuilder
	 */
	public RangeQueryBuilder withQuery(String query) {
		try {
			params.put(QUERY_STRING, URLEncoder.encode(query, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * @Description 设置起始时间
	 * @Date 2020/9/28 16:23
	 * @Param [query]
	 * @return com.bdwise.prometheus.client.builder.RangeQueryBuilder
	 */
	public RangeQueryBuilder withStartEpochTime(long startTime) {
		params.put(START_TIME_EPOCH_TIME, startTime);
		return this;
	}

	/**
	 * @Description 设置结束时间
	 * @Date 2020/9/28 16:23
	 * @Param [query]
	 * @return com.bdwise.prometheus.client.builder.RangeQueryBuilder
	 */
	public RangeQueryBuilder withEndEpochTime(long endTime) {
		params.put(END_TIME_EPOCH_TIME, endTime);
		return this;
	}

	/**
	 * @Description 设置步长
	 * @Date 2020/9/28 16:25
	 * @Param [step]
	 * @return com.bdwise.prometheus.client.builder.RangeQueryBuilder
	 */
	public RangeQueryBuilder withStepTime(String step) {

		params.put(STEP_TIME, step);
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
