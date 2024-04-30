package top.soest.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soest.dto.CategoryDTO;
import top.soest.result.Result;
import top.soest.service.CategoryService;
import top.soest.vo.CategoryVO;

@RestController
@RequestMapping("/user/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public Result<CategoryVO> getCategoryById(@RequestBody CategoryDTO categoryDTO) {
		return Result.success(categoryService.getCategoryById(categoryDTO));
	}
}
