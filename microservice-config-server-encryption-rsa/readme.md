# microservice-config-server-encryption-rsa
## 相关参考
- [keytool](https://blog.csdn.net/zlfing/article/details/77648430)

## Mac 下生成 keystore 文件
```
➜  microservice-config-server-encryption-rsa git:(master) ✗ keytool -genkeypair -alias mytestkey  -keyalg RSA -dname="CN=Web Server,OU=Unit,O=Origanization,L=City,S=State,C=US" -keypass 123456 keystore server.jks -storepass letmein

➜  microservice-config-server-encryption-rsa git:(master) ✗ ls
microservice-config-server-encryption-rsa.iml mvnw.cmd                                      readme.md                                     src
mvnw                                          pom.xml                                       server.jks                                    target
➜  microservice-config-server-encryption-rsa git:(master) ✗ curl http://localhost:9999/encrypt -d mysecret
AQB8rDHNaUqSok6/wLGkGDgN3ZtKnTzhnbN2YHseVgqcjg2mBLem6zrzIcvIQk/FnNRIijINAiuFgRMjIkJHb5Vs83D6oUGgOD6oDixl6kzgUA5h1BnyrEwajJrjlZO3uBVeMFvK+RLH+AZPpjurtZ70Nor4FqMaOXL0bRLKaWQB3JYD40SFiMGzDxbYrQWShf9Ux+tVHiqgEDJI65ANIIKULg+w8oL8pwtkxYsjZFaUIltgtD+2V/k06HjqzVOTZTl5ADHWnT4bJLVgaZh11ln6hA9qJeo0/BPqnrMuHnO9SftTFBbGxa3fWzyd9BvgOK8jES0DQRQQjoAqRGHHgdR+FyjxN4YDurK2xQwRkoYb085mPWKtR+2Z+ZxGp6bbAv8=%      
```


