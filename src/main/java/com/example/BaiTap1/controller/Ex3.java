package com.example.BaiTap1.controller;

import com.example.BaiTap1.BaiTap1Application;
import com.example.BaiTap1.entity.People;
import com.example.BaiTap1.service.PeopleService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class Ex3 implements CommandLineRunner{
    @Autowired
    private PeopleService peopleService;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Ex3.class, args);
    }

    private  void ex3(PeopleService service) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File(file("tong-hop.json")));

        List<People> list = new ArrayList<>();

        readJson(jsonNode, list);

        service.addAll(list);
    }

    private  String file(String file) {
        return
                "C:\\Java6\\BaiTap1\\src\\main\\resources\\json\\" + file;

    }

    private  void readJson(JsonNode jsonNode, List<People> peoples) {
        jsonNode.iterator().forEachRemaining(
                people -> peoples.add(
                        new People(
                                UUID.fromString(people.get("id").asText()),
                                people.get("first_name").asText(),
                                people.get("last_name").asText(),
                                people.get("email").asText(),
                                people.get("gender").asText(),
                                people.get("ip_address").asText(),
                                people.get("avatar").asText(),
                                people.get("country").asText(),
                                people.get("job").asText(),
                                people.get("company").asText(),
                                people.get("salary").asDouble(),
                                people.get("username").asText(),
                                people.get("password").asText(),
                                people.get("slogan").asText()
                        )
                ));
    }

    @Override
    public void run(String... args) throws Exception {
        ex3(peopleService);
    }

}
