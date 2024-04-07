package top.soest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Logging implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime time;

    private Integer status;
}
