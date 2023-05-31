package com.example.RegisterLogin.Service.impl;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import javax.naming.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public String authenticate(String email, String password) throws AuthenticationException {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee!=null) {
            if (password.equals(employee.getPassword())) {
                return generateToken(employee.getEmployeeid());
            }
        }
        throw new AuthenticationException("Invalid username or password");
    }

    private String generateToken(Integer employeeId) {
        String secretKey = "1Cw#7^a9$4vKp@3r";
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        Date now = new Date();
        Date expiration = new Date(now.getTime() + (1000 * 120));
        String token = Jwts.builder()
                .setSubject(String.valueOf(employeeId))
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
}

