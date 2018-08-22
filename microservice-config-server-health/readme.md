# microservice-config-server-health

Config Server自带了健康状况指示器，暴露的endpoint为
- /health，用于检查配置的仓库是否可用。

- 默认情况下，对于请求的{application} ,默认的{profile}是default,{label}是master

```
➜  ~ curl http://localhost:9999/health
{"status":"UP"}%
```