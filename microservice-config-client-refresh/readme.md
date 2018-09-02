# microservice-config-client-refresh
##1. Start microservice-config-server  
- run 
```
➜  microservice-config-server git:(master) ✗ ./mvnw spring-boot:run
```
- test
```
➜  microservice-config-server git:(master) ✗ curl http://localhost:9999/microservice-foo/dev/master
{"name":"microservice-foo","profiles":["dev"],"label":"master","version":"0870dbd81ead24aadb3157c9180026a07bc295ed","state":null,"propertySources":[{"name":"https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo-dev.properties","source":{"profile":"dev-1.0"}},{"name":"https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo.properties","source":{"profile":"default-1.0"}}]}%
```
##2. Start microservice-config-client-refresh
- run 
```
➜  microservice-config-client-refresh git:(master) ✗ ./mvnw spring-boot:run
```
- test
```
➜  microservice-config-client-refresh git:(master) ✗ curl http://localhost:8081/profile
dev-1.0%     
```
#### 3. Update config repo
```
➜  spring-cloud-config-repo git:(master) ✗ echo 'profile=dev-1.0-change' > microservice-foo-dev.properties
➜  spring-cloud-config-repo git:(master) ✗ git add -p
➜  spring-cloud-config-repo git:(master) ✗ git commit -m "change profile about microservice-foo-dev.properties"
➜  spring-cloud-config-repo git:(master) ✗ git push origin master

```

#### 4. Test current plugin from config repo
```
➜  spring-cloud-config-repo git:(master) curl http://localhost:8081/profile
dev-1.0%
```

#### 5. Refresh plugin
```
➜  spring-cloud-config-repo git:(master) curl -X POST http://localhost:8081/refresh
["config.client.version","profile"]%
```
#### 6. Test current plugin already update
```
➜  spring-cloud-config-repo git:(master) curl http://localhost:8081/profile
dev-0.1-change%
```

