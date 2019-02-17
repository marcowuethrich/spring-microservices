package ch.acme.organizationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Department {

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();


    public Department(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

}