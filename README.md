## SpringBoot Demo

这是一个基于Spring Boot构建的示例项目，包含常见的项目结构划分，如配置管理，控制层，服务层，数据访问层

### 项目结构

```
springboot-demo/
├── src
│   ├── main
│   │   └── java
│   │      └── org
│   │          ├── example
│   │          │    ├── config			#配置类（安全配置，Springdoc配置）
│   │          │    ├── controller		#控制层（REST接口）
│   │          │    ├── mapper			#Mybatis的映射接口
│   │          │    ├── pojo			#实体类
│   │          │    ├── service			#业务逻辑层
│   │          │    │   ├── impl
│   │          └── SpringBooteDemoApplication.java		#项目入口类
```

### 技术栈

| 组件            | 版本   |
| --------------- | ------ |
| JDK             | 17     |
| Spring Boot     | 3.1.5  |
| Spring Security | 3.1.5  |
| SpringDoc       | 2.2.0  |
| MyBatis Plus    | 3.5.4  |
| MySQL           | 8.0.33 |

### 接口文档

本项目集成SpringDoc OpenAPI，启动后访问：

```
http://localhost:8081/swagger-ui/index.html
```

