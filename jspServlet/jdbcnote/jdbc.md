# 一 . JDBC  
> &emsp;&emsp;sun公司提供的一种数据库访问规则，规范，由于数据库种类较多，并且java语言使用比较广泛，sun公司提供的规范让其他数据库提供商去实现底层的访问规则。java程序只要使用sun公司提供的jdbc驱动即可。
### I. jdbc的基本使用   

       try {
			// 注册驱动  
			DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
			 // 获取连接  
			 // DriverManager.getConnection("jdbc:mysql://localhost/student?user=root&password=1931165mwj");  
             //协议+访问的数据库   用户名    密码
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student?serverTimezone=GMT&useSSL=false", "root", "1931165mwj");  
			Statement st = conn.createStatement();  
			ResultSet rs = st.executeQuery("SELECT * FROM s_tu");  
			while (rs.next()) {  
				int id = rs.getInt("id");  
				String name = rs.getString("name");  
				int age = rs.getInt("age");  
				System.out.println("id = " + id + " name = " + name + " age = " + age);  
			}  
			JDBCclose.release(conn, rs, st); 
		} catch (SQLException e) {  
			e.printStackTrace();  
		} 
释放资源  

     public class JDBCclose {
	/**
	 * 释放资源
	 * @param conn
	 * @param rs
	 * @param st
	 */
	public static void release(Connection conn,ResultSet rs, Statement st) {
		closeConnection(conn);
		closeResultset(rs);
		closeStatement(st);
	}
	
	private  static void closeResultset(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs =  null;
			}
	}
	private static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				st = null;
			}
		}
	}
	private static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	  }
    }
### JDBC工具类构建
1. 资源释放工作的整合

2. 驱动防二次注册
  
         // 注册驱动  
			DriverManager.deregisterDriver(new   com.mysql.cj.jdbc.Driver());
            Driver类里面的静态代码块(加载类时)已经执行驱动注册，上面代码等同注册了俩次。
		--------->
            最后形成的加载类驱动的代码

			jdbc 4.0 以后  可以不用写加载类驱动，会自动连接。mysql jar包底下META-INF services/java.sql.Driver
			查看驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
3. 使用properties配置文件  
  
         driverclass=com.mysql.cj.jdbc.Driver  
         url=jdbc:mysql://localhost/student?serverTimezone=GMT&useSSL=false  
         name=root
         password=1931165mwj

---
        static String url = null;
	    static String name = null;
	    static String password = null;
	    static String driverclass = null ;
	    static {
			//创建属性配置对象
		   Properties  properties = new Properties();
		   try { 
           // 如果配置文件放在工程的根目录下
			 //properties.load(new FileInputStream("jdbc.properties"));

			//如果配置文件放在src目录下，此时文件是在当前类的class的父目录下，加载类时，也加载了资源
			 InputStream in = JDBCclose.class.getClassLoader().getResourceAsStream ("jdbc.properties");
			 properties.load(in);

		  } catch (Exception e) {
		    	e.printStackTrace();
		  }
		    name = properties.getProperty("name");
		    password = properties.getProperty("password");
		    url = properties.getProperty("url");
		    driverclass = properties.getProperty("driverclass");
	     }

###   数据库的CRUD
1. insert  

                  INSERT INTO s_tu (name,age) VALUES ("靳飞飞"，19);  
		          INSERT INTO s_tu VALUES (1,"靳飞飞",19);  
2.delete

                        DELETE FROM s_tu WHERE  id = 1 ;
3.update
		
					  UPDATE s_tu SET age = 1 WHERE id = 1 ;

4.query

				               SELECT * FROM s_tu;
### 使用单元测试 Junit  
1. 定义一个测试类
2. 添加junit的支持
  
        右键工程 --- add library --- Junit --- junit 4

3. 需测试的方法上添加 @Test

            @Test
			public void testQuery(){...}
