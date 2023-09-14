package com.example.BaiTap1.controller;

import com.example.BaiTap1.entity.People;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        ex4();
    }

    private static void ex4() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File(file("tong-hop.json")));

        List<People> peoples = new ArrayList<>();

        readJson(jsonNode, peoples);

        Map<String, Integer> map = countSlogan(peoples);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((value1, value2) -> value1.getValue() - value2.getValue());

        for (Map.Entry<String, Integer> count : list) {
            System.out.println(count.getKey() + ": " + count.getValue());
        }

    }

    private static Map<String, Integer> countSlogan(List<People> list) {
        Map<String, Integer> map = new HashMap<>();
        for (People people : list) {
            String[] slogans = people.getSlogan().split(" ");
            for (String slogan : slogans) {
                if (map.containsKey(slogan)) {
                    map.put(slogan, map.get(slogan) + 1);
                } else {
                    map.put(slogan, 1);
                }
            }
        }
        return map;
    }

    private static String file(String file) {
        return "C:\\Java6\\BaiTap1\\src\\main\\resources\\json\\" + file;
    }

    private static void readJson(JsonNode jsonNode, List<People> peoples) {
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
}
