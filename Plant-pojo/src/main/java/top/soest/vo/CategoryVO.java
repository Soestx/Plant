package top.soest.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "CategoryVO", description = "分类信息")
public class CategoryVO implements Serializable {

    private List<Integer> faIds;

    private List<String> faNames;

    private String name;

    private String info;

    private Integer type;
}
