## bootstrap

### 是什么？
> 简单，灵活的用于搭建WEB页面的HTML,CSS,JavaScript的工具集。
> 是一款简洁强大的前端开发框架。 

### 意义
> 让WEB开发更迅速，更简单。

	2011年，twitter的“一小撮”工程师为了提高他们内部的分析和管理能力，用业余时间为他们的产品构建了一套易用、优雅、灵活、可扩展的前端工具集--BootStrap。Bootstrap由MARK OTTO和Jacob Thornton所设计和建立


### GitHub上这样介绍 bootstrap：

    ☑  简单灵活可用于架构流行的用户界面和交互接口的html、css、javascript工具集。

    ☑  基于html5、css3的bootstrap，具有大量的诱人特性：友好的学习曲线，卓越的兼容性，响应式设计，12列格网，样式向导文档。

    ☑  自定义JQuery插件，完整的类库，基于Less等。

## 基本的HTML模板

* bootstrap模板为使IE6、7、8版本（IE9以下版本）浏览器兼容html5新增的标签，引入下面代码文件即可。
		
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>

* 同理为使IE6、7、8版本浏览器兼容css3样式，引入下面代码：

		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		 

- css 文件放在<head></head>标签里
- js 文件放在<body></body>后
-  因为js是基于jQuery ,所以导入文件时，Jquery在前，js在后。

        <meta name="viewport" content="width=device-width, initial-scale=1">


		意思：保持和物理设备一样的宽度，并且初始缩放比为1：1

实例：

		<!DOCTYPE html>
		<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap的HTML标准模板</title>   
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--你自己的样式文件 -->
        <link href="css/your-style.css" rel="stylesheet">        
        <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <h1>Hello, world!</h1>
        
        <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
        <script src="https://www.imooc.com/static/lib/jquery/1.9.1/jquery.js"></script>
        <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
    </body>
	</html>

## 标题（一）

> 标题的使用和平常使用是一样的，使用h1~h6标签 ， 分别表示标题一至标题六 ，h后面的数字越大，表示的级别越小，文本也越小。

---

> 在bootstrap中为了让非标题元素和标题使用相同的样式 ，特别定义了.h1~.h6六个类名。
> <font color="red">效果与上面一样。</font>

		<!--Bootstrap中的标题-->
		<h1>Bootstrap标题一</h1>
		<h2>Bootstrap标题二</h2>
		<h3>Bootstrap标题三</h3>
		<h4>Bootstrap标题四</h4>
		<h5>Bootstrap标题五</h5>
		<h6>Bootstrap标题六</h6>
		
		<!--Bootstrap中让非标题元素和标题使用相同的样式-->
		<div class="h1">Bootstrap标题一</div>
		<div class="h2">Bootstrap标题二</div>
		<div class="h3">Bootstrap标题三</div>
		<div class="h4">Bootstrap标题四</div>
		<div class="h5">Bootstrap标题五</div>
		<div class="h6">Bootstrap标题六</div>

## 标题（二）

> 在WEB制作中 ， 常常会碰到一个标题后面紧跟着一行小的副标题。在Bootstrap中，考虑这种排版效果，使用
 
			<small></small>
>标签来制作副标题。

1. 行高都为1，而且font-weight设置了normal变成了常规效果（不加粗），同时颜色被设置为灰色（#999）.
2.  由于small内的文本字体在h1~h3内，其大小都设置为当前字号的65%；而在h4~h6内的字号都设置为当前字号的75%。

## 段落（正文文本）

> 在bootstrap中为文本设置了一个全局的文本样式（所指正文文本）

源码：

		该几个属性都为继承属性
		body {
		font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		font-size: 14px;
		line-height: 1.42857143;
		color: #333;
		background-color: #fff;
		}
		
		p {
 		   margin: 0 0 10px;
		}

## 强调内容

> 如果想让一个段落突出显示 ，  可以通过添加类名".lead" 实现， 其作用就是增大文本字号 ，加粗文本 ， 而且对行高和margin也做相应的处理。
		
		<p>我是普通文本，我的样子长成这样我是普通文本，我的样子长成这样我是普通文本，</p>
		<p class="lead">我是特意要突出的文本，我的样子成这样。我是特意要突出的文本，我的样子长成这样。</p>

源码：
			
			.lead {
			margin-bottom: 20px;
			font-size: 16px;
			font-weight: 200;
			line-height: 1.4;
			}
			@media (min-width: 768px) {/*大中型浏览器字体稍大*/
			.lead {
			font-size: 21px;
			  }
			}

> 除此， bootstrap还可通过元素标签：< small > < strong > < em >
> < cite > 给文本做出突出样式处理。

![icon](img/qiangdiao.PNG)

	