package daotest;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import daoimpl.DAOUserImply;
import daoimpl.User;
import daouser.DAOUser;

public class DAOTest {
   @Test
	public void testQuery() {
		DAOUser userImply =  new DAOUserImply();
		List<User> list = userImply.testQuery();
		for(User o :list) {
			System.out.println("id:"+o.getId()+" username:"+o.getUsername()+
					" password:"+o.getPassword());
		}
	}
   @Test
   public void testLogin() {
	   DAOUser userImply = new DAOUserImply();
	   User u = userImply.testLogin("jinfeihu", "10086");
	   System.out.println("age = "+u.getAge()+" address = "+u.getAddress()+" phone = "+u.getPhone());
   }
   @Test
   public void testInsert() {
	   DAOUser userImply = new DAOUserImply();
	   System.out.println(userImply.doInsert("feifei", "10001",19,"É³ºÓ´å","123456"));
   }
   @Test
   public void testDelete() {
	   DAOUser userImply = new DAOUserImply();
	   System.out.println(userImply.doDelete("jinwenmin"));
   }
   @Test
   public void testUpdate() {
	   DAOUser userImply = new DAOUserImply();
	   System.out.println(userImply.doUpdate(3, "jinjinjin"));
   }
}
