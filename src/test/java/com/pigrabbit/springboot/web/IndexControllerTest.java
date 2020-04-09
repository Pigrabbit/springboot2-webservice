package com.pigrabbit.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadMainPage() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);
        // then
        assertThat(body).contains("Building Web Service with Spring boot");
    }

    @Test
    public void openPostSavingPage() {
        // when
        String body = this.restTemplate.getForObject("/posts/save", String.class);
        // then
        assertThat(body).contains("Save a post");
    }

//    @Test
//    public void openPostUpdatingPage() {
//        // when
//        String body = this.restTemplate.getForObject("/posts/update/{id}", String.class);
//        // then
//        assertThat(body).contains("Update Post");
//    }
}
