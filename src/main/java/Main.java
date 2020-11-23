import model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Main {
    static String URL_ALL = "http://91.241.64.178:7081/api/users";
    static String SESSION_ID;

    public static void main(String[] args) {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");


        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(URL_ALL, HttpMethod.GET, entity, String.class);
        headers = response.getHeaders();
        String set_cookie = headers.getFirst(headers.SET_COOKIE);
        System.out.println(set_cookie);




        HttpHeaders headers2 = new HttpHeaders();
        headers2.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers2.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.set("Cookie", set_cookie);
        User user = new User(3L, "James", "Brown", (byte) 20);

        HttpEntity<User> entity2 = new HttpEntity<User>(user, headers2);
        RestTemplate restTemplate2 = new RestTemplate();

        ResponseEntity<String> response2 = restTemplate2.exchange("http://91.241.64.178:7081/api/users", HttpMethod.POST, entity2, String.class);

        System.out.println(response2);

        HttpHeaders headers3 = new HttpHeaders();
        headers3.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers3.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers3.setContentType(MediaType.APPLICATION_JSON);
        headers3.set("Cookie", set_cookie);
        user.setName("Thomas");
        user.setLastName("Shelby");

        HttpEntity<User> entity3 = new HttpEntity<User>(user, headers3);
        RestTemplate restTemplate3 = new RestTemplate();

        ResponseEntity<String> response3 = restTemplate3.exchange("http://91.241.64.178:7081/api/users", HttpMethod.PUT, entity3, String.class);

        System.out.println(response3);

        HttpHeaders headers4 = new HttpHeaders();
        headers4.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers4.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers4.setContentType(MediaType.APPLICATION_JSON);
        headers4.set("Cookie", set_cookie);


        HttpEntity<User> entity4 = new HttpEntity<User>(user, headers4);
        RestTemplate restTemplate4 = new RestTemplate();

        ResponseEntity<String> response4 = restTemplate4.exchange("http://91.241.64.178:7081/api/users/3", HttpMethod.DELETE, entity4, String.class);

        System.out.println(response4);
    }
}

