#Exam-12739-20170106-1
##数据库配置文件db.properties
	数据库配置文件db.properties所在位置：/Exam-12739-20170106-1/src/main/resources/db.properties
	需要做的修改：修改jdbc.username、jdbc.password

##关键文件路径
	1、applicationContext.xml的文件路径：/Exam-12739-20170106-1/src/main/resources/spring/ApplicationContext.xml
	2、spring-mvc.mvc的文件路径：/Exam-12739-20170106-1/src/main/webapp/WEB-INF/spring-mvc.xml

##项目运行步骤
	1、修改db.properties文件，将jdbc.username、jdbc.password修改成自己数据库的用户名、密码。
	2、运行该web项目
	3、服务器部署成功以后，在浏览器中输入"http://localhost:8080/"即可跳转到login.html（登陆界面），输入用户名后点击登陆按钮即可进入列表显示界面。
	4、插入：在列表显示界面上点击"添加记录"按钮，即可跳转到http://localhost:8080/insert.html，从而完成相应的插入操作。
	5、修改：在列表显示界面上点击“修改”链接，即可跳转到http://localhost:8080/edit.html，从而完成相应的修改操作。
	6、删除：在列表显示界面上点击“删除”链接，如果删除成功，则弹出对话框提示删除成功，否则弹出对话框显示删除失败。
	7、查询：在列表显示界面上输入相应查询条件后点击查询按钮，即可完成相应的查询操作。

##web页面路径
	1、登陆界面：http://localhost:8080/
	2、列表显示界面：http://localhost:8080/query.html
	3、编辑界面：http://localhost:8080/edit.html
	4、插入界面：http://localhost:8080/insert.html
	
"# Exam-12739-20170106-1" 
"# Exam-12739-20170106-1" 
