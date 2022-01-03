package net.take8.springboothelloworld;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
// ポートをランダムにする
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class SpringBootHelloWorldApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  // @Value("${local.server.port}")
  @LocalServerPort
  int port;

  @Test
  public void testHello() {
    String body = this.restTemplate.getForObject("http://localhost:" + port, String.class);
    assertThat(body).isEqualTo("Hello World!");
  }

//  @Test
//  void contextLoads() {
//  }

}
