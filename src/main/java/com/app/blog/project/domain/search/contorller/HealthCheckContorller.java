package com.app.blog.project.domain.search.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/health-check")
public class HealthCheckContorller {

    @GetMapping
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
