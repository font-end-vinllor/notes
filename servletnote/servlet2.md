## HttpServletRequest && HttpServletResponse

###Servlet配置方式

* 1. 全路径匹配

> 以 / 开始   eg. /a  /aa    /ab
> locahost:8080/项目名称/aa/bb

* 2. 路径匹配，前半段匹配

> 以 / 开始 ， 但是以 * 结束     /a/*  /*
> * 是一个通配符，匹配任意文字
> localhost:8080/项目名称/aaxvd

* 3. 以扩展名形式匹配
> 没有/ 以*开始    *.aa  *.bb

### ServletContext
> Servlet 上下文
> 每个web工程都只有一个ServletContext对象。即不管在哪个Servlet里面，获取到的ServletContext对象都是同一个。

### 如何得到对象

	   //获取对象
			ServletContext context = getServletContext();
			
###作用
1. 可以获取全局配置参数（getInitParameter（））

		<!-- 全局参数  任意一个Servlet都可以拿 -->
		 <context-param>
		 <param-name>name</param-name>
		 <param-value>我家大王</param-value>
		 </context-param>

代码:

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
				//获取对象
				ServletContext context = getServletContext();
				//根据name 获取value
				String parameter = context.getInitParameter("name");
				System.out.println("name = "+parameter);
			}
2. 可以获取web应用中的资源（getRealPath（））

			1. 获取资源在tomcat里面的绝对路径
			     ServletContext context = getServletContext();
		  String path = context.getRealPath("");//得到项目在tomcat里面的根目录
		===>  D:\apache-tomcat-9.0.13\wtpwebapps\webProject\

			protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
				ServletContext context = getServletContext();
				String path = context.getRealPath("file/web.properties");
				System.out.println(path);
				//1.创建properties对象
				Properties pro = new  Properties();
				//2.获取输入流并且加载资源
				InputStream  in = new  FileInputStream(path);
				pro.load(in);
				//3. 获取属性值
				String value = pro.getProperty("name");
				System.out.println("his name = "+value);
		}
				结果：
			D:\apache-tomcat-9.0.13\wtpwebapps\webProject\file\web.properties
			his name = wojiaaifei

		2. getResourceAsStream 获取资源 流对象

		        直接给相对的路径，然后获取流对象。

 ![icon](img/img03.png)