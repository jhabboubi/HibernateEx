package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    // fields

    @Id
    int depId;
    String depName;
   // @OneToMany(mappedBy="department",cascade= CascadeType.ALL)
   // List<Employee> employeeList;
}