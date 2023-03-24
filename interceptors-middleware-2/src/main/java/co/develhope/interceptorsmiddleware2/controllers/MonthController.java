package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public ResponseEntity<Month> getMonth(Month month) {
        return new ResponseEntity<>(month, HttpStatus.OK);
    }
}
