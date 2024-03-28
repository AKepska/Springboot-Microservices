package com.apk.departmentservice.service;

import com.apk.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartamentByCode(String code);

}
