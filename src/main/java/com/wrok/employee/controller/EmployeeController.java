package com.wrok.employee.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wrok.employee.DAO.EmployeeDAO;
import com.wrok.employee.entity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v5/")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    private static final Logger log = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeDAO eDAO;
    private final Set<String> kafkaRecords = new HashSet<String>();

    @GetMapping("employees")
    public List<Employee> findAll() {

        return eDAO.findAll();
    }

    @GetMapping("employees/{id}")
    public Employee findById(@PathVariable int id) {
        return eDAO.findById(id);
    }

    @DeleteMapping("employees/{id}")
    public String deleteById(@PathVariable int id) {
        return eDAO.deleteById(id) + " Employee(s) delete from the database";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Employee e) {
        kafkaTemplate.send(TOPIC, e);
        return eDAO.save(e) + " Employee(s) saved successfully";
    }


    @PutMapping("employees/{id}")
    public String update(@RequestBody Employee e, @PathVariable int id) {
        return eDAO.update(e, id) + " Employee(s) updated successfully";
    }

    //kafka

    @GetMapping("kafkadata")
    public List<Employee> findKafka() {
        return eDAO.findKafka();

    }
}