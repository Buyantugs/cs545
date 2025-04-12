package myapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/shop")
    public ResponseEntity<?> getShop() {
        return new ResponseEntity<String> ("shop page", HttpStatus.OK);
    }
    @GetMapping("/orders")
    @PreAuthorize("hasAnyRole('role1','role2')")
    public ResponseEntity<?> getOrder() {
        return new ResponseEntity<String> ("order page!", HttpStatus.OK);
    }
    @GetMapping("/payments")
    @PreAuthorize("hasRole('role2')")
    public ResponseEntity<?> getPayment() {
        return new ResponseEntity<String> ("payment page!", HttpStatus.OK);
    }
}


