//package com.example.BaiTap1.controller;
//
//import com.example.BaiTap1.entity.People;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
////Viết script gộp thành 1 file json tổng
//public class Ex2 {
//    public static void main(String[] args) throws IOException {
//        ex2();
//    }
//    private static void ex2() throws IOException {
//        List<People> peoples = new ArrayList<>();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode0 = objectMapper.readTree(new File(file("people_0.json")));
//        JsonNode jsonNode1 = objectMapper.readTree(new File(file("people_1.json")));
//        JsonNode jsonNode2 = objectMapper.readTree(new File(file("people_2.json")));
//        JsonNode jsonNode3 = objectMapper.readTree(new File(file("people_3.json")));
//        JsonNode jsonNode4 = objectMapper.readTree(new File(file("people_4.json")));
//        JsonNode jsonNode5 = objectMapper.readTree(new File(file("people_5.json")));
//        JsonNode jsonNode6 = objectMapper.readTree(new File(file("people_6.json")));
//        JsonNode jsonNode7 = objectMapper.readTree(new File(file("people_7.json")));
//        JsonNode jsonNode8 = objectMapper.readTree(new File(file("people_8.json")));
//        JsonNode jsonNode9 = objectMapper.readTree(new File(file("people_9.json")));
//
//        readJson(jsonNode0, peoples);
//        readJson(jsonNode1, peoples);
//        readJson(jsonNode2, peoples);
//        readJson(jsonNode3, peoples);
//        readJson(jsonNode4, peoples);
//        readJson(jsonNode5, peoples);
//        readJson(jsonNode6, peoples);
//        readJson(jsonNode7, peoples);
//        readJson(jsonNode8, peoples);
//        readJson(jsonNode9, peoples);
//
//        writeJson(peoples);
//
//    }
//
//    private static void readJson(JsonNode jsonNode, List<People> peoples) {
//        jsonNode.iterator().forEachRemaining(
//                people -> peoples.add(
//                        new People(
//                                UUID.fromString(people.get("id").asText()),
//                                people.get("first_name").asText(),
//                                people.get("last_name").asText(),
//                                people.get("email").asText(),
//                                people.get("gender").asText(),
//                                people.get("ip_address").asText(),
//                                people.get("avatar").asText(),
//                                people.get("country").asText(),
//                                people.get("job").asText(),
//                                people.get("company").asText(),
//                                people.get("salary").asDouble(),
//                                people.get("username").asText(),
//                                people.get("password").asText(),
//                                people.get("slogan").asText()
//                        )
//                ));
//    }
//
//    private static String file(String file) {
//        return
//                "C:\\Java6\\BaiTap1\\src\\main\\resources\\json\\" + file;
//
//    }
//
//    private static void writeJson(List<People> peoples) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<ObjectNode> list = new ArrayList<>();
//
//        peoples.forEach(people -> {
//
//            ObjectNode objectNode = mapper.createObjectNode();
//
//            objectNode.put("id", String.valueOf(people.getId()));
//            objectNode.put("first_name", people.getFirstName());
//            objectNode.put("last_name", people.getLastName());
//            objectNode.put("email", people.getEmail());
//            objectNode.put("gender", people.getGender());
//            objectNode.put("ip_address", people.getIpAddress());
//            objectNode.put("avatar", people.getAvatar());
//            objectNode.put("country", people.getCountry());
//            objectNode.put("job", people.getJob());
//            objectNode.put("company", people.getCompany());
//            objectNode.put("salary", people.getSalary());
//            objectNode.put("username", people.getUsername());
//            objectNode.put("password", people.getPassword());
//            objectNode.put("slogan", people.getSlogan());
//
//            list.add(objectNode);
//        });
//
//
//        mapper.writeValue(System.out, list.size());
//
//        mapper.writeValue(new File(file("tong-hop.json")), list);
//    }
//}
