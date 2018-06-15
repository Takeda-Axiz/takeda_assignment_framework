package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;

@Repository
public class PgAdminDao implements AdminDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	private String SQLComm;
	private RowMapper<Admin> mapper = new BeanPropertyRowMapper<Admin>(Admin.class);
	private MapSqlParameterSource SQLParam = new MapSqlParameterSource();

	@Override
	public Admin findByIdAndPassword(String id, String password) {
		// 変数宣言
		List<Admin> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " admin_id,"
				+ " admin_name,"
				+ " password"
				+ " FROM"
				+ " admin"
				+ " WHERE"
				+ " admin_id = :admin_id"
				+ " AND"
				+ " password = :password";

		SQLParam.addValue("admin_id", id);
		SQLParam.addValue("password", password);
		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return list.get(0);
		}
	}

}
