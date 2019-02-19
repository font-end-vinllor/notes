# 网格系统
## 基本用法
> 通过列的组合，即将一行分成了多少列。更改数字合并列，不能超过总数。
row必须放在container下
怎么用？
		
		<div class="container">
		  <div class="row">
		    <div class="col-md-4">.col-md-4</div>
		    <div class="col-md-8">.col-md-8</div>
		  </div>
		  <div class="row">
		    <div class="col-md-4">.col-md-4</div>
		    <div class="col-md-4">.col-md-4</div>
		    <div class="col-md-4">.col-md-4</div>
		  </div>
		  <div class="row">
		    <div class="col-md-3">.col-md-3</div>
		    <div class="col-md-6">.col-md-6</div>
		    <div class="col-md-3">.col-md-3</div>
		 </div>
		</div>

![icon](img1/row.jpg)

### 列偏移
> 如果不希望俩个相邻的列紧靠在一起。可以使用列偏移（offset）功能实现。

怎么用？
需要在列元素添加类名-----“.col-md-offset-*”------（*代表偏移列组合数）
		
		<div class="container">
			<div class="row">
				<div class="col-md-4">col-md-4</div>
				<div class="col-md-3 col-md-offset-3">col-md-3</div>
				<div class="col-md-2">col-md-2</div>
			</div>
		</div>

移动后总共不能超过12列

### 列排序
> 即改变列的方向，就是改变左右浮动，可以将列左右移动。  
> -----“.col-md-push-*”-----向右移动  
> -----“.col-md-pull-*”-----向左移动

怎么用？
在列元素上添加类名
		
		两列网格交换位置
		<div class="container">
		  <div class="row">
		    <div class="col-md-4 col-md-push-8">.col-md-4</div>
		    <div class="col-md-8 col-md-pull-4">.col-md-8</div>
		  </div>
		</div>

### 列的嵌套
		
		<div class="container">
		  <div class="row">
		    <div class="col-md-8">
		      我的里面嵌套了一个网格
		      <div class="row">
		        <div class="col-md-6">col-md-6</div>
		        <div class="col-md-6">col-md-6</div>
		      </div>
		    </div>
		    <div class="col-md-4">col-md-4</div>
		  </div>
		  <div class="row">
		    <div class="col-md-4">.col-md-4</div>
		    <div class="col-md-8">
		      我的里面嵌套了一个网格
		      <div class="row">
		        <div class="col-md-4">col-md-4</div>
		        <div class="col-md-4">col-md-4</div>
		        <div class="col-md-4">col-md-4</div>
		      </div>
		    </div>
		  </div>
		</div>

# 菜单 ，按钮 ，导航
##下拉菜单（基本用法）
> 在使用bootstrap框架的下拉菜单，必须调用bootstrap框架提供的bootstrap.js,因为bootstrap组件交互效果都是依赖于jquery.js，所以要加在前面。
		
示例：

		<div class="dropdown">
		<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">下拉菜单
		 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a>香蕉</a></li>
			<li><a>苹果</a></li>
			<li><a>葡萄</a></li>
			<li><a>橘子</a></li>
		</ul>
	</div>

![icon](img1/menu.jpg)
怎么用？

1. 使用一个名为"dropdown"的容器包裹了整个下拉菜单元素
2. 使用一个&lt;button&gt;按钮作为父菜单，并且定义类名为“.dropdown-toggle”和自定义".data-toggle"属性，值与最外容器类名一致。
3. 下拉菜单项使用一个ul列表，并且定义一个类名为".dropdown-menu"

##下拉菜单（下拉分隔线）

怎么用？   
在组与组中间添加一个空的< li >并且添加类名“. divider”来实现分隔线的功能。

		<div class="dropdown">
				<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">下拉菜单
				 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a>香蕉</a></li>
					<li><a>苹果</a></li>

					<li class="divider"></li>

					<li><a>葡萄</a></li>
					<li><a>橘子</a></li>
				</ul>
			</div>

##下拉菜单（菜单标题）
> 给菜单项添加类名----".dropdown-header"------

		<li class="dropdown-header">这是菜单一的标题</li>

##下拉菜单（对齐方式）
> 通过给下拉菜单添加类名

1. .pull-right 向父容器的右边对齐
2. .dropdown-menu-right ...
3. .dropdown-menu-left  向父容器的左边对齐（默认样式）

		<ul class="dropdown-menu pull-right"></ul>

## 下拉菜单（菜单项状态）
> 在li元素上添加类名即可

1. 悬浮状态   :hover默认
2. 焦点状态   ：focus 默认
3. 当前状态    .active
4. 禁用状态    .disabled

		<li class="active"></li>

##按钮（按钮组）
> 使用一个名为“.btn-group”的容器，将多个按钮放在这个容器中。
		
		<div class="btn-group">
		  <button type="button" class="btn btn-default">
		     <span class="glyphicon glyphicon-step-backward"></span>
		  </button>
		   …
		  <button type="button" class="btn btn-default">
		     <span class="glyphicon glyphicon-step-forward"></span>
		  </button>
		</div>

##按钮（按钮工具栏）
> 只需要将按钮组"btn-group"按组放在一个大的容器".btn-toolbar"中

设置按钮组的大小  
1. .btn-group-lg
2. .btn-group-sm
3. .btn-group-xs

