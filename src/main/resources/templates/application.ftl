server:
  port: ${serverPort}
  servlet:
    context-path: /${pathVersion}
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: ${jdbcUrl}
    username: ${jdbcUsername}
    password: ${jdbcPassword}
mybatis-plus:
  global-config:
    configuration:
      # 配置驼峰命名规范
      map-underscore-to-camel-case: true
      # 使用系统默认ibatis输出日志
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  # 读取mapper.xml的路径
  mapper-locations: classpath:mappers/*Mapper.xml
  type-aliases-package: top.smalldai.opensource.entity