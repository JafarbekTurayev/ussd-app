package ecma.ai.ussdapp.controller;

import ecma.ai.ussdapp.payload.ApiResponse;
import ecma.ai.ussdapp.payload.FilialDto;
import ecma.ai.ussdapp.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

    //filial qo'shish
//    @PreAuthorize(value = "hasAnyRole('ROLE_MANAGER')")
//    @PostMapping
//    public HttpEntity<?> addFilial(@RequestBody FilialDto filialDto) {
//        ApiResponse response = filialService.addFilial(filialDto);
//
//        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
//    }
}
