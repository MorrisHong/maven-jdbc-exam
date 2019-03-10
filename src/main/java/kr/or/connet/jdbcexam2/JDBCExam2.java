package kr.or.connet.jdbcexam2;

import kr.or.connet.jdbcexam2.dao.RoleDao;
import kr.or.connet.jdbcexam2.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		int roleId = 501;
		String description = "CTO";
		Role role = new Role(roleId, description);
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);
		
	}
}
