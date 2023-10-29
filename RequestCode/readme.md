import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootApplication
public class YourRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourRestApiApplication.class, args);
    }
}

@RestController
@RequestMapping("/your-api-endpoint")
public class YourController {

    @PostMapping
    public ResponseEntity<String> yourEndpoint(
            @RequestHeader("ROI-User-Name") String userName,
            @RequestHeader("ROI-First-Name") String firstName,
            @RequestHeader("ROI-Last-Name") String lastName,
            @RequestHeader("ROI-Role") String role,
            @RequestHeader("ROI-System") String system,
            @RequestHeader("ROI-User-Id") String userId,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("ROI-Organization-Id") String orgId,
            @RequestHeader("ROI-Organization-Name") String orgName,
            @RequestBody RequestBodyData requestBody) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("ROI-User-Name", userName);
        headers.add("ROI-First-Name", firstName);
        headers.add("ROI-Last-Name", lastName);
        headers.add("ROI-Role", role);
        headers.add("ROI-System", system);
        headers.add("ROI-User-Id", userId);
        headers.add("Authorization", authorization);
        headers.add("ROI-Organization-Id", orgId);
        headers.add("ROI-Organization-Name", orgName);

        // You can access the request body data as part of the requestBody parameter.
        String clientId = requestBody.getClientId();
        String changeType = requestBody.getChangeType();
        String[] planIds = requestBody.getPlanIds();

        // Your API logic here

        // Create a request entity with the headers and request body
        HttpEntity<RequestBodyData> requestEntity = new HttpEntity<>(requestBody, headers);

        // Define the URL of the API you want to call
        String apiUrl = "https://example.com/other-api-endpoint"; // Replace with the actual API URL

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Make the HTTP request to the other API
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

            // You can handle the response from the other API as needed
            if (response.getStatusCode() == HttpStatus.OK) {
                // Success
                String responseMessage = "Your API response goes here";
                return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
            } else {
                // Handle other response statuses as needed
                // Example: return a different response or throw an exception
            }
        } catch (HttpClientErrorException ex) {
            // Handle bad requests or other client errors
            return handleHttpClientErrorException(ex);
        } catch (Exception ex) {
            // Handle other exceptions
            return handleOtherException(ex);
        }
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        // Handle bad requests or other client errors
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String errorResponse = "{\"error\": \"" + ex.getStatusCode() + "\", \"message\": \"" + ex.getResponseBodyAsString() + "\"}";
        return new ResponseEntity<>(errorResponse, headers, ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherException(Exception ex) {
        // Handle other exceptions
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String errorResponse = "{\"error\": \"Internal Server Error\", \"message\": \"" + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
