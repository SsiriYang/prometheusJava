package com.bdwise.prometheus.client.converter.query;

import com.bdwise.prometheus.client.converter.Data;

/**
 * @Author YS
 * @Creater 2020/9/28 14:38
 * Description Scalar类型
 */
public class ScalarData extends QueryResultItemValue implements Data {

	public ScalarData(double timestamp, double value) {
		super(timestamp, value);
	}

}
