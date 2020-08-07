package hello;

import org.assertj.core.api.BDDAssertions;
//import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
//import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@AutoConfigureStubRunner(
		ids = "com.example:contract-rest-service:1.0.0:stubs:8000",
		//ids = "com.example:contract-rest-service",
		stubsMode = StubRunnerProperties.StubsMode.LOCAL,
		consumerName = "personServiceConsumer"
)
public class ContractRestClientApplicationTest {

	//private @StubRunnerPort("contract-rest-service") int port;

	@LocalServerPort
	private int port;

	@Autowired
	private MessageRestController messageRestController;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test 
	public void contextLoads() {
	}

	@Test
	public void shoudlGetPersonFromServiceContract() {
		// given:
		var personId = 1;
		// when:
		ResponseEntity<String> personResponseEntity = restTemplate.getForEntity(
			"http://localhost:" + port + "/message/{personId}", 
			String.class, 
			personId);	
		// then:
		BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
		
		/*
		// given:
		RestTemplate restTemplate = new RestTemplate();
		// when:
		Responsentity<Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/persons/1", Person.class);
		// then:
		BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(1l);
		BDDAssertions.then(personResponseEntity.getBody().getName()).isEqualTo("foo");
		BDDAssertions.then(personResponseEntity.getBody().getSurname()).isEqualTo("bee");
		*/
	}
}
