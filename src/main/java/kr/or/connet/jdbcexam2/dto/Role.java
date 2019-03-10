package kr.or.connet.jdbcexam2.dto;

/*
 * 
 mysql> desc role;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| role_id     | int(11)      | NO   | PRI | NULL    |       |
| description | varchar(100) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
2 rows in set (0.01 sec)

mysql> select * from role;
+---------+-----------------+
| role_id | description     |
+---------+-----------------+
|     100 | Developer       |
|     101 | Researcher      |
|     102 | Project manager |
+---------+-----------------+
 */
public class Role {
	private Integer roleId;
	private String description;
	
	
	public Role(Integer roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
}
