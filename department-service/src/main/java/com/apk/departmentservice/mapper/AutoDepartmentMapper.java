package com.apk.departmentservice.mapper;

import com.apk.departmentservice.dto.DepartmentDto;
import com.apk.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto (Department department);
    Department mapToDepartment (DepartmentDto departmentDto);
}
