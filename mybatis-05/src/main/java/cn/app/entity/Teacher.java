package cn.app.entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Teacher implements Serializable {
    private int id;
    private String name;
    private ArrayList<Student> studentList;
}
