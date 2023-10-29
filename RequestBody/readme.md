public class RequestBodyData {
    private String clientId;
    private String changeType;
    private List<String> planIds;

    // Constructors, getters, and setters

    public RequestBodyData() {
    }

    public RequestBodyData(String clientId, String changeType, List<String> planIds) {
        this.clientId = clientId;
        this.changeType = changeType;
        this.planIds = planIds;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public List<String> getPlanIds() {
        return planIds;
    }

    public void setPlanIds(List<String> planIds) {
        this.planIds = planIds;
    }
}
