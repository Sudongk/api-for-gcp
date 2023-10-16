package com.example.apidemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ApiDemoApplicationTests {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
        assertThat(1 + 2).isEqualTo(3);
        assertThat(1 + 3).isEqualTo(4);
    }

    @Test
    void test1() {
        assertThat(true).isTrue();
    }

}
