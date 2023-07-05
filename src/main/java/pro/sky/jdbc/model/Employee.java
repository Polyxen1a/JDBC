package pro.sky.jdbc.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
@EqualsAndHashCode(exclude = {"id"})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int city;

    public Employee(int i, String robert, String hunter, String m, int i1, int i2) {
    }

    public void setId(Integer employeeId) {
    }
}
