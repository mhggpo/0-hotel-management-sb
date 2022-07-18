# 工程简介
纯纯的后端

我也不知道改了什么，净搁这@AutoWired(required=false)了
SpringBoot省掉了配置MVC的部分
数据库配置改到总配置文件（application.yml）中
Mapper扫描需要启动类额外注解
类路径变更
其他没啥变化
SSM工程文件基本可以沿用

# 延伸阅读

## 如何运行

如果想使用docker，请导入mhggpo/hotelmanagement镜像

启动参数参考：

```shell
docker run --name hotel-test ^
--link mysql-test:mysql ^
-p 9090:9090 ^
--env DB_HOST=mysql ^
mhggpo/hotelmanagement
```

以上是windows命令行环境

使用前请先运行mysql容器（上述所示容器名为mysql-test），并手动建立zerohotel库后导入sql文件

设定的默认mysql用户名为root，密码为123456

### 可供修改的环境变量

WEB_PORT=9090 默认网络端口

DB_HOST=localhost 默认数据库地址

DB_USER=root 默认数据库用户名

DB_PASSWORD=123456 默认数据库密码





