package org.perscholas.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    //fields

    @Id
    long empId;
    String empName;
    String email;
    // @ManyToOne
   // Department department;




}