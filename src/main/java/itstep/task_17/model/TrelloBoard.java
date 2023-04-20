package itstep.task_17.model;

import java.util.Map;
import lombok.Data;

@Data
public class TrelloBoard {
    private String message;
    private String id;
    private String name;
    private String desc;
    private Object descData;
    private Boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private TrelloBoardPrefs prefs;
    private Map<String, String> labelNames;
    private Map<String, Object> limits;
}
