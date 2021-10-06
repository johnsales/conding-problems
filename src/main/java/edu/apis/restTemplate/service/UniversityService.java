package edu.apis.restTemplate.service;

import edu.apis.restTemplate.model.UniversityDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.*;

@Service
public class UniversityService {

    @Value("${uni_url}")
    private String URI_UNIVERSITIES;
    private final RestTemplate restTemplate;

    public UniversityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UniversityDTO> getAll(){
        UniversityDTO[] usersArray = restTemplate.getForObject(URI_UNIVERSITIES, UniversityDTO[].class);
        return Arrays.asList(usersArray);
    }

    public Optional<UniversityDTO> getByName(String name){
        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_UNIVERSITIES).queryParam("name", name);
        String uri = builder.buildAndExpand().toUri().toString();
        UniversityDTO[] uni = restTemplate.getForObject(uri, UniversityDTO[].class);

        return Optional.of(uni[0]);
    }

}
