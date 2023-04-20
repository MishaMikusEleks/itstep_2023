package itstep.task_17.model;

import lombok.Data;

@Data
public class DeleteRequest extends BaseTrelloRequest{
    private String id;

    public DeleteRequest(String trelloKey, String trelloToken) {
        super(trelloKey,trelloToken);
    }
}
