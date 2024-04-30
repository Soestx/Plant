package top.soest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long faId;

    private String name;

    private String info;

    private Integer type;
}
