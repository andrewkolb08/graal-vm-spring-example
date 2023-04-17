# Graal VM Example
_Example for L&L with native image compilation_

## To Compile/Run with Maven
 Build section must be as follows:
 ``` xml
 	<build>
		<plugins>

			<plugin>
				<groupId>org.graalvm.buildtools</groupId>
				<artifactId>native-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<builder>dashaun/builder:tiny</builder>
					</image>
				</configuration>
			</plugin>
		</plugins>
	</build>
 ```
And then execute the command with
``` bash
mvn -Pnative spring-boot:build-image
```

Run it with
```bash
docker run --rm -p 8080:8080 docker.io/library/graal-vm-example:0.0.1-SNAPSHOT
```

## To Compile/Run with GraalVM native-image

Compile with the following
``` bash
mvn -Pnative compile 
```

then, you can convert the created jar to a native executable using the following in the top-level project directory:
``` bash
rm -rf target/native
mkdir target/native
cd target/native
jar -xvf ../graal-vm-example-0.0.1-SNAPSHOT.jar
native-image -H:Name=graal-vm-example  -cp .:BOOT-INF/classes:`find BOOT-INF/lib | tr '\n' ':'`
mv graal-vm-example ../
```

then execute it using the following in the project directory:
```bash
./target/graal-vm-example
```

Get GraalVM tools for Java
Can't (yet) do polyglot programming for Spring Boot app, due to:
https://github.com/oracle/graal/issues/4473