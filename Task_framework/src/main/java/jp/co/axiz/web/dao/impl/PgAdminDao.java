package jp.co.axiz.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.exception.DataAccessException;
import jp.co.axiz.web.util.DbUtil;

@Repository
public class PgAdminDao implements AdminDao {

	private String SQLComm;

	@Override
	public Admin findByIdAndPassword(String id, String password) {

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
				+ " admin_id = ?"
				+ " AND"
				+ " password = ?";

		try (Connection con = DbUtil.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQLComm)) {
			stmt.setString(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Admin a = new Admin();
				a.setId(rs.getString("admin_id"));
				a.setName(rs.getString("admin_name"));
				a.setPassword(rs.getString("password"));
				return a;
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}

		return null;
	}

}
