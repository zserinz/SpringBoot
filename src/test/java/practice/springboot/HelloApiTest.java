package practice.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloApiTest {
    @Test
    void helloApi() {
        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // status code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text-plain
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        Assertions.assertThat(res.getBody()).isEqualTo("hello Spring");
    }
}
