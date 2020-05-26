package main.mapper;

import main.bean.Employee;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface EmployeeMapper  {
    @Select("select * from employee  where id=#{id}")
    public List<Employee> select(Integer id);
    @Update("update employee set name=#{name},salary=#{salary} where id=#{id}")
    public Integer update(Employee employee);

    public  Integer insert(Employee employee);

    public Integer delete(Integer id);
}


