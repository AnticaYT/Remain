<p align="center">
  This library is used and taught by:
  <a href="https://www.spigotcourse.org/?utm_source=github&utm_medium=github">
    <img src="https://i.imgur.com/Xr0p2g3.png" />
  </a>
</p>

---

# Remain

> NOTICE: Requires 'api-version: 1.13' set in your plugin.yml!

## Usage
This library allows you to develop plugin using the latest Minecraft API while maintaining backward compatibility down to Minecraft 1.7.10.

## Installation
We use Maven to compile it. See below for a step-by-step tutorial. If you don't use a version management system that supports adding the library to your plugin automatically, you can always download the repository as a zip and place the packages it into your plugin's source folder. This is however not recommended and please rename the package names to avoid conflicts.

0. Set the following in your plugin.yml file:
```yaml
    api-version: 1.13
```

1. Place this to your repositories:

```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
```

2. Place this to your dependencies:

```xml
<dependency>
	<groupId>com.github.kangarko</groupId>
	<artifactId>Remain</artifactId>
	<version>2.1.0</version> <!-- change to the latest version -->
	<scope>compile</scope>
</dependency>
```

3. Make sure that the library shades into your final .jar when you compile your plugin. Here is an example of a shade plugin that will do it for you:

**IF YOU ALREADY HAVE A SHADE PLUGIN, ONLY USE THE RELOCATION SECTION FROM BELOW.**

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-shade-plugin</artifactId>
	<version>3.1.1</version>
	<executions>
		<execution>
			<phase>package</phase>
			<goals>
				<goal>shade</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<createDependencyReducedPom>false</createDependencyReducedPom>
		<!-- If you already use a shade plugin only use the following code and paste it into it -->
		<relocations>
			<relocation>
				<pattern>org.mineacademy.remain</pattern>
				<shadedPattern>you.yourplugin.remain</shadedPattern>
			</relocation>
		</relocations>
	</configuration>
</plugin>
```

Copyright (C) 2019. All Rights Reserved. Commercial and non-commercial use allowed as long as you provide a clear reference for the original author.  
