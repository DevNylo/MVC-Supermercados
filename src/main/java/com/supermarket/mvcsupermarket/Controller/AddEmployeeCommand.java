package com.supermarket.mvcsupermarket.Controller;

import com.supermarket.mvcsupermarket.Entity.Employee;
import com.supermarket.mvcsupermarket.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddEmployeeCommand {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String cadastrarFuncionario(@ModelAttribute("employee") Employee employee) {
        employeeService.salvarFuncionario(employee);
        return "./pages/funcionario";
    }
}
