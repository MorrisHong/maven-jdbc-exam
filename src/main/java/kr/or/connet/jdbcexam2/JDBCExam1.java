package kr.or.connet.jdbcexam2;

import kr.or.connet.jdbcexam2.dao.RoleDao;
import kr.or.connet.jdbcexam2.dto.Role;

public class JDBCExam1 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(501);
		
		System.out.println(role);
	}
}
