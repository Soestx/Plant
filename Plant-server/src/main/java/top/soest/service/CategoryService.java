package top.soest.service;

import top.soest.dto.CategoryDTO;
import top.soest.entity.Category;
import top.soest.vo.CategoryVO;

public interface CategoryService {
	Category addCategory(CategoryDTO categoryDTO);

	Category updateCategory(CategoryDTO categoryDTO);

	void deleteCategory(CategoryDTO categoryDTO);


	CategoryVO getCategoryById(CategoryDTO categoryDTO);
}
