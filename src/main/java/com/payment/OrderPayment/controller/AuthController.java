package com.payment.OrderPayment.controller;
import com.payment.OrderPayment.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payment.OrderPayment.entity.User;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepo;
    AuthController(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        userRepo.save(user);
        return Map.of("success", true, "message", "User registered successfully");
    }
}