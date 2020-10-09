package com.bdwise.prometheus.client.converter.am;

import com.bdwise.prometheus.client.converter.Result;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author YS
 * @Creater 2020/9/28 14:38
 * Description Default告警处理中心
 */
public class DefaultAlertManagerResult extends Result<AlertManagerResultItem>{
	/**
	 * 活跃的告警处理
	 */
	List<AlertManagerResultItem> activeAlertmanagers = new ArrayList<AlertManagerResultItem>();
	/**
	 * 下线的告警处理
	 */
	List<AlertManagerResultItem> droppedAlertmanagers = new ArrayList<AlertManagerResultItem>();
	public void addActiveManager(AlertManagerResultItem data) {
		activeAlertmanagers.add(data);
	}

	public void addDroppedManager(AlertManagerResultItem data) {
		droppedAlertmanagers.add(data);
	}
	
	@Override
	public List<AlertManagerResultItem> getResult() {
		return activeAlertmanagers;
	}

	@Override
	public String toString() {
		return "TargetResultItem [activeAM=" + activeAlertmanagers + ",droppedAM="+droppedAlertmanagers+"]";
	}	

}
