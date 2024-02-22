package com.poc.basicauth.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("app")
public class HelloWorldController {

    @GetMapping(value = "/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String greeting(@PathVariable String name) {
        return "Welcome %s".formatted(name);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postName(@RequestBody Map<String, Object> request) {
        System.out.println(request.get("name"));
        return ResponseEntity.ok("OK");
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putName(@RequestBody Map<String, Object> request) {
        System.out.println(request.get("name"));
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delName(@RequestBody Map<String, Object> request) {
        System.out.println(request.get("name"));
        return ResponseEntity.ok("OK");
    }
}
