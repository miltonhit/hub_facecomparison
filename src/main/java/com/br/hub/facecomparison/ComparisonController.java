package com.br.hub.facecomparison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/facecomparison", produces=MediaType.APPLICATION_JSON_VALUE)
public class ComparisonController {

    @Autowired
    private ComparisonService service;

    @GetMapping("/status")
    public Status getStatus() {
        return new Status("OK AND RUNNING");
    }

    @PostMapping(path="/compare", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ComparisonOutput compare(@RequestBody  ComparisonInput input) throws Exception {
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
    record Status(String status) { }
}