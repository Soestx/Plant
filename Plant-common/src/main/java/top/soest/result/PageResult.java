package top.soest.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分装分页查询结果
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    private long total;

    private List records;

}
