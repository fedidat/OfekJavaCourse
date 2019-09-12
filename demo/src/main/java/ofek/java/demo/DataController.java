package ofek.java.demo;

import ofek.java.entity.EmployeeEntity;
import ofek.java.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DataController {
    @Autowired
    EmployeeRepository repository;

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeById(@PathVariable long id)
    {
        Optional<EmployeeEntity> emp = repository.findById(id);
        return "Employee id " + id + ": " + emp.get();
    }
}
