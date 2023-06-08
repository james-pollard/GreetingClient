package org.example;

import feign.Feign;
import feign.gson.GsonEncoder;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignClient implements GreetingClient{
    private String apiURL;
    private GreetingClient grtClient = null;
    public FeignClient (String url){
        apiURL = url;
        grtClient = (GreetingClient)Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(GreetingClient.class))
                .target(GreetingClient.class, apiURL);
    }

    @Override
    public Greeting getGreeting(){
        Greeting grt = grtClient.getGreeting();
        return grt;
    }
}
