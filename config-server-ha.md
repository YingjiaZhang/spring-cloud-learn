# config-server-ha

> config server 的高可用依赖于 Git 仓库的高可用和消息队列(eg:kafka，rabbitmq)的高可用

## Git 仓库的高可用

- 第三方Git仓库(已实现高可用): github, gitee, gitlab, etc.（参考指定Git仓库官网文档进行搭建）
- 自建Git仓库管理系统:需要自建Git仓库的高可用.

##消息队列的高可用（参考指定消息队列官网文档进行搭建）

##Config Server自身高可用
- 使用负载均衡器
- 将config server注册到服务发现组件上
