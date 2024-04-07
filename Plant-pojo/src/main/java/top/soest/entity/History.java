package top.soest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long plId;

    private Long usId;

    private LocalDateTime time;
}
