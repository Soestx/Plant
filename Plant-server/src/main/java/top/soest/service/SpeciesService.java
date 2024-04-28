package top.soest.service;

import top.soest.dto.SpeciesDTO;
import top.soest.result.PageResult;
import top.soest.vo.SpeciesVO;

public interface SpeciesService {
	SpeciesVO getById(Long id);

	PageResult getPlantsByPage(SpeciesDTO speciesDTO, int page, int pageSize);
}
