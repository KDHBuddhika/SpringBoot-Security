package spring.Security.spring.Security.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
@CrossOrigin
public class NoticeController {

    @GetMapping("/my-notice")
    public String getLoanDetails(){
        return "hi Notice";

    }
}
