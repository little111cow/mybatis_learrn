package cn.app.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student implements Serializable {
    private int id;
    private String name;
    private String pwd;
    private Teacher teacher;
}
