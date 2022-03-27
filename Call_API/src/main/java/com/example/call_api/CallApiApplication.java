package com.example.call_api;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootApplication
public class CallApiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CallApiApplication.class, args);

        final String url = "https://read-jsson.herokuapp.com/api/v1/provinces";

        Response response = Request.Get(url).execute();

        String data = new String(response.returnContent().asBytes(), StandardCharsets.UTF_8);

        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<?> jsonAdapter = moshi.adapter(Province[].class);

        List<Province> provinces = List.of((Province[])jsonAdapter.fromJson(data));
    }

}
