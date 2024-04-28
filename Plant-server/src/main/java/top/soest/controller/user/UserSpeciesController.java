package top.soest.controller.user;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.soest.dto.CategoryPageQueryDTO;
import top.soest.entity.Species;
import top.soest.result.PageResult;
import top.soest.result.Result;

@RestController
@RequestMapping("/user/species")
@Api(value = "植物信息", tags = "植物信息")
@Slf4j
public class UserSpeciesController {

	@GetMapping("/{id}")
	public Result<Species> getPlant(@PathVariable Long id) {
		Species species = new Species();

		//TODO:获取植物信息
		return Result.success(species);
	}

	@GetMapping("/page")
	public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {

		PageResult pageResult = new PageResult();
		//TODO:分页查询植物信息
		return Result.success(pageResult);
	}
}
