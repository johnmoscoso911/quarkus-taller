package org.x;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class PersonControllerTest {

    @Test
    public void findByName() {
        given()
                .when()
                .get("/persons/a")
                .then()
                .statusCode(200)
                .body(containsString("\"first_name\""));

    }
}
