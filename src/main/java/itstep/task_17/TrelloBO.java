package itstep.task_17;

import com.fasterxml.jackson.databind.ObjectMapper;
import itstep.task_17.model.CreateBoardRequest;
import itstep.task_17.model.CreateBoardResponse;
import itstep.task_17.model.DeleteRequest;
import itstep.task_17.model.TrelloBoard;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TrelloBO {
    private static final String BASE_TRELLO_URL = "https://api.trello.com/";
    private ObjectMapper objectMapper=new ObjectMapper();
    public CreateBoardResponse createBoard(CreateBoardRequest createBoardRequest) throws IOException, URISyntaxException, InterruptedException {

        HttpRequest httpRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL(BASE_TRELLO_URL+"1/boards/"+
                        "?name="+createBoardRequest.getName()+"&" +
                        "key="+createBoardRequest.getKey()+"&" +
                        "token="+createBoardRequest.getToken()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString(
                        "", StandardCharsets.UTF_8)).build();

        HttpResponse createBoardResponse= HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CreateBoardResponse res=new CreateBoardResponse();
        res.setStatusCode(createBoardResponse.statusCode());
        System.out.println(createBoardResponse.body());
        TrelloBoard createBoardResponseBody=objectMapper.readValue(createBoardResponse.body()+"", TrelloBoard.class);
        res.setBody(createBoardResponseBody);
        return res;
    }

    public List<String> getAllBoardIds(String trelloKey, String trelloToken) throws IOException, URISyntaxException, InterruptedException {
        //GET https://api.trello.com/1/members/me/boards
        HttpRequest httpRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL(BASE_TRELLO_URL+"1/members/me/boards"+
                        "?key="+trelloKey+"&" +
                        "token="+trelloToken).toURI())
                .GET().build();

        HttpResponse<String> createBoardResponse= HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(createBoardResponse.body());

        JSONArray jsonArray=new JSONArray(createBoardResponse.body());

        List<String> list=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            if(!jsonArray.getJSONObject(i).getBoolean("closed")){
            list.add( jsonArray.getJSONObject(i).getString("id"));}
        }
        return list;
    }

    public void deleteBoardById(DeleteRequest del) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL(BASE_TRELLO_URL+"1/boards/"+del.getId()+"?" +
                        "key="+del.getKey()+"&" +
                        "token="+del.getToken()).toURI())
                .DELETE().build();

        HttpResponse createBoardResponse= HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(createBoardResponse);
    }

    public String getMyMemberId(String trelloKey, String trelloToken) throws IOException, URISyntaxException, InterruptedException {
        //GET https://api.trello.com/1/members/me?key=YOUR_API_KEY&token=YOUR_TOKEN
        HttpRequest httpRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL(BASE_TRELLO_URL+"1/members/me"+
                        "?key="+trelloKey+"&" +
                        "token="+trelloToken).toURI())
                .GET().build();

        HttpResponse<String> resp= HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(resp.body()).getString("id");
    }

    public void deleteAllData(String memberId,String trelloKey, String trelloToken) throws IOException, URISyntaxException, InterruptedException {
        //TODO
        //DELETE https://api.trello.com/1/members/[member_id]/all?key=YOUR_API_KEY&token=YOUR_TOKEN
        HttpRequest httpRequest= HttpRequest.newBuilder()
                //.header("accept","application/json")
                .uri(new URL(BASE_TRELLO_URL+"1/members/"+memberId+"/all"+
                        "?key="+trelloKey+"&" +
                        "token="+trelloToken).toURI())
                .DELETE().build();

        HttpResponse<String> resp= HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp);
    }
}
