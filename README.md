
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
    1. 產生基礎業務架構 & interface & bean
    1. 開發 Controller & controllerTest & 修正 service interface
    1. 開發 Service & serviceTest & 修正 mapper interface
    1. 開發 mapper & DB schema

## 模式 & 規則
1. 一個功能需求同時修改多個 repository
    1. 每個 repository 從主分支建立新分支，分支名包含ticket
    1. 每個 branch 可分割成更小單位進行開發，以 interface 解耦（非必要）
    1. 開發階段有暫存的commit，在 push 之前重構合併(參考 # 合併commit方法)
    1. 若開發帶有單元測試，則單元測試可助於查驗邏輯（非必要）


## TDD開發模式
1. Test-Driven Development
    1. 撰寫單元測試為起點，只開發符合需求的程式
    1. 每個需求獨立撰寫單元測試，方法中每行程式都能執行為目標
    1. 以單元測試降低耦合度(ex: service 的資料由 controller提供，則controller本就該有固定的資料資訊，由真實的系統連動稱為整合測試)
    1. 以Ｍock方式輔助單元測試，減少相依性（例如: service 需依賴 mapper，則正常該預期 mapper 執行正常及執行異常的兩個測試案例）
    1. 延續上題，資料餵入mapper的問題則屬於mapper該測試的
    1. 複雜的邏輯包覆成方法，獨立測試
2. 整合測試
    1. Restful API 可用 postman 撰寫整合測試腳本，驗收api執行過程
    

# 合併commit方法
```
git reset  {commitId} --soft
git add .
git commit -m "taskmessage"
```


# Resource
## Parent-pom project
### Source
https://www.baeldung.com/maven-multi-module

##$ Build parent project
```sh
mvn archetype:generate -DgroupId=com.hello -DartifactId=parent-project
```

add packaging type to pom
```pom.xml
    # in parent-project.pom
    <packaging>pom</packaging>
```

### Build subproject
```sh
cd parent-project
mvn archetype:generate -DgroupId=com.hello -DartifactId=admin
mvn archetype:generate -DgroupId=com.hello -DartifactId=core
mvn archetype:generate -DgroupId=com.hello -DartifactId=mapper
mvn archetype:generate -DgroupId=com.hello -DartifactId=service
```

### Set SpringBoot project
```pom
#In pom


```

### Set mvn run test
```pom
    <build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

### Add test dependencies
```pom
    	<!-- UnitTest dependencies -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-inline</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter</artifactId>
			<scope>test</scope>
		</dependency>

```