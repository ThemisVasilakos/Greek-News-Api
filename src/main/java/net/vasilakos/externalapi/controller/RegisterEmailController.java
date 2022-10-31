package net.vasilakos.externalapi.controller;

import net.vasilakos.externalapi.model.Email;
import net.vasilakos.externalapi.service.SendArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterEmailController {

    @Autowired
    private SendArticleService sendArticleService;

    @PostMapping("/greeknews/register/{email}")
    public ResponseEntity<Email> subToNews(@PathVariable String email)  {
        try {
            sendArticleService.registerEmail(email);
        }catch (Exception e){
            System.out.println("Email already exists.");
        }
        return new ResponseEntity<Email>(HttpStatus.CREATED);
    }

    @DeleteMapping("/greeknews/unregister/{email}")
    public ResponseEntity<Email> unsubFromNews(@PathVariable String email){
        try {
            sendArticleService.unsub(email);
        }catch (Exception e){
            System.out.println("Email doesnot exist.");
        }
        return new ResponseEntity<Email>(HttpStatus.OK);
    }
}
