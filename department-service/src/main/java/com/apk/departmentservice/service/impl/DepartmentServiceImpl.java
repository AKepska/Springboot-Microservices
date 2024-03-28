package com.apk.departmentservice.service.impl;

import com.apk.departmentservice.dto.DepartmentDto;
import com.apk.departmentservice.entity.Department;
import com.apk.departmentservice.mapper.AutoDepartmentMapper;
import com.apk.departmentservice.repository.DepartmentRepository;
import com.apk.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert dto to department jpa entity
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode());

        //Mapping by ModelMapper:
//        Department department = modelMapper.map(departmentDto, Department.class);
        //Mapping by MapStruct:
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);


        Department savedDepartment = departmentRepository.save(department);
        //convert jpa entity do dto
//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode());

        //Mapping by ModelMapper:
//        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
        //Mapping by MapStruct:
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartamentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//         );

        //Mapping by ModelMapper:
//        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        //Mapping by MapStruct:
        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }
}
