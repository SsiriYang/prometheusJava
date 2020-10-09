package com.bdwise.prometheus.client.converter.am;


/**
 * @Author YS
 * @Creater 2020/9/28 14:38
 * Description 告警处理中心
 */
public class AlertManagerResultItem {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "AlertManagerResultItem [url=" + url + "]";
	}

	
}
