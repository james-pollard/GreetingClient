package org.example;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

//import com.fasterxml.jackson.databind.ObjectMapper;
public class GreetingCaller {
	private String apiURL = null;
	private FeignClient feignClient;
    @Bean
    public WebClient webClient() {
        return WebClient.create(apiURL);
    }
	
    public GreetingCaller(String apiURL) {

        this.apiURL = apiURL;
        feignClient = new FeignClient(apiURL);

    }
    public static void printgreeting(Greeting grt) {
    	System.out.println(">>>>>>" + grt.getId() + "-- " + grt.getContent());
    }
    
    
//    public Greeting callRestServiceSync(String nm) throws InterruptedException, ExecutionException {
//    	WebClient webClient = webClient();
//    	Greeting grt;
//    	grt = webClient.get()
//    	   .uri("/greeting" + "?name=" + nm)
//    	   .retrieve()
//    	   .bodyToMono(Greeting.class)
//    	   .block();
//    	//System.out.println("<<<<<greeting ID: " + grt.getId() + " content: " + grt.getContent());
//    	return grt;
//    }


    public Greeting getGreeting(){
        Greeting grt = null;

        return feignClient.getGreeting();
    }
	public Greeting getGreeting (String name) {
		Greeting grt = null;
        feignClient = new FeignClient(apiURL + "?name=" + name);
        return feignClient.getGreeting();
	}
    

}
