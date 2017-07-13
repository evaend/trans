package com.erp.trans.common.entity;

import java.io.Serializable;
import java.util.Set;

public class EChartSeries implements Serializable{ 
		/**图表类型（默认柱状图）*/
		private String type = "bar";
		
		/**数据名称*/
		private String name;
		
		/**需要展示的数据*/
		private Set<String> data;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<String> getData() {
			return data;
		}

		public void setData(Set<String> data) {
			this.data = data;
		}
}
