package com.mazlumabul.restfullwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mazlumabul.restfullwebservices.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListSomeBean(){
        return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value1","value2","value3"));
    }

    @GetMapping("/filteringDinamic")
    public MappingJacksonValue retrieveSomeBeanDinamicFiltering(){
        // field1, field2

        SomeBean bean =  new SomeBean("value1","value2","value3");
        MappingJacksonValue mapping = new MappingJacksonValue(bean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filteringDinamics-list")
    public MappingJacksonValue retrieveListSomeBeanDinamicFiltering(){
        // field2, field3

         List<SomeBean> someBean = Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value1","value2","value3"));

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mapping.setFilters(filters);

         return mapping;
    }
}
