### 安装tomcat(是一个servlet容器)
> servlet容器其实是一个简单web服务器来使用

1. 将tomcat压缩文件解压到/home/soft01/opt/apache-tomcat5.5.23.tar.gz
2. 配置环境变量
3. 启动tomcat
>  cd /home/soft01/apache-tomcat/bin  
> sh startup.sh或者sh catalina.sh run  
> 接下来，可以打开浏览器，输入http://localhost:8080  
> 如果要关闭tomcat,可以使用  
> cd /home/soft01/apache-tomcat/bin   
> sh shutdown.sh
### 如何写一个servlet
1. 先写一个java类，实现Servlet接口或者继承HttpServlet抽象类
2. 编译
3. 打包  
 
        即创建一个具有如下结构的文件夹
			appname(应用名)
			    WEB-INF
				   classes(.class文件)
				   lib(.jar文件，可选)
				   web.xml(部署描述文件url-pattarn)

4. 部署  
   
         将第三步创建的文件夹拷贝到servlet容器特定的文件夹下面
<font size = 5  color = "blue">attention: 也可以将第三步创建的文件夹使用jar命令进行压缩，生成.war为后缀的文件，然后拷贝。</font>
5. 启动servlet容器，访问servlet
     
         http://ip:port/appname/url-pattern(url-pattarn描述如何访问servlet)

			