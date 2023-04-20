package itstep.task_17.model;

import lombok.Data;

@Data
public class CreateBoardRequest extends BaseTrelloRequest{
    private String name;
}
