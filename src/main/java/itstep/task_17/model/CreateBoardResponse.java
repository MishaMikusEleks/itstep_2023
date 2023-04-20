package itstep.task_17.model;

import lombok.Data;

@Data
public class CreateBoardResponse {
    private Integer statusCode;
    private TrelloBoard body;
}
