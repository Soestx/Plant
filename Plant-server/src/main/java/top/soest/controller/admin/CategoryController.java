package top.soest.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soest.dto.CategoryDTO;
import top.soest.entity.Category;
import top.soest.result.Result;
import top.soest.service.CategoryService;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class CategoryController {


	@Autowired
	CategoryService categoryService;

	@PostMapping
	@ApiOperation(value = "新增分类")
	public Result<Category> add(@RequestBody CategoryDTO categoryDTO) {

		log.info("新增分类信息：{}", categoryDTO);
		Category category = categoryService.addCategory(categoryDTO);
		return Result.success(category);
	}

	@PutMapping
	@ApiOperation(value = "更新分类")
	public Result<Category> update(@RequestBody CategoryDTO categoryDTO) {

		log.info("更新分类信息：{}", categoryDTO);
		Category category = categoryService.updateCategory(categoryDTO);
		return Result.success(category);
	}

	@DeleteMapping
	@ApiOperation(value = "删除分类")
	public Result delete(@RequestBody CategoryDTO categoryDTO) {

		log.info("删除分类信息：{}", categoryDTO);
		categoryService.deleteCategory(categoryDTO);
		return Result.success();
	}


}
