package com.erp.trans.web;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.trans.common.constant.CustomConst.LoginUser;
import com.erp.trans.common.entity.Pager;
import com.erp.trans.service.DataStatisticsService;
/**
 * 数据统计、统计图表分析
 * 2017年7月11日 上午10:12:10
 * @author 陶悠
 *
 */
@Controller
@RequestMapping("dataStatistics")
public class DataStatisticsController {
		@Autowired
		DataStatisticsService dataStatisticsService;
		
		/**
		 * 数据统计-数据明细查询
		 */
		@RequestMapping("searchBusinessData")
		@ResponseBody
		public Pager<Map<String, Object>> searchBusinessData(
				@RequestParam(value = "transportTool", required = false) String transportTool,
				@RequestParam(value = "createDateStart", required = false) String createDateStart,
				@RequestParam(value = "createDateEnd", required = false) String createDateEnd,
				@RequestParam(value = "despatchDateStart", required = false) String despatchDateStart,
				@RequestParam(value = "despatchDateEnd", required = false) String despatchDateEnd,
				@RequestParam(value = "locationFrom", required = false) String locationFrom,
				@RequestParam(value = "locationTo", required = false) String locationTo,
				@RequestParam(value = "consignOrgName", required = false) String consignOrgName,
				@RequestParam(value = "receiveOrgName", required = false) String receiveOrgName,
				@RequestParam(value = "carrierName", required = false) String carrierName, HttpServletRequest request) {
			Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(false);
//			pager.setPageSize(pagesize == null ? 15 : pagesize);
//			pager.setPageNum(page == null ? 1 : page);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
			// 当前登录用户的机构
			String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
			if (StringUtils.isNotBlank(createDateStart)) {
				pager.addQueryParam("createDateStart", createDateStart);
			} 
//			else {
//				Calendar cal = Calendar.getInstance();
//				cal.add(Calendar.YEAR, -1);
//				pager.addQueryParam("createDateStart", formatter.format(cal.getTime()));// 默认前一年开始
//			}

			if (StringUtils.isNotBlank(createDateEnd)) {
				pager.addQueryParam("createDateEnd", createDateEnd);
			} 
//			else {
//				Calendar cal1 = Calendar.getInstance();
//				pager.addQueryParam("createDateEnd", formatter.format(cal1.getTime()));// 默认当前时间
//			}
			if (StringUtils.isNotBlank(despatchDateStart)) {
				pager.addQueryParam("despatchDateStart", despatchDateStart);
			}
			if (StringUtils.isNotBlank(despatchDateEnd)) {
				pager.addQueryParam("despatchDateEnd", despatchDateEnd);
			}
			pager.addQueryParam("orgId", orgId);// 当前登录机构
			pager.addQueryParam("transportTool", transportTool);//轿运车
			pager.addQueryParam("consignOrgName", consignOrgName);//托运单位
			pager.addQueryParam("locationFrom", locationFrom);//起运地
			pager.addQueryParam("locationTo", locationTo);//目的地
			pager.addQueryParam("receiveOrgName", receiveOrgName);//收车单位
			pager.addQueryParam("carrierName", carrierName);//承运商


			List<Map<String, Object>> dispatchList = dataStatisticsService.searchBusinessData(pager);
			pager.setRows(dispatchList);

			return pager;
		}
}
