# Example of Sprinc Cloud Contract #
<br>
This simple demo aims to show the power of Spring Cloud Contract
<br>
<br>
<h2>Building the code</h2>
<br>
You can build both service and client using Gradle or Maven. The build process will build first the service and install the generated stubs on your maven local repo.<br>
This is required as the client build process test the code using those stubs.<br>
<p/>
<p/>
<h2>Testing locally:</h2>
<br>
<code>java -jar contract-rest-service/build/libs/contract-rest-service-1.0.0.jar</code><br>
<code>java -jar contract-rest-client/build/libs/contract-rest-client-1.0.0.jar</code><br>
<p/>
URL:<br>
---<br>
<p/>
localhost:8080/message/1<br>
localhost:8080/message/2<br>
localhost:8080/message/3<br>
<p/>
