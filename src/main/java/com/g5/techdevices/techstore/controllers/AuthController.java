package com.g5.techdevices.techstore.controllers;

import com.g5.techdevices.techstore.dto.LoginRequest;
import com.g5.techdevices.techstore.entity.users.User;
import com.g5.techdevices.techstore.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> {
                    // So sánh mật khẩu plaintext với passwordHash
                    if (passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
                        if (Boolean.TRUE.equals(user.getIsActive())) {
                            return ResponseEntity.ok(Map.of(
                                    "status", "success",
                                    "message", "Login successful",
                                    "role", user.getRole()
                            ));
                        } else {
                            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                                    "status", "fail",
                                    "message", "Account is inactive"
                            ));
                        }
                    } else {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                                "status", "fail",
                                "message", "Invalid email or password"
                        ));
                    }
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                        "status", "fail",
                        "message", "Invalid email or password"
                )));
    }
    // 🔹 Logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate(); // xoá session
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Logged out successfully"
        ));
    }

    // 🔹 Check login status
    @GetMapping("/status")
    public ResponseEntity<?> status(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return ResponseEntity.ok(Map.of(
                    "status", "logged_in",
                    "user", user
            ));
        }
        return ResponseEntity.ok(Map.of(
                "status", "logged_out"
        ));
    }
}
