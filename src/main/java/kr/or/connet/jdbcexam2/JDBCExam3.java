package kr.or.connet.jdbcexam2;

import java.util.List;

import kr.or.connet.jdbcexam2.dao.RoleDao;
import kr.or.connet.jdbcexam2.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		for(Role r : list) {
			System.out.println(r);
		}
		
	}
}