示例：
	
	<div class="btn-toolbar">
	  <div class="btn-group">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-left"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-center"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-right"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span></button>
	  </div>
	  <div class="btn-group">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-indent-left"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-indent-right"></span></button>
	  </div>
	  <div class="btn-group">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-font"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-bold"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-italic"></span></button>
	  </div>
	  <div class="btn-group">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-text-height"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-text-width"></span></button>
	  </div>
	</div>
	<br />
	<br />
	<div class="btn-toolbar">
	  <div class="btn-group btn-group-lg">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-left"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-center"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-right"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span></button>
	  </div>
	  <div class="btn-group">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-indent-left"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-indent-right"></span></button>
	  </div>
	  <div class="btn-group btn-group-sm">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-font"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-bold"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-italic"></span></button>
	  </div>
	  <div class="btn-group btn-group-xs">
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-text-height"></span></button>
	    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-text-width"></span></button>
	  </div>
	</div>

![icon](img1/btn-group.PNG)

##嵌套分组
> 把制作下拉菜单的“.dropdown” 换成".btn-group"，然后和普通按钮放在一级
		
			<div class="btn-group">
		  <button class="btn btn-default" type="button">首页</button>
		  <!--<button class="btn btn-default" type="button">产品展示</button>-->
		  <div class="btn-group">
		      <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">产品展示
		          <span class="caret"></span>
		      </button>
		      <ul class="dropdown-menu">
		          <li><a>收割机</a></li>
		          <li><a>电动机</a></li>
		          <li><a>拖拉机</a></li>
		          <li><a>电动车</a></li>
		      </ul>
		  </div>
		  <button class="btn btn-default" type="button">案例分析</button>
		  <button class="btn btn-default" type="button">联系我们</button>
		  <div class="btn-group">
		      <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">关于我们<span class="caret"></span></button>
		    <ul class="dropdown-menu">
		    	<li><a href="##">公司简介</a></li>
		    	<li><a href="##">企业文化</a></li>
		    	<li><a href="##">组织结构</a></li>
		    	<li><a href="##">客服服务</a></li>
		    </ul>
		  </div>
		</div>
![icon](img1/group.jpg)
##垂直分组
> 只需要将水平分组的".btn-group"换成".btn-group-vertical"即可。

![icon](img1/vertical.jpg)

## 按钮（等分按钮，自适应按钮组）
> 按钮组里面的每个按钮平分按钮组的宽度，只需要在按钮组“.btn-group”追加一个---“.btn-group-justified”---类名即可。

			<div class="btn-group btn-group-justified"></div>
	
		<div class="btn-wrap">
	    <div class="btn-group btn-group-justified">
	    <a class="btn btn-default" href="#">首页</a>
	    <a class="btn btn-default" href="#">产品展示</a>
	    <a class="btn btn-default" href="#">案例分析</a>
	    <a class="btn btn-default" href="#">联系我们</a>
  </div>
</div>

## 按钮下拉菜单
> 从外观上与下拉菜单效果基本一样。不同的是在普通下拉菜单的基础上封装了按钮的样式效果。（即点击一个按钮会显示隐藏的下拉菜单）

> 其实就是把a元素换成了button元素。唯一不同就是外部容器的".dropdown"换成了"btn-group"。

## 按钮的向下向上三角形
向下

		<span class="caret"></span>
向上
			button元素上添加类名 ---".dropup"
			<span class="caret"></span>

## 标签形tab导航（选项卡导航）
>适用于很多内容分块显示时

> 通过在原导航的基础上添加类名-----".nav-tabs"-------实现
		
		<ul class="nav nav-tabs">
		     <li><a href="##">Home</a></li>
		     <li><a href="##">CSS3</a></li>
		     <li><a href="##">Sass</a></li>
		     <li><a href="##">jQuery</a></li>
		     <li><a href="##">Responsive</a></li>
		</ul>

设置当前状态  “.active”  
设置禁用状态  “.disabled”

## 胶囊型导航
> 通过在原导航的基础上添加类名-----".nav-pills"-------实现

## 垂直堆叠的导航
> 在nav-pills的基础上添加类名-----".nav-stacked"----即可

导航里面添加分隔线

		<li class="nav-divider"></li>

## 自适应导航
> 在.nav-tabs / .nav-pills 后添加类名 .nav-justified即可。
		
		<ul class="nav nav-tabs nav-justified">
		     <li class="active"><a href="##">Home</a></li>
		     <li><a href="##">CSS3</a></li>
		     <li><a href="##">Sass</a></li>
		     <li><a href="##">jQuery</a></li>
		     <li><a href="##">Responsive</a></li>
		</ul>
![icon](img1/nav.PNG)

## 导航加下拉菜单（二级导航）
> 将li元素当作父容器，适用类名".dropdown"来实现下拉菜单


		<ul class="nav nav-tabs nav-justified">
    <li><a>首页</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
            教程
            <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="##">CSS3</a></li>
        <li><a href="##">Sass</a></li>
        <li><a href="##">jQuery</a></li>
        <li><a href="##">Responsive</a></li>
        </ul>
        </li>  
	<li><a>关于我们</a></li>
	</ul>

## 面包屑式导航
> 为ol元素添加类名------".breadcrumb"------
		
		<ol class="breadcrumb">
		  <li><a href="#">首页</a></li>
		  <li><a href="#">我的书</a></li>
		  <li class="active">《图解CSS3》</li>
		</ol>