4. 光标选中方法名字，右键执行单元测试，/打开outline ，选择测试的方法。
### Query  
            @Test
       public void testQuery() {
	   
	        Connection conn = null ;
	        Statement st = null;
	        ResultSet eq = null ;
	   try { 
		    conn = JDBCclose.getConn();
		    st = conn.createStatement();
		    String sql = "SELECT * FROM s_tu";
		    eq = st.executeQuery(sql);
		while(eq.next()) {
		    int id = eq.getInt("id");
		    String name = eq.getString("name");
		    int age = eq.getInt("age");
		    System.out.println("id = "+id+" name"+name+" age = "+age);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		 JDBCclose.release(conn, eq, st);
	}
     } 
>  <font size = 5 color = "green">&emsp;&emsp;insert delete update 其实都是对表的更新，所以都用到executeUpdate()方法。</font>
### Insert  
			@Test
	  public void testInsert() {
		    Connection conn = null ;
		    Statement st = null ;
		
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			//name用单引号括起来
			String sql = "INSERT INTO s_tu(name,age) VALUES ('xiaoli',34)";
			//使用executeUpdate(sql)方法编译sql语句	
		    int result = st.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//重载release方法
			JDBCclose.release(conn, st);
		}
	}
### Delete
			@Test
	    public void testDelete() {
		     Connection conn = null ;
		     Statement st = null ;
		try {
			 conn = JDBCclose.getConn();
		     st = conn.createStatement();
		     String sql = "DELETE FROM s_tu WHERE age = 19";
			 int result = st.executeUpdate(sql);
			 System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, st);
		}	
	}
### Update
		@Test
	public void testUpdate() {
		Connection conn = null ;
		Statement st = null ;
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			String sql = "Update s_tu SET age = 29 WHERE name = 'jinjin'";
			int result = st.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, st);
		}	
	   }

---
### DAO模式
> Data Access Object 数据访问对象  

1. 新建一个DAO接口，里面声明数据库访问规则。

             /**  
              * 定义数据库访问规则  
              *  
              */  
           public interface DAOUser {  
              	void testQuery();  
            }  
2. 新建一个DAO实现类，具体实现之前定义的规则。
   
							/**
				             * 定义的DAO实现类
				             *
				             */
				        public class DAOUserImply implements DAOUser {
					         @Override
					        public void testQuery() {
					             	Connection conn = null;
					            	Statement st = null;
						            ResultSet rs = null;
						try {
							conn = JDBCclose.getConn();
							st = conn.createStatement();
							String sql = "SELECT * FROM t_user";
							rs = st.executeQuery(sql);
							while(rs.next()) {
								String username = rs.getString("username");
								String password = rs.getString("password");
								System.out.println(username + " = " +password);
							}
						} catch (Exception e) {
							e.printStackTrace();
						  } finally {
						    	JDBCclose.release(conn, rs, st);
					   	     }
				
								       }
							
							         }


3. 直接使用实现  

						     @Test
							public void test() {
								DAOUser userImply =  new DAOUserImply();
								userImply.testQuery();
							}
### Statement安全问题
1. Statement执行，其实是拼接sql语句的。先拼接语句，后一起执行。

            String sql = "SELECT * FROM t_user "
					+ "WHERE username = '"+username+"' AND PASSWORD = '"+password+"'";
			@Test
		   public void testLogin() {
			   DAOUser userImply = new DAOUserImply();
			   userImply.testLogin("jinfeihu", "10088 ' or ' 1=1");
		   }
	
			"SELECT * FROM t_user "
					+ "WHERE username = '"+username+"' AND PASSWORD = '"+password+"' OR 1=1";
					
> <font color = "red">前面先拼接sql语句，如果变量里面有了数据库的关键字。不认为是普通字符串。  rs = st.executement(sql);</font>   
###   PrepareStatement替换Statement 

				conn = JDBCclose.getConn();
							String sql = "SELECT * FROM t_user "
									+ "WHERE username = ? AND PASSWORD = ?";
						//先对sql语句进行语法的检验，之后传进来的参数都是普通字符串，不会被当做关键字。
							ps = conn.prepareStatement(sql);
							ps.setString(1, username);
							ps.setString(2, password);
							rs = ps.executeQuery();

---

	           conn = JDBCclose.getConn();
			    String sql = "update t_user set username = ? where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, id);
				int result = ps.executeUpdate();
				if(result > 0) System.out.println("更新成功");
				else System.out.println("更新失败");

## 总结
1. JDBC入门
2. 抽取工具类（释放资源 获取连接）
3. Statement CRUD
4. DAO模式  
> 声明与实现分开

5. PrepareStatement CRUD
> 预处理sql语句，解决Statement的安全问题

##练习
1. DAO里面声明 CRUD ，以及登陆的方法
> 登陆方法，成功后返回该用户的所有信息，字段不限  
> 查询： 如果是findAll(),返回一个集合，List<User>  
> 增加&删除&更新：返回影响的行数  int 类型