package spring.Security.spring.Security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.Security.spring.Security.model.User;
import spring.Security.spring.Security.repositry.UserRepo;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){

        ResponseEntity responseEntity = null;

        try{
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User saveUser = userRepo.save(user);

            if(saveUser.getId() > 0){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given User are Successfully Registed");

            }
        }
        catch (Exception ex){
            responseEntity =ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Sn exception occured duo to "+ex.getMessage());

        }

        return responseEntity;
    }

}
