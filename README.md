# multipart-issue-example
Minimal Spring Cloud Discovery + Gateway + REST Controller application showcasing the following issue: https://github.com/spring-cloud/spring-cloud-gateway/issues/872

# Usage

All projects should readily import into IntelliJ or Eclipse. Run *Eureka*, then *Gateway*, then *Controller*.

GET http://localhost:8888/controller/test/ should return 200 OK.

POST http://localhost:8888/controller/upload/ , or

POST http://localhost:8888/controller/uploadtodisk/ 

using one of the files generated through the below utilities will display the issue where the following exception occurs:

`org.springframework.web.multipart.support.MissingServletRequestPartException: Required request part 'file' is not present`

# Versions
<pre>
- Spring Cloud: Finchley.SR2

- Spring Boot: 2.0.6.RELEASE

- Gradle: 5.2.1

- Java: 
java version "1.8.0_202"
Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
Java HotSpot(TM) 64-Bit Server VM (build 25.202-b08, mixed mode)
</pre>

# Creating empty files for testing purposes

## Windows 

<pre>
fsutil file createnew 5M.txt 5242880     # 5MB
fsutil file createnew 100M.txt 104857600 # 100MB
fsutil file createnew 1g.txt 1073741824  # 1G
</pre>
## Linux-based

<pre>
dd if=/dev/zero of=5M.txt bs=5M count=1      # 5MB
dd if=/dev/zero of=100M.txt bs=100M count=1  # 1G
dd if=/dev/zero of=1G.txt bs=1G count=1      # 1G
</pre>
