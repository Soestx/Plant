package top.soest.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soest.dto.SpeciesDTO;
import top.soest.result.PageResult;
import top.soest.result.Result;
import top.soest.service.SpeciesService;
import top.soest.vo.SpeciesVO;

@RestController
@RequestMapping("/plants")
@Api(tags = "植物资源模块")
@Slf4j
public class PlantsController {

	@Autowired
	SpeciesService speciesService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取植物信息")
	public Result<SpeciesVO> getPlantById(@PathVariable Long id) {

		SpeciesVO speciesVO = speciesService.getById(id);
		return Result.success();
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取植物列表")
	public Result<PageResult> getPlantsByPage(@RequestBody SpeciesDTO speciesDTO,int page,int pageSize) {

		return Result.success(speciesService.getPlantsByPage(speciesDTO,page,pageSize));
	}
}
