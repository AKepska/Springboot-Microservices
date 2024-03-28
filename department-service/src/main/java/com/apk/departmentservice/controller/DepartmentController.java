package com.apk.departmentservice.controller;

import com.apk.departmentservice.dto.DepartmentDto;
import com.apk.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //saveDepartment rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }
    //getDepartment
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment (@PathVariable ("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartamentByCode(departmentCode);
        return ResponseEntity.ok(departmentDto);
    }
}
