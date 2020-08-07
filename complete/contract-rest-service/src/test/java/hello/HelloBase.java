package hello;

import hello.Person;

import org.junit.Before;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractRestServiceApplication.class)
//public abstract class BaseClass {
public abstract class HelloBase {

  @Autowired PersonRestController personRestController;
  //@Autowired WebApplicationContext webApplicationContext;

  @MockBean
  PersonService personService;

  @Before
  public void setup() {

    RestAssuredMockMvc.standaloneSetup(personRestController);
    //RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

    when(personService.findPersonById(1L))
      .thenReturn(new Person(1L, "foo", "bee"));

    when(personService.createPerson())
      .thenReturn(new Person(42L, "Arthur", "Dent"));

    when(personService.updatePerson(42L, new Person(0L, "Zaphod", "Beeblebrox")))
    //when(personService.updatePerson(0L, new Person()))
      .thenReturn(new Person(42L, "Zaphod", "Beeblebrox"));
  }

}