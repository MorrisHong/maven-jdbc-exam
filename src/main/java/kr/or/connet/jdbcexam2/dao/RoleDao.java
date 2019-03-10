package kr.or.connet.jdbcexam2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

import kr.or.connet.jdbcexam2.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul";
	private static String dbuser = "connectuser";
	private static String dbpassword = "connect123!@#";

	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		DBConnect dbconnect = new DBConnect();
		try {
			conn = dbconnect.getConn();
			String sql = "select description, role_id from role where role_id = ?";
			ps = dbconnect.getPs(conn, sql);
			ps.setInt(1, roleId); // 첫번째인자는 물음표 순서, 두번째는 물음표대신 들어갈 쿼리.
			rs = dbconnect.getRs(ps);

			if (rs.next()) {
				String description = rs.getString(1); // 인자값 : 위에 ps = conn.prepareStatement(sql); 실행했을 때 순서대로..
				int id = rs.getInt(2);
				// rs.getInt(role_id);

				role = new Role(id, description);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps, rs);
		}

		return role;
	}

	//Insert
	public int addRole(Role role) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

		try  {
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps);
		}
		return insertCount;
	}

	public List<Role> getRoles() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		List<Role> list = new ArrayList<>();

		String sql = "SELECT description, role_id FROM role order by role_id desc";

		try  {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps);
		}
		return list;
	}

	//Delete
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);

			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, roleId);

			deleteCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps);
		}

		return deleteCount;
	}

	//Update
	public int updateRole(Role role) {
		int updateCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);

			String sql = "update role set description = ? where role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());

			updateCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps);
		} 

		return updateCount;
	}

}
