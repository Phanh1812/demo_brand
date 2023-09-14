package com.example.BaiTap1.controller;

import com.example.BaiTap1.entity.People;
import com.example.BaiTap1.service.PeopleService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
//Hiển thị phân trang theo file json
public class Ex1 {
    public static void main(String[] args) throws IOException {
        PeopleService peopleService = new PeopleService();
        ex1(peopleService);
    }

    private static Page<People> page(List<People> list, Pageable pageable) {
        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int startItem = pageNo * pageSize;

        List<People> result;

        if (startItem >= list.size()) {
            result = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, list.size());
            result = list.subList(startItem, toIndex);
        }

        return new PageImpl<>(result, pageable, list.size());
    }

    private static void ex1(PeopleService service) throws IOException {

        String json =
                "C:\\Java6\\BaiTap1\\src\\main\\resources\\json\\people_0.json";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(json));

        List<People> peoples = new ArrayList<>();

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

        Page<People> pageAll = service.findAllPeople(peoples, PageRequest.of(0, 2));

        pageAll.forEach(System.out::println);
    }
}
