package net.take8.springboothelloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@EnableWebMvc
// ポートをランダムにする
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class HelloControllerTests {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void getHelloTest() throws Exception {
    // when
    mockMvc.perform(get("/hello"))
        // HTTPステータスコードは正しいか?
        .andExpect(status().isOk())
        // 指定のviewを返すか?
        .andExpect(view().name("hello"))
        // modelに正しい変数を詰められているか?
        .andExpect(model().attribute("hello", "Hello World!"));
  }

}
