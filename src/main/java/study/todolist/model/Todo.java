package study.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Boolean done;

    @Column
    @JsonFormat(pattern =  "dd/MM/yyyy HH:mm")
    private String createdDate;

    @Column
    @JsonFormat(pattern =  "dd/MM/yyyy HH:mm")
    private String doneDate;

}
