package top.soest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Species implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String cname;

    private String ename;

    private String info;

    private Long kinddom;

    private Long phylum;

    private Long classs;

    private Long order;

    private Long family;

    private Long genus;

    private Long contributorNum;

    private String contributors;

    private String model;

    private Long imageNum;

    private String images;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;

    private Integer status;
}
