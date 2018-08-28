# microservice-config-server-encryption

Config server 的加密解密功能依赖于 JCE（java Cryptography Extension）

- [JCE Download](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)
- [JCE install](https://blog.csdn.net/arctan90/article/details/68066660
)
- [JCE 安全](https://blog.csdn.net/fishmai/article/details/52398532)

- [Encryption Issue: No Key was installed for encryption service](https://github.com/spring-cloud/spring-cloud-config/issues/800)

## start
####Replace jar file
```
/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/security
```
####Encryption and Decryption endpoint
```
curl $CONFIG_SERVER_URL/encrypt <need to plaintext>
curl $CONFIG_SERVER_URL/decrypt <need to ciphertext>
```
#### Test
```
➜  microservice-config-server-encryption git:(master) ✗ curl http://localhost:9999/encrypt -d pass123
842d21cb3b28d1bc58678cbf19f44fb43011fc5b7432542164187c77c4c1d45e% 

➜  microservice-config-server-encryption git:(master) ✗ curl http://localhost:9999/decrypt -d 842d21cb3b28d1bc58678cbf19f44fb43011fc5b7432542164187c77c4c1d45e 
pass123%        
```

#### issue
配置了spring.cloud.config.server.encrypt.enabled=true但是并不能直接返回yml文件中的解密结果，但是直接调用解密接口可以实现解密结果
```
➜  microservice-config-server-encryption git:(master) ✗ curl http://localhost:9999/encryption-default.yml
spring:
  datasource:
    password: '{chiper}842d21cb3b28d1bc58678cbf19f44fb43011fc5b7432542164187c77c4c1d45e'
    username: dbuser
```
```
➜  microservice-config-server-encryption git:(master) ✗ curl http://localhost:9999/decrypt -d 842d21cb3b28d1bc58678cbf19f44fb43011fc5b7432542164187c77c4c1d45e
pass123%     
```



