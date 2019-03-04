# multipart-issue-example
Minimal Spring Cloud Discovery + Gateway + REST Controller application

# Versions
Spring Cloud version: Finchley.SR2
Spring Boot version: 2.0.6.RELEASE

Creating empty files for testing purposes:

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
