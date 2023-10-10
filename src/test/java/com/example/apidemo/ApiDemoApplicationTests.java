package com.example.apidemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiDemoApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertThat(true).isTrue();
    }

}
