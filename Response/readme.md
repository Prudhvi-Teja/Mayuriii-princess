import java.util.List;

public class YourApiResponse {
    private String offerId;
    private String message;
    private MessageDetails messageDetails;
    private List<String> validationErrors;

    // Constructors, getters, and setters

    public YourApiResponse() {
    }

    public YourApiResponse(String offerId, String message, MessageDetails messageDetails, List<String> validationErrors) {
        this.offerId = offerId;
        this.message = message;
        this.messageDetails = messageDetails;
        this.validationErrors = validationErrors;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDetails getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(MessageDetails messageDetails) {
        this.messageDetails = messageDetails;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}






















//////////////////////////////////////            Message Details 


public class MessageDetails {
    private List<String> planChangeTypeIds;
    private String validationErrors;
    private String message;

    // Constructors, getters, and setters

    public MessageDetails() {
    }

    public MessageDetails(List<String> planChangeTypeIds, String validationErrors, String message) {
        this.planChangeTypeIds = planChangeTypeIds;
        this.validationErrors = validationErrors;
        this.message = message;
    }

    public List<String> getPlanChangeTypeIds() {
        return planChangeTypeIds;
    }

    public void setPlanChangeTypeIds(List<String> planChangeTypeIds) {
        this.planChangeTypeIds = planChangeTypeIds;
    }

    public String getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(String validationErrors) {
        this.validationErrors = validationErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
