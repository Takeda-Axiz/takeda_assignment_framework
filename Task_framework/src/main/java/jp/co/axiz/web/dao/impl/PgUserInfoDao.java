package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;

@Repository
public class PgUserInfoDao implements UserInfoDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	private String SQLComm;
	private RowMapper<UserInfo> mapper = new BeanPropertyRowMapper<UserInfo>(UserInfo.class);
	private MapSqlParameterSource SQLParam = new MapSqlParameterSource();

	@Override
	public List<UserInfo> findAll() {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " telephone,"
				+ " password"
				+ " FROM"
				+ " user_info"
				+ " ORDER BY"
				+ " user_id";

		return jdbcTemp.query(SQLComm, mapper);
	}

	@Override
	public List<UserInfo> find(UserInfo cond) {
		// 変数宣言
		Boolean hasUserId;
		Boolean hasUserName;
		Boolean hasTelephone;
		int refAry;

		ArrayList<String> whereCond = new ArrayList<>();
		ArrayList<Object> param = new ArrayList<>();

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " telephone,"
				+ " password"
				+ " FROM"
				+ " user_info"
				+ " WHERE ";

		hasUserId = cond.getUserId() != null;
		if (hasUserId) {
			whereCond.add("user_id = :user_id");
			param.add(cond.getUserId());
		}

		hasUserName = (cond.getUserName() != null && !cond.getUserName().isEmpty());
		if (hasUserName) {
			whereCond.add("user_name = :user_name");
			param.add(cond.getUserName());
		}

		hasTelephone = (cond.getTelephone() != null && !cond.getTelephone().isEmpty());
		if (hasTelephone) {
			whereCond.add("telephone = :telephone");
			param.add(cond.getTelephone());
		}

		if (whereCond.isEmpty()) {
			return findAll();
		}

		String whereString = String.join(" AND ", whereCond.toArray(new String[]{}));

		// SQL文記載
		SQLComm += whereString;
		SQLComm += " ORDER BY"
				+  " user_id";

		refAry = 0;

		if(hasUserId) {
			SQLParam.addValue("user_id", param.get(refAry));
			refAry++;
		}

		if(hasUserName) {
			SQLParam.addValue("user_name", param.get(refAry));
			refAry++;
		}

		if(hasTelephone) {
			SQLParam.addValue("telephone", param.get(refAry));
			refAry++;
		}

		return jdbcTemp.query(SQLComm, SQLParam, mapper);
	}

	@Override
	public UserInfo findById(int id) {
		// 変数宣言
		List<UserInfo> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " telephone,"
				+ " password"
				+ " FROM"
				+ " user_info"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", id);
		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public int register(UserInfo user) {
		// 変数宣言
		int result;
		List<UserInfo> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "INSERT"
				+ " INTO"
				+ " user_info"
				+ " (user_name,"
				+ " telephone,"
				+ " password)"
				+ " VALUES"
				+ " (:user_name,"
				+ " :telephone,"
				+ " :password)";

		SQLParam.addValue("user_name", user.getUserName());
		SQLParam.addValue("telephone", user.getTelephone());
		SQLParam.addValue("password", user.getPassword());

		result = jdbcTemp.update(SQLComm, SQLParam);


		list = find(user);
		if(list.isEmpty() || list.size() != 1) {
			return 0;
		}else {
			user.setUserId(list.get(0).getUserId());
			return result;
		}
	}

	@Override
	public int update(UserInfo user) {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "UPDATE"
				+ " user_info"
				+ " SET"
				+ " user_name = :user_name,"
				+ " telephone = :telephone,"
				+ " password = :password"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", user.getUserId());
		SQLParam.addValue("user_name", user.getUserName());
		SQLParam.addValue("telephone", user.getTelephone());
		SQLParam.addValue("password", user.getPassword());

		return jdbcTemp.update(SQLComm, SQLParam);
	}

	@Override
	public int delete(int id) {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "DELETE"
				+ " FROM"
				+ " user_info"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", id);

		return jdbcTemp.update(SQLComm, SQLParam);
	}

}

