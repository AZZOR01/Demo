package com.cpt202.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.cpt202.demo.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
 // Custom queries (if needed)
 
    //查询所有员工
    List<Employee> findAll();

    //根据员工账号删除员工
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    //添加新员工
    Boolean insertEmployee(Employee employee);

    //根据员工账号修改会员信息
    Boolean updateMemberByEmployeeAccount(Employee employee);

    //根据员工账号查询员工
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    //查询员工数
    Integer selectTotalCount();

    Employee selectByAccountAndPassword(Employee employee);
}
