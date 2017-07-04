package com.erp.trans.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.UserInfo;

public interface UserInfoMapper {
    
    /**
     * 
     * findUserNoExist:(验证用户登录账号的唯一性). <br/> 
     */
    int findUserNoExist(@Param(value = "userNo") String userNo);
    
    /**
     * 查询用户的权限菜单
     * @param userId
     */
    List<Map<String,Object>> selectUserMenu(@Param(value = "userId") String userId);
	
	/**
	 * 查询机构用户列表
	 */
	public List<UserInfo> findOrgUserList(Pager pager);
	
	/**
	 * 判断用户名（登录名）是否存在
	 */
	public int countUserno(@Param("userNo")String userno, @Param("excludeUserId")String excludeUserId);
	
	/**
	 * 判断指定机构是否运营商（服务商）
	 */
	public int findServiceOrgByOrgId(@Param("orgId")Long orgId);

	/**
	 * 查看制定机构的状态
	 */
	public String findOrgFstateByOrgId(@Param("orgId")String orgId);

	/**
	 * 查询机构对应的机构管理员
	 */
	Set<String> findManagerUserIdByOrgId(@Param("orgId")Long orgId);
	
	/**
	 * 查询还没有机构管理员的机构列表
	 */
	public List<Map<String, Object>> findWithoutAdminOrgList(Pager pager);
	
	/**
	 * 根据用户id查询用户信息
	 */
	public UserInfo findUserInfoById(String userId);
}