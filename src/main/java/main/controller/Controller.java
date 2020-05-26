package main.controller;






import main.bean.Employee;
import main.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class Controller {
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/hello")
    public String hello( String name) {
        return String.format("Hello %s!",name);
    }

    @GetMapping("/select/{id}")
    @Cacheable(cacheNames = "emp")
    public List<Employee> select(@PathVariable("id")Integer id){
        System.out.println(id);
        List<Employee> emp = employeeMapper.select(id);
        return emp;
    }
    @GetMapping("/update")
    @CachePut("emp")
    public Integer update(Employee employee){
        Integer count = employeeMapper.update(employee);
        return count;
    }
    @GetMapping("/insert")
    @Cacheable("emp")
    public Integer insert(Employee employee){
        System.out.println(employee);
        Integer count = employeeMapper.insert(employee);
        return count;
    }

    @GetMapping("/delete/{id}")
    @CacheEvict("emp")
    public Integer delete(@PathVariable("id") Integer id){
        Integer count = employeeMapper.delete(id);
        return count;
    }

}
