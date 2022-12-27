package com.SWOOSH.controller.regauth;

import com.SWOOSH.dto.LoginDTO;
import com.SWOOSH.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "${spring.whiteip}")
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO request) {
        return authenticationService.authenticate(request);
    }

    @RequestMapping(value = "codeForConfirm", method = RequestMethod.GET)
    public ModelAndView confirmCodeEmail(String message) {
        ModelAndView model = new ModelAndView("emailForm");
        model.addObject("codeForConfirm", message);
        return model;
    }
}

