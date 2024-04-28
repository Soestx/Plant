package top.soest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer degree;

    private String name;

    private String userName;

    private String account;

    private String password;

    private LocalDateTime createTime;
}
