package tests.api;

import config.EnvConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseAPITest {

    public RequestSpecification requestSpecification;

    @BeforeAll
    public void setUp(){
        requestSpecification = RestAssured.given()
                .baseUri(EnvConfig.getBaseAPIURL())
                .contentType("application/json")
                .accept(ContentType.JSON)
                .header("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgwMjIzNzIsInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNzcwYTgxYzMtMjE3Zi00NjgyLWEzMWUtMmFiY2U3ZjM0ZDFlIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.kIbepw5Jz1zXxWrcSqFeZLU77FrZ3eEAKA41vYsHjTc");
    }
}
