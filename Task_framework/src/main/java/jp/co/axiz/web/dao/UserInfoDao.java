package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.UserInfo;

public interface UserInfoDao {

	List<UserInfo> findAll();

	List<UserInfo> find(UserInfo cond);

	UserInfo findById(int id);

	int register(UserInfo user);

	int update(UserInfo user);

	int delete(int id);

}
