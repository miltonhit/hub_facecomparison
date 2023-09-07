package com.br.hub.facecomparison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/facecomparison")
public class ComparisonController {

    @Autowired
    private ComparisonService service;

    @GetMapping("/status")
    public String getStatus() {
        return "RUNNING!";
    }

    @PostMapping("/compare")
    public ComparisonOutput compare(@RequestBody  ComparisonInput input) throws Exception {
        System.out.println("SEI_LA");

        try {
            float result = service.compareTwoPhotos(input.photo1(), input.photo2());
            return new ComparisonOutput(result);
        } catch(Exception exc) {
            exc.printStackTrace();
            return new ComparisonOutput(-1);
        }
    }

    record ComparisonInput(String photo1, String photo2) { }
    record ComparisonOutput(float similarity) { }
}