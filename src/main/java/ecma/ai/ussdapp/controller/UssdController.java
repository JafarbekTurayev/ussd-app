package ecma.ai.ussdapp.controller;

import ecma.ai.ussdapp.payload.ApiResponse;
import ecma.ai.ussdapp.payload.UssdCodeDTO;
import ecma.ai.ussdapp.service.UssdCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ussd")
public class UssdController {
    @Autowired
    UssdCodeService ussdCodeService;

    @PostMapping
    public HttpEntity<?> addUssd(@RequestBody UssdCodeDTO ussdCodeDTO){
        ApiResponse response = ussdCodeService.addUssd(ussdCodeDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }
}
