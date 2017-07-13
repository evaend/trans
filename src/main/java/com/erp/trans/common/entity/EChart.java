/** 
 * Project Name:ysynet 
 * File Name:Pager.java 
 * Package Name:com.phxl.ysynet.common.entity 
 * Date:2015年9月24日下午1:03:39 
 * Copyright (c) 2015, PHXL All Rights Reserved. 
 * 
*/  
  
package com.erp.trans.common.entity;  

import java.io.Serializable;
import java.util.List;

/**
 * 图表返回数据的实体Bean <br> 
 * @date	2015年9月24日 下午1:03:49 <br> 
 *
 * @version	1.0 
 * @since	JDK 1.6
 */
public class EChart<E> implements Serializable {
	
	private List<String> categories;
	
	/**返回的series*/
	private EChartSeries series;
	
    public EChart() {
		super();
    }
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public EChartSeries getSeries() {
		return series;
	}

	public void setSeries(EChartSeries series) {
		this.series = series;
	}
}