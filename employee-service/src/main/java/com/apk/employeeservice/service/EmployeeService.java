package com.apk.employeeservice.service;

import com.apk.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee (EmployeeDto employeeDto);
    EmployeeDto getEmployeeById (Long employeeId);
}
