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