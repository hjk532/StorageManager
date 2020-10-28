<h1>松鼠仓库管理系统</h1>
<h3>使用技术：</h3> <br>
 组件框架：Spring、SpringMVC、MyBatis、Redis<br>
 数据管理：MySQL数据库<br>
 网络平台：阿里云ECS服务器 Ubuntu<br>
 前端技术：LayUi框架，JSP，EL，JavaScript<br>
<h3>适用范围：</h3>用于小型超市的库存管理，日志记录，货物流水<br>
<h3>负责模块：</h3>完全个人开发<br>
<h3>模块说明：<h3><br>
<p>config：<h6>存放所有配置文件，通过scanner组件扫描统一管理</h6></p>
<p>module：<h6>通过Mybatis的动态SQL对数据库操作，实现多表查询、批处理、与基本的增删改查</h6></p>
<p>service：<h6>处理出库、出库日志、入库、入库日志及其批量操作，货物类型理操作人员管理、账号管理的业务逻辑</h6></p>
<p>control:<h6>处理所有http请求，返回对应视图路径</h6></p>
<p>interceptor：<h6>解析http请求，实现HandlerInterceptor接口将验证合格的请求赋给对应权限，交给前端控制器进一步处理， 不合格请求转至开放页面</h6></p>
<p>exception：<h6>通过实现HandlerExceptionResolver接口处理服务器的自定义异常和未知错误</h6></p>

