package com.wrok.employee.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private String location;

    private String department;


    public Employee(String name, String location, String department) {
        this.name = name;
        this.location = location;
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(name).append(',');
        sb.append(location).append(',');
        sb.append(department).append(' ');
        return sb.toString();

    }


}