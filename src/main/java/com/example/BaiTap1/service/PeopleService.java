package com.example.BaiTap1.service;

import com.example.BaiTap1.entity.People;
import com.example.BaiTap1.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    private Page<People> page(List<People> list, Pageable pageable) {

        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int startItem = pageNo * pageSize;

        List<People> result;

        if (startItem > list.size()) {
            result = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, list.size());
            result = list.subList(startItem, toIndex);
        }

        return new PageImpl<>(result, PageRequest.of(pageNo, pageSize), list.size());
    }

    public Page<People> findAllPeople(List<People> list,Pageable pageable) {
        return page(list,pageable);
    }



    public void addAll(List<People> list){
        this.peopleRepository.saveAll(list);
    }


    //Đếm thành phố
    public List<Map.Entry<String, Long>> countCountries() {
        List<People> peopleList = this.peopleRepository.findAll();

        Map<String, Long> countryCountMap = new HashMap<>();
        for (People people : peopleList) {
            String country = people.getCountry();
            countryCountMap.put(country, countryCountMap.getOrDefault(country, 0L) + 1);
        }

        List<Map.Entry<String, Long>> sortedCountryCountList = new ArrayList<>(countryCountMap.entrySet());
        sortedCountryCountList.sort(Map.Entry.comparingByValue());

        return sortedCountryCountList;
    }

    //Sắp xếp theo lương
    public List<People> sortBySalary() {
        List<People> peopleList = this.peopleRepository.findAll();

                peopleList.sort(Comparator.comparingDouble(People::getSalary));

        return peopleList;
    }


}
