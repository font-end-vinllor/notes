 ## JSP & EL & JSTL
###JSP
> Java Server Page

* 什么是JSP

> 从用户角度看待 ， 就是一个网页 ， 从程序员角度看待 ， 其实是一个Java类， 它继承了servlet,所以可以直接说jsp 就是一个Servlet.

* 为什么会有jsp?

> html 多数情况下用来显示静态内容 ， 一成不变的 。 但是有时候我们需要在网页上显示一些动态数据， 比如：查询所有的学生信息 ， 根据姓名去查询具体某个学生。 这些动作都需要去查询数据库，然后在网页上显示。html是不支持写java代码  ，jsp 里面可以写java代码.

### 怎么用jsp
* 指令写法
<%@ 指令名字 %>

### page指令

* lanuage
> 表明jsp页面中可以写java代码

* contentType

> 表明这个文件是什么类型，告诉浏览器我是什么内容类型，以及使用什么编码

				<contentType="text/html;charset=UTF-8"
				text/html  MIMEType 这是一个文本，html网页

可以查看web.xml文件

* pageEncoding jsp内容编辑  
* extends 用于指定jsp翻译成java文件后，继承的父类是谁，一般不用改。  
* import 导包使用，一般不用手写
* session

> 值可选的有true or false
> 用于控制在这个jsp页面里面，是否能够直接使用session对象
> 具体的区别可以看翻译后的Java文件  （tomcat--work）如果该值是true，代码里面会有getSession()的调用，如果是false，那么就不会有该方法的调用，也就没有session对象了，
在页面上自然无法使用Session。 

* errorPage
> 指的是错误的页面 ， 值需要给错误的页面路径

* isErrorPage

> 上面的errorPage  用于指定错误的时候到哪一个页面，那么这个isErrorPage ， 就是声明某一个页面到底是不是错误的页面。

### include
> 包含另外一个jsp进来。

		<%@ include file="other.jsp"%>

* 背后细节：
> 把另一个页面的所有内容拿过来一起输出。 所有的标签元素都包含进来。

### taglib

		<%@ taglib prefix="" uri=""%>

		uri:  标签库路径
		prefix: 标签库的别名

##JSP动作标签

      

* jsp:include

		<jsp:include page="other01.jsp"></jsp:include>
拿过来。
>  包含指定的页面，这里指的是动态包含。也就是不包含页面的所有就元素，而是把它的运行结果

* jsp:forward

			<jsp:forward page="other01.jsp"></jsp:forward>
> 前往哪一个页面

    request.getRequestDispatcher("other01.jsp").forward(request, response);   --------内部实现------查看work里转换后的文件

		if (true) {
        _jspx_page_context.forward("other01.jsp");
        return;
      }

* jsp:param

> 在包含某个页面或者跳转至某个页面的时候，带入这个参数

					带入参数
					<jsp:forward page="other01.jsp">
			<jsp:param value="jinfeihu" name="boyfriend"/>
			</jsp:forward>
			

				接收参数
						<%
			String value = request.getParameter("boyfriend");
			%>
			<%=value %>

<font color="red">有中文乱码问题，还没解决</font>

## JSP内置对象

> 所谓内置对象， 就是我们可以直接在jsp页面中使用这些对象 ， 不用创建。

pageContext  
request   
session    
application  

以上是四个作用域对象

* 作用域

> 表示这些对象可以存值，他们的取值范围有限定
setAttribute  getAttribute

						<%
			pageContext.setAttribute("name", "page");
			request.setAttribute("name", "request");
			session.setAttribute("name", "session");
			application.setAttribute("name", "application");
			
			%>
			<%=pageContext.getAttribute("name")%>
			<%=request.getAttribute("name") %>
			<%=session.getAttribute("name") %>
			<%=application.getAttribute("name") %>



### 四个作用域的区别

* pageContext  [PageContext]

> 作用域只限于当前的页面

*  request  【HttpServletRequest】

>  作用域仅限于一次请求，只要服务器对该请求做了响应，这个域中存的值就没有了。

*  session[HttpSession]

> 作用域仅限于一次会话（即多次请求与响应）

*  application  [ServletContext]

> 整个工程都可以访问 ， 服务器关闭后就不能访问了。

- out  [JspWriter]
- response  [HttpServletResponse] 

![icon](img/img01.png)

- exception  [Throwable]  
- page       [Object]   --- 就是这个jsp翻译成的java类的实例对象
- config     [ServletConfig]

## EL表达式

>  ${}

- <h3>普通方式存取内置对象的值</h3>
						
				<%
						pageContext.setAttribute("name", "page");
						session.setAttribute("name", "session");
						request.setAttribute("name","request");
						application.setAttribute("name", "application");
				
				%>
				<%=pageContext.getAttribute("name")%>
				<%=session.getAttribute("name") %>
				<%=request.getAttribute("name") %>
				<%=application.getAttribute("name") %>
		
- <h3>使用EL表达式取四个内置对象的值</h3>				
								
				${pageScope.name }
				${sessionScope.name }
				${requestScope.name }
				${applicationScope.name }

