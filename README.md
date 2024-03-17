# CS544-EA project

# Running the project

First get the common-base-module zip:

https://dev.azure.com/comprodev/CS544/_git/common-base-module

After unzipping, comment out the lines in pom.xml:

```
<!--	<repositories>-->
<!--		<repository>-->
<!--			<id>comprodev</id>-->
<!--			<url>https://pkgs.dev.azure.com/comprodev/_packaging/comprodev/maven/v1</url>-->
<!--			<releases>-->
<!--				<enabled>true</enabled>-->
<!--			</releases>-->
<!--			<snapshots>-->
<!--				<enabled>true</enabled>-->
<!--			</snapshots>-->
<!--		</repository>-->
<!--	</repositories>-->

<!--	<distributionManagement>-->
<!--		<repository>-->
<!--			<id>comprodev</id>-->
<!--			<url>https://pkgs.dev.azure.com/comprodev/_packaging/comprodev/maven/v1</url>-->
<!--			<releases>-->
<!--				<enabled>true</enabled>-->
<!--			</releases>-->
<!--			<snapshots>-->
<!--				<enabled>true</enabled>-->
<!--			</snapshots>-->
<!--		</repository>-->
<!--	</distributionManagement>-->
```

Then, mvn install for the project to install to the maven repository.

Then mvn install ea-project.

---
Add this to your intellij run configuration.

```
--add-opens java.base/java.lang=ALL-UNNAMED
```