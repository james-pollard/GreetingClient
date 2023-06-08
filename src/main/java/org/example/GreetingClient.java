package org.example;
import feign.*;
public interface GreetingClient {
    @RequestLine("GET /greeting")
    @Headers({
            "Accept: application/json",
    })
    Greeting getGreeting();
}
