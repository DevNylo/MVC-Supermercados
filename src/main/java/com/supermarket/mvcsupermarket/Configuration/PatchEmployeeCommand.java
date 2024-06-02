package com.supermarket.mvcsupermarket.Configuration;

import com.supermarket.mvcsupermarket.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatchEmployeeCommand {

    @Autowired
    private EmployeeService employeeService;

    public boolean execute(long id, String newName) {
        return employeeService.updateEmployeeName(id, newName);
    }
}
