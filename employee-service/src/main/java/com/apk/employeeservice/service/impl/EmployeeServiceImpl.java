package com.apk.employeeservice.service.impl;

import com.apk.employeeservice.dto.EmployeeDto;
import com.apk.employeeservice.entity.Employee;
import com.apk.employeeservice.mapper.AutoEmployeeMapper;
import com.apk.employeeservice.repository.EmployeeRepository;
import com.apk.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail());

        //Mapping by ModelMapper:
//        Employee employee = modelMapper.map(employeeDto, Employee.class);
        //Mapping by MapStruct:
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
//        EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail());

        //Mapping by ModelMapper:
//        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        //Mapping by MapStruct:
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById (Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
//        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail());

        //Mapping by ModelMapper:
//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        //Mapping by MapStruct:
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
