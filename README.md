
# 程式開發與提交的方案

## 程式架構
1. admin 
    1. src/main/java/controller/HelloController.java
    1. src/test/java/controller/HelloControllerTest.java
2. core
    1. src/main/java/bean/HelloBean.java
    1. src/test/java/bean/HelloBeanTest.java
3. mapper
    1. src/main/java/mapper/HelloMapper.java
    1. src/test/java/mapper/HelloMapperTest.java
4. sercice
    1. src/main/java/service/HelloService.java
    1. src/test/java/service/HelloServiceTest.java


## 需求單
1. 建立專案 ＆ 建立 Hello 業務
    1. 建立專案
    1. 產生基礎業務架構
    1. 開發 Controller
    1. 開發 Service
    1. 開發 mapper


# Resource
## Sample
https://www.baeldung.com/maven-multi-module

## Build parent project
```sh
mvn archetype:generate -DgroupId=com.hello -DartifactId=parent-project
```

add packaging type to pom
```xml
    # in parent-project.pom
    <packaging>pom</packaging>
```

## Build subproject
```sh
cd parent-project
mvn archetype:generate -DgroupId=com.hello -DartifactId=admin
mvn archetype:generate -DgroupId=com.hello -DartifactId=core
mvn archetype:generate -DgroupId=com.hello -DartifactId=mapper
mvn archetype:generate -DgroupId=com.hello -DartifactId=service
```