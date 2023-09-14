package com.example.BaiTap1;


import com.example.BaiTap1.entity.People;
import com.example.BaiTap1.service.PeopleService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@SpringBootApplication
public class BaiTap1Application implements CommandLineRunner {
	@Autowired
	private PeopleService peopleService;

	public static void main(String[] args) {
		SpringApplication.run(BaiTap1Application.class, args);
	}
//Bài insert vào DB
	private void ex3(PeopleService service) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(new File(file("tong-hop.json")));

		List<People> list = new ArrayList<>();

		readJson(jsonNode, list);

		service.addAll(list);
	}
//Đọc file Json
	private void readJson(JsonNode jsonNode, List<People> peoples) {
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
//Link file json đang ở đâu
	private String file(String file) {
		return
				"D:\\JAVA 6\\BaiTap1\\src\\main\\resources\\json\\" + file;

	}

	@Override
	public void run(String... args) throws Exception {
		//Save vao db
//		ex3(peopleService);


       //Thống kê số lượng quốc gia theo tứ tự tăng dần
//		List<Map.Entry<String, Long>> sortedCountryCountList = peopleService.countCountries();
//		for (Map.Entry<String, Long> entry : sortedCountryCountList) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//			return;
//		}
		List<People> sortedPeopleList = peopleService.sortBySalary();

		// In ra danh sách đã sắp xếp
		for (People person : sortedPeopleList) {
			System.out.println(person.getFirstName() + " " + person.getLastName() + ": " + person.getSalary());
		}
	}
}
