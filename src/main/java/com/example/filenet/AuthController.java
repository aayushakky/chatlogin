package com.example.filenet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @GetMapping("/")
    public String home() {
        return "forward:/chat-login.html";
    }

    @PostMapping("/chatLogin")
    @ResponseBody
    public Map<String, String> chatLogin(@RequestBody Map<String, String> req,
                                         HttpSession session,
                                         HttpServletRequest request) {

        Map<String, String> response = new HashMap<>();

        try {
            String message = req.get("message");

            if (message == null || message.trim().isEmpty()) {
                response.put("reply", "Enter username and password");
                return response;
            }

            String[] parts = message.split("\\s+");

            if (parts.length < 2) {
                response.put("reply", "Enter username and password");
                return response;
            }

            String username = parts[0];
            String password = parts[1];

            // 🔥 WAS authentication
            request.login(username, password);

            session.setAttribute("user", username);

            // 🔥 Redirect to Navigator
            response.put("redirect", "/navigator");

        } catch (Exception e) {
            response.put("reply", "Invalid username or password");
        }

        return response;
    }
}