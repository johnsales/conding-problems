package edu.apis.weatherAPI.controller;

import edu.problems.code.ComponentDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "components")
@AllArgsConstructor
public class PrimeChemicalComponentsApiRestController {

    @GetMapping()
    public Map<String, List<ComponentDTO>> getComponents() {
        List<ComponentDTO> list = new ArrayList<>();
        list.add(new ComponentDTO("AL", 4));
        list.add(new ComponentDTO("FE", 5));

        return new HashMap<>(){{
            put("components",list.stream().filter(c -> isPrime(c.getNumber())).collect(Collectors.toList()));
        }};
    }

    private boolean isPrime(int value) {
        if(value < 2) return false;
        if(value == 2) return true;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }

        return true;
    }

}