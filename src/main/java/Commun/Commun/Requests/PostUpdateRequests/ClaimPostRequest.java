package Commun.Commun.Requests.PostUpdateRequests;

import lombok.Data;

@Data
public class ClaimPostRequest {

    private boolean isClaimed;
    private Long claimerId;
}
