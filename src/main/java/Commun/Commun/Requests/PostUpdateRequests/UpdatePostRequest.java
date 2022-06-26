package Commun.Commun.Requests.PostUpdateRequests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePostRequest {

    private String title;
    private String request;
    private LocalDateTime deadline;
    private String location;
    private int reward;

}
