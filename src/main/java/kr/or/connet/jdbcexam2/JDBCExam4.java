package kr.or.connet.jdbcexam2;

import kr.or.connet.jdbcexam2.dao.RoleDao;
import kr.or.connet.jdbcexam2.dto.Role;

public class JDBCExam4 {
	public static void main(String[] args) {
		
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId,description);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		
		System.out.println(updateCount);
	}
}
