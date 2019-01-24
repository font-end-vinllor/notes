package daouser;

import java.util.List;

import daoimpl.User;

/**
 * 定义数据库访问规则
 *
 */
public interface DAOUser {
	List<User> testQuery();
	int doDelete(String name);
	int doUpdate(int id,String name);
	User testLogin(String username , String pasword);
	int doInsert(String name, String password, int age, String address, String phone);
}
