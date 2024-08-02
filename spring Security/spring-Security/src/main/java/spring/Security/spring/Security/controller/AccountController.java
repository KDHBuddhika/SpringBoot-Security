package spring.Security.spring.Security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountController {

    @GetMapping("/my-account")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_USER')")    //methaninma check karala thamai method ekhta yanne
//    @PostAuthorize("hasAuthority('ROLE_ADMIN')")    //method ekh athulata gihin return ekhdi thamai cheack karanne
    public String getAccountDetails(){
        System.out.println("awa");
        return "hi account ";
    }
}
