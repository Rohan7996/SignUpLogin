package com.example.RegisterLogin.EmployeeController;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.Service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/signup")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) throws AuthenticationException {
        String token = authService.authenticate(loginDTO.getEmail(),loginDTO.getPassword());
        return ResponseEntity.ok(token);
    }
}
