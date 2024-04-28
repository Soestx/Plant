package top.soest.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.soest.dto.SpeciesDTO;
import top.soest.entity.Species;
import top.soest.mapper.SpeciesMapper;
import top.soest.result.PageResult;
import top.soest.service.SpeciesService;
import top.soest.vo.SpeciesVO;

import java.util.Arrays;
import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

	@Autowired
	SpeciesMapper speciesMapper;

	@Override
	public SpeciesVO getById(Long id) {

		Species species = new Species();
		species.setId(id);
		species = speciesMapper.getByMap(species);

		SpeciesVO speciesVO = new SpeciesVO();
		BeanUtils.copyProperties(species, speciesVO);
		speciesVO.setContributorsList(Arrays.asList(species.getContributors().split(",")));
		speciesVO.setImagesList(Arrays.asList(species.getImages().split(",")));

		return speciesVO;
	}

	@Override
	public PageResult getPlantsByPage(SpeciesDTO speciesDTO, int page, int pageSize) {

		PageHelper.startPage(page, pageSize);
		Species species = new Species();
		BeanUtils.copyProperties(speciesDTO, species);
		Page<Species> pages = speciesMapper.pageQuery(species);
		List<SpeciesVO> speciesVOS = (List<SpeciesVO>) pages.stream().map(species1 -> {

			SpeciesVO speciesVO = new SpeciesVO();
			BeanUtils.copyProperties(species1, speciesVO);
			speciesVO.setContributorsList(Arrays.asList(species1.getContributors().split(",")));
			speciesVO.setImagesList(Arrays.asList(species1.getImages().split(",")));
			return speciesVO;
		});
		return new PageResult(pages.getTotal(), speciesVOS);
	}
}
