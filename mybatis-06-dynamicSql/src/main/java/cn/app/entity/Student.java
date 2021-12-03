package cn.app.entity;

import lombok.*;
import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String pwd;
    private Integer tid;
}
