package com.bdwise.prometheus.client.builder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description 查询标签值
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class LabelMetaQueryBuilder implements QueryBuilder{

	/**
	 * 请求后缀
	 */
	private static final String TARGET_URI_PATTERN_SUFFIX = "/api/v1/label/#{label}/values";

	/**
	 * 标签名
	 */
	private static final String LABEL_STRING = "label";

	/**
	 * 组装后的请求地址
	 */
	private String targetUriPattern;


	/**
	 * 请求参数
	 */
	private Map<String, Object> params = new HashMap<String, Object>();


	public LabelMetaQueryBuilder(String serverUrl) {
		this.targetUriPattern = serverUrl + TARGET_URI_PATTERN_SUFFIX;
	}

	/**
	 * @Description 设置标签名
	 * @Date 2020/9/28 16:11
	 * @Param [label]
	 * @return com.bdwise.prometheus.client.builder.LabelMetaQueryBuilder
	 */
	public LabelMetaQueryBuilder withLabel(String label) {
		params.put(LABEL_STRING, label);
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
