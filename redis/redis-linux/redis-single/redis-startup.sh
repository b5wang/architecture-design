Last login: Fri Mar  1 11:59:26 on ttys001
wangbo584@wangbo584 ~ % cksum
^C
wangbo584@wangbo584 ~ % 
wangbo584@wangbo584 ~ % 
wangbo584@wangbo584 ~ % 
wangbo584@wangbo584 ~ % cd Workspace/projects 
wangbo584@wangbo584 projects % ls -l
total 0
drwxr-xr-x  7 wangbo584  staff  224 Feb 20  2023 Excercises
drwxr-xr-x  5 wangbo584  staff  160 Nov 29  2022 GitHub
wangbo584@wangbo584 projects % cd GitHub 
wangbo584@wangbo584 GitHub % ls -l
total 0
drwxr-xr-x  10 wangbo584  staff  320 Mar  1 11:20 b5wang
drwxr-xr-x   6 wangbo584  staff  192 Jan 12  2023 others
wangbo584@wangbo584 GitHub % cd b5wang 
wangbo584@wangbo584 b5wang % ls -l
total 0
drwxr-xr-x   7 wangbo584  staff  224 Sep 18 15:21 JavaFamily
drwxr-xr-x  19 wangbo584  staff  608 Jan  3 11:50 architecture-design
drwxr-xr-x  17 wangbo584  staff  544 Jan 26  2023 cloudlab
drwxr-xr-x  19 wangbo584  staff  608 Jan 17 10:54 datax-web
drwxr-xr-x  16 wangbo584  staff  512 Jan 17 10:54 easy-bank
drwxr-xr-x   8 wangbo584  staff  256 Jan 17 10:54 javabasics
drwxr-xr-x  28 wangbo584  staff  896 Mar  1 11:20 spring-security-samples
wangbo584@wangbo584 b5wang % cd architecture-design 
wangbo584@wangbo584 architecture-design % ls -l
total 0
drwxr-xr-x  5 wangbo584  staff  160 Feb  5  2023 ELK
drwxr-xr-x  4 wangbo584  staff  128 Feb 10  2023 docker
drwxr-xr-x  7 wangbo584  staff  224 Feb 22  2023 document
drwxr-xr-x  4 wangbo584  staff  128 Feb 10  2023 kafka
drwxr-xr-x  3 wangbo584  staff   96 Sep 18 15:17 linux-os
drwxr-xr-x  4 wangbo584  staff  128 Jan  3 12:23 messaging
drwxr-xr-x  4 wangbo584  staff  128 Mar 22  2023 microservice
drwxr-xr-x  5 wangbo584  staff  160 Jan  1 16:38 minikube
drwxr-xr-x  9 wangbo584  staff  288 Sep 18 15:17 mysql
drwxr-xr-x  2 wangbo584  staff   64 Feb  2  2023 nginx
drwxr-xr-x  8 wangbo584  staff  256 Sep 11 09:24 redis
drwxr-xr-x  6 wangbo584  staff  192 Mar  1 14:40 springboot
drwxr-xr-x  3 wangbo584  staff   96 Aug  1  2023 win-wls2
drwxr-xr-x  4 wangbo584  staff  128 Feb 10  2023 zookeeper
wangbo584@wangbo584 architecture-design % cd springboot 
wangbo584@wangbo584 springboot % ls -l
total 0
drwxr-xr-x  6 wangbo584  staff  192 Mar  1 16:04 restful-basicauth
drwxr-xr-x  6 wangbo584  staff  192 Mar  3 11:02 webapp-basicauth
drwxr-xr-x  9 wangbo584  staff  288 Nov  7 09:50 webappauth
wangbo584@wangbo584 springboot % cd webapp-basicauth 
wangbo584@wangbo584 webapp-basicauth % ls -l
total 8
-rw-r--r--@ 1 wangbo584  staff  1740 Mar  1 16:19 pom.xml
drwxr-xr-x  5 wangbo584  staff   160 Feb 29 09:12 src
drwxr-xr-x@ 4 wangbo584  staff   128 Mar  1 16:17 target
wangbo584@wangbo584 webapp-basicauth % mvn clean install -Dmmaven.test.skip=true
[INFO] Scanning for projects...
[INFO] 
[INFO] -----< com.b5wang.architect.springboot.security:webapp-basicauth >------
[INFO] Building webapp-basicauth 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ webapp-basicauth ---
[INFO] Deleting /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ webapp-basicauth ---
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ webapp-basicauth ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 2 source files with javac [debug release 17] to target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:testResources (default-testResources) @ webapp-basicauth ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:testCompile (default-testCompile) @ webapp-basicauth ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] 
[INFO] --- maven-surefire-plugin:3.1.2:test (default-test) @ webapp-basicauth ---
[INFO] 
[INFO] --- maven-jar-plugin:3.3.0:jar (default-jar) @ webapp-basicauth ---
[INFO] Building jar: /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.2.3:repackage (repackage) @ webapp-basicauth ---
[INFO] Replacing main artifact /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar.original
[INFO] 
[INFO] --- maven-install-plugin:3.1.1:install (default-install) @ webapp-basicauth ---
[INFO] Installing /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/pom.xml to /Users/wangbo584/.m2/repository/com/b5wang/architect/springboot/security/webapp-basicauth/0.0.1-SNAPSHOT/webapp-basicauth-0.0.1-SNAPSHOT.pom
[INFO] Installing /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar to /Users/wangbo584/.m2/repository/com/b5wang/architect/springboot/security/webapp-basicauth/0.0.1-SNAPSHOT/webapp-basicauth-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.239 s
[INFO] Finished at: 2024-03-05T09:30:43+08:00
[INFO] ------------------------------------------------------------------------
wangbo584@wangbo584 webapp-basicauth % cd target 
wangbo584@wangbo584 target % ls -l
total 51760
drwxr-xr-x  4 wangbo584  staff       128 Mar  5 09:30 classes
drwxr-xr-x  3 wangbo584  staff        96 Mar  5 09:30 generated-sources
drwxr-xr-x  3 wangbo584  staff        96 Mar  5 09:30 generated-test-sources
drwxr-xr-x  3 wangbo584  staff        96 Mar  5 09:30 maven-archiver
drwxr-xr-x  3 wangbo584  staff        96 Mar  5 09:30 maven-status
drwxr-xr-x  2 wangbo584  staff        64 Mar  5 09:30 test-classes
-rw-r--r--  1 wangbo584  staff  26492596 Mar  5 09:30 webapp-basicauth.jar
-rw-r--r--  1 wangbo584  staff      4996 Mar  5 09:30 webapp-basicauth.jar.original
wangbo584@wangbo584 target % cksum webapp-basicauth.jar
172928650 26492596 webapp-basicauth.jar
wangbo584@wangbo584 target % cd ..
wangbo584@wangbo584 webapp-basicauth % mvn clean install -Dmmaven.test.skip=true
[INFO] Scanning for projects...
[INFO] 
[INFO] -----< com.b5wang.architect.springboot.security:webapp-basicauth >------
[INFO] Building webapp-basicauth 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ webapp-basicauth ---
[INFO] Deleting /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ webapp-basicauth ---
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ webapp-basicauth ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 2 source files with javac [debug release 17] to target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:testResources (default-testResources) @ webapp-basicauth ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:testCompile (default-testCompile) @ webapp-basicauth ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] 
[INFO] --- maven-surefire-plugin:3.1.2:test (default-test) @ webapp-basicauth ---
[INFO] 
[INFO] --- maven-jar-plugin:3.3.0:jar (default-jar) @ webapp-basicauth ---
[INFO] Building jar: /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.2.3:repackage (repackage) @ webapp-basicauth ---
[INFO] Replacing main artifact /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar.original
[INFO] 
[INFO] --- maven-install-plugin:3.1.1:install (default-install) @ webapp-basicauth ---
[INFO] Installing /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/pom.xml to /Users/wangbo584/.m2/repository/com/b5wang/architect/springboot/security/webapp-basicauth/0.0.1-SNAPSHOT/webapp-basicauth-0.0.1-SNAPSHOT.pom
[INFO] Installing /Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/springboot/webapp-basicauth/target/webapp-basicauth.jar to /Users/wangbo584/.m2/repository/com/b5wang/architect/springboot/security/webapp-basicauth/0.0.1-SNAPSHOT/webapp-basicauth-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.653 s
[INFO] Finished at: 2024-03-05T09:33:35+08:00
[INFO] ------------------------------------------------------------------------
wangbo584@wangbo584 webapp-basicauth % cd target 
wangbo584@wangbo584 target % cksum webapp-basicauth.jar               
816228792 26492596 webapp-basicauth.jar
wangbo584@wangbo584 target % jcmd
90785 com.intellij.idea.Main
67747 org.jetbrains.jps.cmdline.Launcher /Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/jps-builders.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/jps-builders-6.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/jps-javac-extension.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/util-8.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/util_rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/platform-loader.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/annotations.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/protobuf.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/jps-model.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/javac2.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/forms_rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/util.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/aether-dependency-resolver.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/java/lib/maven-resolver-connector-basi
13439 jdk.jcmd/sun.tools.jcmd.JCmd
wangbo584@wangbo584 target % jcmd GC.heap_info
Could not find any processes matching : 'GC.heap_info'
wangbo584@wangbo584 target % cd ..
wangbo584@wangbo584 webapp-basicauth % cd ~/Workspace/applications/       
wangbo584@wangbo584 applications % ls -l
total 0
drwxr-xr-x  16 wangbo584  staff  512 Aug 22  2023 00_installers
drwxr-xr-x@ 12 wangbo584  staff  384 Apr 17  2023 datax-v3.0-202303
drwxr-xr-x@  7 wangbo584  staff  224 Jul 10  2023 datax-web-2.1.2
drwxr-xr-x   4 wangbo584  staff  128 Nov  4  2022 eureka-1.9.13
drwxr-xr-x@ 16 wangbo584  staff  512 Feb 12  2023 filebeat-8.6.1
drwxr-xr-x@ 21 wangbo584  staff  672 Feb 12  2023 logstash-8.6.1
drwxr-xr-x   6 wangbo584  staff  192 Nov  4  2022 mock-service
drwxr-xr-x  15 wangbo584  staff  480 Jul 21  2022 mongodb-4.4.15
drwxr-xr-x   5 wangbo584  staff  160 Sep  4  2023 mysql
drwxr-xr-x   8 wangbo584  staff  256 Feb 19 14:02 rabbitmq
drwxr-xr-x   2 wangbo584  staff   64 Aug 22  2023 redis-sentinal-cluster
drwxr-xr-x   8 wangbo584  staff  256 Aug 22  2023 redis-stack-server-6.2.6
drwxr-xr-x@ 16 wangbo584  staff  512 Oct  3  2022 tomcat-8.5.82
drwxr-xr-x  17 wangbo584  staff  544 Oct  8  2022 tomcat-9.0.65
drwxr-xr-x  12 wangbo584  staff  384 Jul 14  2022 zookeeper-3.7.1
wangbo584@wangbo584 applications % cd redis-stack-server-6.2.6 
wangbo584@wangbo584 redis-stack-server-6.2.6 % ls -l
total 0
drwxr-xr-x@ 11 wangbo584  staff  352 Sep 14  2023 bin
drwxr-xr-x   5 wangbo584  staff  160 Sep 18 18:02 data
drwxr-xr-x@  7 wangbo584  staff  224 Sep 14  2023 etc
drwxr-xr-x@  7 wangbo584  staff  224 Jul 16  2023 lib
drwxr-xr-x@  4 wangbo584  staff  128 Jul 16  2023 share
wangbo584@wangbo584 redis-stack-server-6.2.6 % cd bin 
wangbo584@wangbo584 bin % ls -l
\total 68952
-rwxr-xr-x@ 1 wangbo584  staff  4906528 Jul 16  2023 redis-benchmark
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-check-aof
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-check-rdb
-rwxr-xr-x@ 1 wangbo584  staff  4839840 Jul 16  2023 redis-cli
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-sentinel
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-server
-rwxr-xr-x@ 1 wangbo584  staff     1864 Jul 16  2023 redis-stack-server
-rwxr-xr-x@ 1 wangbo584  staff      175 Aug 22  2023 startRedisServer.sh
-rw-r--r--  1 wangbo584  staff      122 Sep 14  2023 stopRedisServer.sh
wangbo584@wangbo584 bin % ./redis-server 
77266:C 14 Mar 2024 11:50:35.076 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
77266:C 14 Mar 2024 11:50:35.076 # Redis version=6.2.13, bits=64, commit=24c0bf5c, modified=0, pid=77266, just started
77266:C 14 Mar 2024 11:50:35.076 # Warning: no config file specified, using the default config. In order to specify a config file use ./redis-server /path/to/redis.conf
77266:M 14 Mar 2024 11:50:35.077 * Increased maximum number of open files to 10032 (it was originally set to 256).
77266:M 14 Mar 2024 11:50:35.077 * monotonic clock: POSIX clock_gettime
                _._                                                  
           _.-``__ ''-._                                             
      _.-``    `.  `_.  ''-._           Redis 6.2.13 (24c0bf5c/0) 64 bit
  .-`` .-```.  ```\/    _.,_ ''-._                                  
 (    '      ,       .-`  | `,    )     Running in standalone mode
 |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
 |    `-._   `._    /     _.-'    |     PID: 77266
  `-._    `-._  `-./  _.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |           https://redis.io       
  `-._    `-._`-.__.-'_.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |                                  
  `-._    `-._`-.__.-'_.-'    _.-'                                   
      `-._    `-.__.-'    _.-'                                       
          `-._        _.-'                                           
              `-.__.-'                                               

77266:M 14 Mar 2024 11:50:35.079 # Server initialized
77266:M 14 Mar 2024 11:50:35.079 * Ready to accept connections
^C77266:signal-handler (1710388258) Received SIGINT scheduling shutdown...
77266:M 14 Mar 2024 11:50:58.045 # User requested shutdown...
77266:M 14 Mar 2024 11:50:58.045 * Saving the final RDB snapshot before exiting.
77266:M 14 Mar 2024 11:50:58.046 * DB saved on disk
77266:M 14 Mar 2024 11:50:58.047 # Redis is now ready to exit, bye bye...
wangbo584@wangbo584 bin % 
wangbo584@wangbo584 bin % 
wangbo584@wangbo584 bin % ls -l
total 68960
-rw-r--r--  1 wangbo584  staff       93 Mar 14 11:50 dump.rdb
-rwxr-xr-x@ 1 wangbo584  staff  4906528 Jul 16  2023 redis-benchmark
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-check-aof
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-check-rdb
-rwxr-xr-x@ 1 wangbo584  staff  4839840 Jul 16  2023 redis-cli
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-sentinel
-rwxr-xr-x@ 1 wangbo584  staff  6382368 Jul 16  2023 redis-server
-rwxr-xr-x@ 1 wangbo584  staff     1864 Jul 16  2023 redis-stack-server
-rwxr-xr-x@ 1 wangbo584  staff      175 Aug 22  2023 startRedisServer.sh
-rw-r--r--  1 wangbo584  staff      122 Sep 14  2023 stopRedisServer.sh
wangbo584@wangbo584 bin % cat startRedisServer.sh 
#!/bin/bash

/Users/wangbo584/Workspace/applications/redis-stack-server-6.2.6/bin/redis-server /Users/wangbo584/Workspace/applications/redis-stack-server-6.2.6/etc/redis.conf
wangbo584@wangbo584 bin % vim startRedisServer.sh 

#!/bin/bash

/Users/wangbo584/Workspace/applications/redis-stack-server-6.2.6/bin/redis-server /Users/wangbo584/Workspace/applications/redis-stack-server-6.2.6/etc/redis.conf
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
~                                                                                                                                                                                                                   
"startRedisServer.sh" 3L, 175B
