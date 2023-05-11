package itstep_test.task_16;

import itstep.task_14.AllureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Listeners({AllureListener.class})
public class TrelloAPITest {

    Properties properties=new Properties();
    String trelloKey;
    String trelloToken;

    @BeforeTest
    void initProperty() throws IOException {
        properties.load(new FileReader(new File("src/main/resources/appliaction.properties")));
         trelloKey= properties.getProperty("trello.key");
         trelloToken= properties.getProperty("trello.token");
    }

    @Test
    void crudRestAssuredTest(){

        //General task
        //Make restAssured TC using scenario from Task_15.

        String newBoardName= UUID.randomUUID().toString().substring(2,10);

        //Accept: application/json
        //create
        String boardId=given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when().post("https://api.trello.com/1/boards/" +
                "?name="+newBoardName+"&" +
                "key="+trelloKey+"&" +
                "token="+trelloToken).then()
                .assertThat().statusCode(200)
                .and().assertThat()
                .body("name",equalTo(newBoardName))
                .extract().jsonPath().getString("id");

        //read
        given()
               // .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .get("https://api.trello.com/1/boards/"+boardId+"?" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken).then()
                .assertThat().statusCode(200)
                .and().assertThat()
                .body("name",equalTo(newBoardName));


        //update
        String updatedBoardName=UUID.randomUUID().toString().substring(2,10);
        given()
                // .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .put("https://api.trello.com/1/boards/"+boardId+"?" +
                        "name="+updatedBoardName+"&" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken).then()
                .assertThat().statusCode(200)
                .and().assertThat()
                .body("name",equalTo(updatedBoardName));

        //delete
        given()
                // .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .delete("https://api.trello.com/1/boards/"+boardId+"?" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken).then()
                .assertThat().statusCode(200)
                .and().assertThat()
                .body("_value",equalTo(null));

    }

    @Test
    void crudApiClientTest() throws IOException, URISyntaxException, InterruptedException {

        //General task
        //Make restAssured TC using scenario from Task_15.
        //The same using any another API client.

        String newBoardName= UUID.randomUUID().toString().substring(2,10);

        HttpRequest createBoardRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL("https://api.trello.com/1/boards/"+
                        "?name="+newBoardName+"&" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken).toURI())
                .POST(java.net.http.HttpRequest.BodyPublishers.ofString(
                        "", StandardCharsets.UTF_8)).build();

        System.out.println(createBoardRequest.uri());
        HttpResponse createBoardResponse= HttpClient.newBuilder().build().send(createBoardRequest, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(createBoardResponse.statusCode(),200);


        //Accept: application/json
        //create
//        String boardId=given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when().post("https://api.trello.com/1/boards/" +
//                        "?name="+newBoardName+"&" +
//                        "key="+trelloKey+"&" +
//                        "token="+trelloToken).then()
//                .assertThat().statusCode(200)
//                .and().assertThat()
//                .body("name",equalTo(newBoardName))
//                .extract().jsonPath().getString("id");
//
//        //read
//        given()
//                // .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .get("https://api.trello.com/1/boards/"+boardId+"?" +
//                        "key="+trelloKey+"&" +
//                        "token="+trelloToken).then()
//                .assertThat().statusCode(200)
//                .and().assertThat()
//                .body("name",equalTo(newBoardName));
//
//
//        //update
//        String updatedBoardName=UUID.randomUUID().toString().substring(2,10);
//        given()
//                // .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .put("https://api.trello.com/1/boards/"+boardId+"?" +
//                        "name="+updatedBoardName+"&" +
//                        "key="+trelloKey+"&" +
//                        "token="+trelloToken).then()
//                .assertThat().statusCode(200)
//                .and().assertThat()
//                .body("name",equalTo(updatedBoardName));
//
//        //delete
//        given()
//                // .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .delete("https://api.trello.com/1/boards/"+boardId+"?" +
//                        "key="+trelloKey+"&" +
//                        "token="+trelloToken).then()
//                .assertThat().statusCode(200)
//                .and().assertThat()
//                .body("_value",equalTo(null));

    }


}
