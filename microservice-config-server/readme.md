# microservice-config-server

使用config server 的端点获取配置文件的内容. 端点和配置文件的映射规则如下：
```
/{appliction}/{profile}[{label}]
/{appliction}-{profile}.yml
/{label}/{appliction}-{profile}.yml
/{appliction}-{profile}.properties
/{label}/{appliction}-{profile}.properties
```
```
curl http://localhost:8888/microservice-foo/dev | python -m json.tool
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   407    0   407    0     0    347      0 --:--:--  0:00:01 --:--:--   348
{
    "label": null,
    "name": "microservice-foo",
    "profiles": [
        "dev"
    ],
    "propertySources": [
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo-dev.properties",
            "source": {
                "profile": "dev-1.0"
            }
        },
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo.properties",
            "source": {
                "profile": "default-1.0"
            }
        }
    ],
    "state": null,
    "version": "7a8a8d4b435b6a6459753994c0946d32ceec4c2e"
}
```
```
 curl http://localhost:8888/microservice-foo/dev/master | python -m json.tool
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   411    0   411    0     0    292      0 --:--:--  0:00:01 --:--:--   292
{
    "label": "master",
    "name": "microservice-foo",
    "profiles": [
        "dev"
    ],
    "propertySources": [
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo-dev.properties",
            "source": {
                "profile": "dev-1.0"
            }
        },
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo.properties",
            "source": {
                "profile": "default-1.0"
            }
        }
    ],
    "state": null,
    "version": "7a8a8d4b435b6a6459753994c0946d32ceec4c2e"
}
```
```
curl http://localhost:8888/microservice-foo/dev/config-label-v2.0 | python -m json.tool
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   422    0   422    0     0    372      0 --:--:--  0:00:01 --:--:--   372
{
    "label": "config-label-v2.0",
    "name": "microservice-foo",
    "profiles": [
        "dev"
    ],
    "propertySources": [
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo-dev.properties",
            "source": {
                "profile": "dev-2.0"
            }
        },
        {
            "name": "https://github.com/YingjiaZhang/spring-cloud-config-repo/microservice-foo.properties",
            "source": {
                "profile": "default-2.0"
            }
        }
    ],
    "state": null,
    "version": "2852fea7edc5c4020923514c065ba8ed87704a5f"
}
```
```
curl http://localhost:8888/microservice-foo-dev.properties
profile: dev-1.0%
```
```
curl http://localhost:8888/microservice-foo-dev.yml
profile: dev-1.0%
```

 # microservice-config-server-refresh-bus
 
 ```
 bus:
   trace:
     enabled: true     # 开启cloud bus的跟踪
 ```
 在访问/bus/refresh 端点之后可访问/trace端点查看事件传播的细节
 RemoteApplicationEvent的子类都是总线事件
 
 ```
 curl http://localhost:9999/trace
 
 [
   {
     "timestamp": 1536243808091,
     "info": {
       "method": "GET",
       "path": "/trace",
       "headers": {
         "request": {
           "host": "localhost:9999",
           "user-agent": "curl/7.54.0",
           "accept": "*/*"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/vnd.spring-boot.actuator.v1+json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:23:28 GMT",
           "status": "200"
         }
       },
       "timeTaken": "9"
     }
   },
   {
     "timestamp": 1536243789515,
     "info": {
       "signal": "spring.cloud.bus.ack",
       "event": "RefreshRemoteApplicationEvent",
       "id": "5eeb90b4-1c5c-4362-a4ae-9396a2a8cc6b",
       "origin": "microservice-foo:8083",
       "destination": "**"
     }
   },
   {
     "timestamp": 1536243789088,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:23:09 GMT",
           "status": "200"
         }
       },
       "timeTaken": "9207"
     }
   },
   {
     "timestamp": 1536243788874,
     "info": {
       "signal": "spring.cloud.bus.ack",
       "event": "RefreshRemoteApplicationEvent",
       "id": "5eeb90b4-1c5c-4362-a4ae-9396a2a8cc6b",
       "origin": "microservice-foo:8084",
       "destination": "**"
     }
   },
   {
     "timestamp": 1536243788478,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:23:07 GMT",
           "status": "200"
         }
       },
       "timeTaken": "8625"
     }
   },
   {
     "timestamp": 1536243787524,
     "info": {
       "method": "POST",
       "path": "/bus/refresh",
       "headers": {
         "request": {
           "host": "localhost:9999",
           "user-agent": "curl/7.54.0",
           "accept": "*/*"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "status": "200"
         }
       },
       "timeTaken": "8099"
     }
   },
   {
     "timestamp": 1536243779692,
     "info": {
       "signal": "spring.cloud.bus.sent",
       "type": "RefreshRemoteApplicationEvent",
       "id": "5eeb90b4-1c5c-4362-a4ae-9396a2a8cc6b",
       "origin": "microservice-config-server:9999",
       "destination": "**:**"
     }
   },
   {
     "timestamp": 1536243779691,
     "info": {
       "signal": "spring.cloud.bus.ack",
       "event": "RefreshRemoteApplicationEvent",
       "id": "5eeb90b4-1c5c-4362-a4ae-9396a2a8cc6b",
       "origin": "microservice-config-server:9999",
       "destination": "**"
     }
   },
   {
     "timestamp": 1536243666113,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:21:06 GMT",
           "status": "200"
         }
       },
       "timeTaken": "2253"
     }
   },
   {
     "timestamp": 1536243660553,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:21:00 GMT",
           "status": "200"
         }
       },
       "timeTaken": "3004"
     }
   },
   {
     "timestamp": 1536243604668,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:20:04 GMT",
           "status": "200"
         }
       },
       "timeTaken": "2629"
     }
   },
   {
     "timestamp": 1536243600691,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:20:00 GMT",
           "status": "200"
         }
       },
       "timeTaken": "1403"
     }
   },
   {
     "timestamp": 1536243596111,
     "info": {
       "method": "GET",
       "path": "/microservice-foo/dev/master",
       "headers": {
         "request": {
           "accept": "application/json, application/*+json",
           "user-agent": "Java/1.8.0_131",
           "host": "localhost:9999",
           "connection": "keep-alive"
         },
         "response": {
           "X-Application-Context": "microservice-config-server:9999",
           "Content-Type": "application/json;charset=UTF-8",
           "Transfer-Encoding": "chunked",
           "Date": "Thu, 06 Sep 2018 14:19:56 GMT",
           "status": "200"
         }
       },
       "timeTaken": "1771"
     }
   }
 ]
 ```