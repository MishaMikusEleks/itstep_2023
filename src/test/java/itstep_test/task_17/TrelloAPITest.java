package itstep_test.task_17;

import itstep.task_14.AllureListener;
import itstep.task_17.TrelloBO;
import itstep.task_17.model.CreateBoardRequest;
import itstep.task_17.model.CreateBoardResponse;
import itstep.task_17.model.DeleteRequest;
import itstep.task_17.model.TrelloBoard;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@Listeners({AllureListener.class})
public class TrelloAPITest {
    TrelloBO trelloBO=new TrelloBO();
    Properties properties=new Properties();
    String trelloKey;
    String trelloToken;

    @BeforeTest
    void initProperty() throws IOException, URISyntaxException, InterruptedException {
        properties.load(new FileReader("src/main/resources/appliaction.properties"));
         trelloKey= properties.getProperty("trello.key");
         trelloToken= properties.getProperty("trello.token");
         clearOldUserData();
         clearOldBoards();
    }

    private void clearOldUserData() throws IOException, URISyntaxException, InterruptedException {
        String memberId=trelloBO.getMyMemberId(trelloKey,trelloToken);
        trelloBO.deleteAllData(memberId,trelloKey,trelloToken);
    }

    private void clearOldBoards() throws IOException, URISyntaxException, InterruptedException {
        //getAll BoardId
        trelloBO.getAllBoardIds(trelloKey,trelloToken).forEach(id->{
            //loop delete for each
            DeleteRequest del=new DeleteRequest(trelloKey,trelloToken);
            del.setId(id);
            try {
                trelloBO.deleteBoardById(del);
            } catch (IOException | InterruptedException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Test
    void crudApiClientTest() throws IOException, URISyntaxException, InterruptedException {

        //Use your scenario from Task_15.
        //Add Request and Response clases for each unique endpoints.
        //Validate Response Object using your own class comparator.

        String newBoardName= UUID.randomUUID().toString().substring(2,10);

        CreateBoardRequest createBoardRequest=new CreateBoardRequest();
        createBoardRequest.setName(newBoardName);
        createBoardRequest.setKey(trelloKey);
        createBoardRequest.setToken(trelloToken);

        CreateBoardResponse createBoardResponse= trelloBO.createBoard(createBoardRequest);

        CreateBoardResponse expectedCreateBoardResponse=new CreateBoardResponse();
        expectedCreateBoardResponse.setBody(new TrelloBoard());
        expectedCreateBoardResponse.getBody().setName(newBoardName);
        expectedCreateBoardResponse.setStatusCode(200);
        expectedCreateBoardResponse.getBody().setId(createBoardResponse.getBody().getId());
        expectedCreateBoardResponse.getBody().setDesc("");
        expectedCreateBoardResponse.getBody().setClosed(false);

        //DO NOT DO THIS!!!
        expectedCreateBoardResponse.getBody().setIdOrganization(createBoardResponse.getBody().getIdOrganization());
        expectedCreateBoardResponse.getBody().setUrl(createBoardResponse.getBody().getUrl());
        expectedCreateBoardResponse.getBody().setShortUrl(createBoardResponse.getBody().getShortUrl());
        expectedCreateBoardResponse.getBody().setPrefs(createBoardResponse.getBody().getPrefs());
        expectedCreateBoardResponse.getBody().setLabelNames(createBoardResponse.getBody().getLabelNames());
        expectedCreateBoardResponse.getBody().setLimits(createBoardResponse.getBody().getLimits());

        expectedCreateBoardResponse.getBody().setPinned(false);

        Assert.assertEquals(createBoardResponse,expectedCreateBoardResponse);

        expectedCreateBoardResponse.getBody().setPinned(false);

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
