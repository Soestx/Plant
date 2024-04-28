package top.soest.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "SpeciesVO", description = "植物展示信息")
public class SpeciesVO implements Serializable {

	private String cname;

	private String ename;

	private String info;

	private String kinddom;

	private String phylum;

	private String classs;

	private String order;

	private String family;

	private String genus;

	private Long contributorNum;

	private List<String> contributorsList;

	private String model;

	private Long imageNum;

	private List<String> imagesList;

	private LocalDateTime updateTime;

}
