package top.soest.controller.admin;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import top.soest.dto.CategoryDTO;
import top.soest.entity.Category;
import top.soest.result.Result;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class categoryController {

	@PostMapping
	public Result<Category> add(@RequestBody CategoryDTO speciesDTO) {

		log.info("新增分类信息：{}", speciesDTO);
		Category category = new Category();
		BeanUtils.copyProperties(speciesDTO, category);
		//TODO:新增分类
		return Result.success(category);
	}

	@PutMapping
	public Result<Category> update(@RequestBody CategoryDTO speciesDTO) {

		log.info("更新分类信息：{}", speciesDTO);
		Category category = new Category();
		BeanUtils.copyProperties(speciesDTO, category);
		//TODO:更新分类
		return Result.success(category);
	}

	@DeleteMapping
	public Result delete(@RequestBody CategoryDTO speciesDTO) {

		log.info("删除分类信息：{}", speciesDTO);
		Category category = new Category();
		BeanUtils.copyProperties(speciesDTO, category);
		//TODO:删除分类
		return Result.success(category);
	}


}
