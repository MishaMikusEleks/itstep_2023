package itstep.task_17.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseTrelloRequest {
    private String key;
    private String token;

    public BaseTrelloRequest(String key, String token) {
        this.key = key;
        this.token = token;
    }
}