- <h3>使用普通方式取数组，集合的值</h3>
						<%
						String[] a = {"aa","bb","cc"};
						pageContext.setAttribute("array", a);
						
						
						List list = new ArrayList();
						list.add("aa");
						list.add("bb");
						list.add("cc");
						pageContext.setAttribute("list",list);
						

						Map<String,String> map = new HashMap<>();
						map.put("name", "jinfeifei");
						map.put("age", "19");
						map.put("address", "xian");
						map.put("his.girlFriend", "wenwen");
						pageContext.setAttribute("map", map);
						%>
			数组

						<br>使用普通方式取值<br>
						<%=a[0] %>
						<br>使用EL表达式取值<br>
						${array[0] }  ${array[1] }
						
			list集合
						<br>使用普通方式去除List集合中的值<br>
						<%=list %>
						<br>使用EL表达式去值<br>
						${list }

			map集合
						<br>使用普通方式取值<br>
						<%=map %>
						<%=map.get("name") %>
						<%=map.get("age") %>
						<%=map.get("his.girlFriend") %>
						<br>使用EL表达式<br>
						${map }
						${map.address }
						${map["his.girlFriend"] }
						

### 取值细节

1. 从域中取值，先得存值

		<%  
				//pageContext.setAttribute("name","zhangsan");
			
				session.setAttribute("name","jinfeihu");
			%> 

			<br>直接指定了到这个作用域里取值
			${pageScope.name  }

		<br>// 先从page里面找，没找到的话，去request里面找，没找到去session里面找，还没找到，去application里面找。

			${ name}
		<br>//指定在session里面找
			${sessionScope.name}

2. 取值方式

如果值可以用下标取，那么直接使用[]

		<%

			String[] array = {"aa","bb","cc"}
			session.setAttribute("array",array);

			%>
			
			${array[1] }   ---> 这里array说的是attribute里面的array

如果没有下标，直接使用 . 的方式取值

			<%   
				User user = new User("jinfeihu",19);
				session.setAttribute("u",user);

			%>

			${u.name}  ${u.age}

一般使用EL表达式，用的比较多的，都是从一个对象中取出它的属性值，比如取出某一个学生的姓名。

## EL表达式 的11个内置对象

${对象名.成员}

- pageContext  通过这个可以得出其他的作用域对象

作用域相关对象

- pageScope
- requestScope
- sessionScope
- applicationScope

头信息相关对象

- header
- headerValues

参数信息相关对象

- param
- paramValues

- cookie

全局初始化参数

- initParam

## JSTL

> 全程 : JSP Standard Tag Library  jsp标准标签库

> 用途 ： 简化JSP的代码编写 ， 替换<%%>写法，一般与EL表达式配合使用。

### 怎么使用

1. 导入jar文件到工程的webContent/Web-Inf/lib    jstl.jar   standard.jar  
2.  在JSP页面上， 使用taglib 指令 ， 来引入标签。
3.  注意： 如果想支持EL表达式 ， 那么引入的标签库必须选择1.1的版本 ， 1.0 的版本不支持EL表达式 。 

				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

## 常用属性

			<c:set></c:set>
		   <c:if test=""></c:if>
		   <c:forEach></c:forEach>
					
* <c:set></c:set>
> 用于存一个值到作用域里面，作用域默认是pageContext

			<c:set var="name" value="jinfeihu" scope="session"></c:set>
   			${sessionScope.name }

				var  变量名
				value  值
				scope   所存的作用域

* <c:if test = ""></c:if>
> 与EL表达式结合 ， 用于做判断  以及可以把判断的结果保存在一个变量中，进而把变量保存在一个作用域中。

							<c:set var="age" value="19"></c:set>
			   <c:if test="${age > 18}">
			        <br>我家靳飞虎------<br>
			   </c:if>
			   
			   <c:if test="${age <= 20 }" var="result">
			   
			   我家靳飞虎年龄小于20<br>
			   </c:if>
			   ${result }
结果：
			
				jinfeihu 
				我家靳飞虎------
				我家靳飞虎年龄小于20
			    true 


* <c:forEach var="" items="" step=""></c:forEach>
> 用于遍历
				
							简单遍历<br>
				   <c:forEach begin="1" end="8" var="i">
				   ${i }
				   </c:forEach>
				   
				   <br>遍历集合<br>
				   <%
				   List list = new ArrayList() ;
				   list.add(new User("jinfei",19));
				   list.add(new User("jinwen",20));
				   list.add(new User("jinzhi",15));
				   pageContext.setAttribute("list", list);
				   
				   %>
				   <!-- var  遍历的每一个元素
				   items   遍历哪一个对象  和EL表达式结合 将对象从作用域中取出来
				   step  增幅为多少 -->
				   <c:forEach var="user" items="${list }" step="" >
				  ${user.name}----${user.age } <br>
				   
				   </c:forEach>

结果： 

					简单遍历
					1 2 3 4 5 6 7 8 
					遍历集合
					jinfei----19 
					 jinwen----20 
					 jinzhi----15 
				   
				   