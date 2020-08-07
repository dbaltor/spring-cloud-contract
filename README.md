# Example of Spring Cloud Contract #
<br>
This simple demo aims to show the power of Spring Cloud Contract.
<br>
<br>
<h2>Building the code</h2>
<br>
You can build both service and client using Gradle or Maven. The build process will build first the service and install the generated stubs on your maven local repo.<br>
This is required as the client build process requires them to run tests locally using WireMock.<br>
This approach is known as the <a href="https://microservices.io/patterns/testing/service-component-test.html">Service Component Test pattern</a>.<br>
<p/>
<p/>
<h3>command line:</h3>
<code>./build/gradle.sh</code><br>
or<br>
<code>./build/mvn.sh</code><br>
<p/>
<p/>
<h2>Testing client and service locally:</h2>
<code>java -jar contract-rest-service/build/libs/contract-rest-service-1.0.0.jar</code><br>
<code>java -jar contract-rest-client/build/libs/contract-rest-client-1.0.0.jar</code><br>
<br>
URLs:<br>
---<br>
localhost:8080/message/1<br>
localhost:8080/message/2<br>
localhost:8080/message/3<br>
<p/>
