# Alò!

##Dos Java Startup 

### Introduction
Alò is a Windows batch script utility to deploy and execute command line java tools, rebuilding the environment inside the tool folder.

Alò is also the most common exhortation word in the Arezzo city dialect. It is used in many different contexts, but usually means "Hurry up and do something!"

### Requirements
Alò script need to be work with a Java tool in a folder tree like this:

```
\<root>
 start.bat
 \dist
  <myTool>.jar
  lib.zip
```	
and the Tool.jar should be compiled to be find dependencies in a subfolder called "lib".
You can look at TestJar pom to have the example.

So requirements are:
- internet connection (first time to download JRE)
- Windows OS version 7 or later
- a main jar whose classpath points to lib subfolder
- dependencies stored in a lib.zip archive

### How it works
Given a java tools with a target JRE, it checks if a copy of needed JRE is locally present and download from Azul ftp archive instead.
After the JRE is ready it check if the lib.zip was previously exctracted to the subfolder "lib" into "dist".
Finally it starts the jar tool using the local JRE passing parameters received by command line.

### Usage
1) edit the "CUSTOM" part of the script, to meet your tool requirements
```
set jarName=TestJar-1.0.0.jar
set depsZipName=lib.zip
set depsFolderName=lib
set jreRepo=https://cdn.azul.com/zulu/bin/
set jre=zulu17.62.17-ca-jre17.0.17-win_x64
```

2) open terminal and launch .\start.bat "my argument"
```
starting TestJar-1.0.0.jar
check local jvm...
JRE zulu17.62.17-ca-jre17.0.17-win_x64 not found into C:\dev\GitHub\Alò\jre
download jre from https://cdn.azul.com/zulu/bin/zulu17.62.17-ca-jre17.0.17-win_x64.zip
extracting jre
removing temporary files
openjdk version "17.0.17" 2025-10-21 LTS
OpenJDK Runtime Environment Zulu17.62+17-CA (build 17.0.17+10-LTS)
OpenJDK 64-Bit Server VM Zulu17.62+17-CA (build 17.0.17+10-LTS, mixed mode, sharing)
check dependencies...
extracting dependencies C:\dev\GitHub\Alò\dist\lib.zip
        1 directory spostata/e.
removing temporary folder
2025-11-23 21:08:20 - [INFO] -------------------------------------
2025-11-23 21:08:20 - [INFO]   TestJar DEBUG VERSION
2025-11-23 21:08:20 - [INFO] -------------------------------------
2025-11-23 21:08:20 - [INFO] - operating system name: Windows 11
2025-11-23 21:08:20 - [INFO] - operating system arch: amd64
2025-11-23 21:08:20 - [INFO] - operation System version: 10.0
2025-11-23 21:08:20 - [INFO] - user home: C:\Users\claudio.tortorelli
2025-11-23 21:08:20 - [INFO] - processors available: 16
2025-11-23 21:08:20 - [INFO] - disk size: 486952 mb
2025-11-23 21:08:20 - [INFO] - total ram available: 30461 mb
2025-11-23 21:08:20 - [INFO] - java home: C:\dev\GitHub\Al‗\jre\zulu17.62.17-ca-jre17.0.17-win_x64
2025-11-23 21:08:20 - [INFO] - java version: 17.0.17
2025-11-23 21:08:20 - [INFO] - java temp dir: C:\Users\CLAUDI~1.TOR\AppData\Local\Temp\
Premere un tasto per continuare . . .
```