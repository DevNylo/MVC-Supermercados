package com.supermarket.mvcsupermarket.Controller;

import com.supermarket.mvcsupermarket.Entity.Employee;
import com.supermarket.mvcsupermarket.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String listarFuncionarios(Model model) {
        List<Employee> employees = employeeService.listEmployee();
        model.addAttribute("employee", employees);
        return "./pages/funcionario";
    }

    @PostMapping("/employee")
    public String cadastrarFuncionario(@ModelAttribute("employee") Employee employee) {
        // Salvar funcionário no banco de dados usando o serviço FuncionarioService
        employeeService.salvarFuncionario(employee);
        return "./pages/funcionario"; // Redirecionar para uma página de sucesso
    }

    @GetMapping("/relatorio")
    public String relatorio(Model model) {
        return "./pages/relatorio";
    }

}
