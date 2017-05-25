# Json

Json interface for Java 1.7+.<br/>

For questions and support please contact [services@mercadolibre.com](mailto:services@mercadolibre.com)

# Contents

   * [Dependencies](#dependencies)

# Dependencies

You must define the repository resolver

```xml
<repository>
	<id>java-json-mvn-repo</id>
	<url>https://raw.github.com/mercadolibre/java-json/mvn-repo/</url>
	<snapshots>
	    <enabled>true</enabled>
	    <updatePolicy>always</updatePolicy>
	</snapshots>
</repository>
```

And the dependencies themselves

```xml
<dependency>
    <groupId>com.mercadolibre.json</groupId>
    <artifactId>json-core</artifactId>
    <version>0.0.4</version>
</dependency>

<dependency>
    <groupId>com.mercadolibre.json_jackson</groupId>
    <artifactId>json-jackson</artifactId>
    <version>0.0.4</version>
</dependency>
```