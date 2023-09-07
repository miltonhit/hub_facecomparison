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

    @PostMapping(path = "/compare")
    public ComparisonOutput compare(@RequestBody  ComparisonInput input) throws Exception {
        float result = service.compareTwoPhotos(input.photo1(), input.photo2());
        return new ComparisonOutput(result);
    }

    record ComparisonInput(String photo1, String photo2) { }
    record ComparisonOutput(float similarity) { }
}