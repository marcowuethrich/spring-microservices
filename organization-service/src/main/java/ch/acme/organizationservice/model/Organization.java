package ch.acme.organizationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Organization {

    private Long id;
    private String name;
    private String address;
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();


    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

}