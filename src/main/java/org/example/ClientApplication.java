package org.example;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ClientApplication {

    @Value("${rest.api.url}") // Assuming you have the REST API URL in your application.properties file
    private static String apiUrl;
    
   
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	GreetingCaller greetingCaller = new GreetingCaller("http://localhost:8080");
        
    	//Greeting grt = greetingCaller.callRestServiceSync("Jim");
        Greeting grt = greetingCaller.getGreeting();
    	System.out.println("retrieved Greeting with ID: " + grt.getId() + " and content: " + grt.getContent());
        grt = greetingCaller.getGreeting("Jim");
        System.out.println("retrieved Greeting with ID: " + grt.getId() + " and content: " + grt.getContent());

    }

 //   @Bean
 //   public WebClient webClient() {
 //       return WebClient.create(apiUrl);
 //   }


}
