package top.soest.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.soest.dto.CategoryDTO;
import top.soest.entity.Category;
import top.soest.mapper.CategoryMapper;
import top.soest.service.CategoryService;
import top.soest.vo.CategoryVO;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Mapper
	CategoryMapper categoryMapper;

	@Override
	public Category addCategory(CategoryDTO categoryDTO) {

		Category category = new Category();
		BeanUtils.copyProperties(categoryDTO, category);
		category = addCategoryInAll(category);
		return category;
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO) {

		Category category = new Category();
		BeanUtils.copyProperties(categoryDTO, category);
		category = updateCategoryInAll(category);
		return category;
	}

	@Override
	public void deleteCategory(CategoryDTO categoryDTO) {

		Category category = new Category();
		BeanUtils.copyProperties(categoryDTO, category);
		deleteCategoryInAll(category);
	}

	@Override
	public CategoryVO getCategoryById(CategoryDTO categoryDTO) {

		CategoryVO categoryVO = new CategoryVO();
		Category category = new Category();
		BeanUtils.copyProperties(categoryDTO, category);
		category = getCategoryInAll(category).get(0);
		BeanUtils.copyProperties(category, categoryVO);

		List<Integer> faIds = new ArrayList<>();
		List<String> faNames = new ArrayList<>();
		for (int i = categoryVO.getType() -1 ; i > 0 ; i--) {
			Long id = category.getFaId();
			category = new Category();
			if (id == null) { break; }
			category.setId(id);
			category.setType(i);
			category = getCategoryInAll(category).get(0);
			faIds.add(Math.toIntExact(category.getId()));
			faNames.add(category.getName());
		}
		Collections.reverse(faIds);
		Collections.reverse(faNames);
		categoryVO.setFaIds(faIds);
		categoryVO.setFaNames(faNames);
		return categoryVO;
	}

	public List<Category> getCategoryInAll(Category category) {

		List<Category> categoryList = new ArrayList<>();
		if (category.getType() == 1) categoryList = categoryMapper.getKingdoms(category);
		if (category.getType() == 2) categoryList = categoryMapper.getPhylums(category);
		if (category.getType() == 3) categoryList = categoryMapper.getClasses(category);
		if (category.getType() == 4) categoryList = categoryMapper.getOrders(category);
		if (category.getType() == 5) categoryList = categoryMapper.getFamilies(category);
		if (category.getType() == 6) categoryList = categoryMapper.getGenus(category);
		return categoryList;
	}
	public Category addCategoryInAll(Category category) {

		if (category.getType() == 1) category = categoryMapper.addKingdoms(category);
		if (category.getType() == 2) category = categoryMapper.addPhylums(category);
		if (category.getType() == 3) category = categoryMapper.addClasses(category);
		if (category.getType() == 4) category = categoryMapper.addOrders(category);
		if (category.getType() == 5) category = categoryMapper.addFamilies(category);
		if (category.getType() == 6) category = categoryMapper.addGenus(category);
		return category;
	}

	public Category updateCategoryInAll(Category category) {

		if (category.getType() == 1) category = categoryMapper.updateKingdoms(category);
		if (category.getType() == 2) category = categoryMapper.updatePhylums(category);
		if (category.getType() == 3) category = categoryMapper.updateClasses(category);
		if (category.getType() == 4) category = categoryMapper.updateOrders(category);
		if (category.getType() == 5) category = categoryMapper.updateFamilies(category);
		if (category.getType() == 6) category = categoryMapper.updateGenus(category);
		return category;
	}

	public void deleteCategoryInAll(Category category) {

		if (category.getType() == 1) categoryMapper.deleteKingdoms(category);
		if (category.getType() == 2) categoryMapper.deletePhylums(category);
		if (category.getType() == 3) categoryMapper.deleteClasses(category);
		if (category.getType() == 4) categoryMapper.deleteOrders(category);
		if (category.getType() == 5) categoryMapper.deleteFamilies(category);
		if (category.getType() == 6) categoryMapper.deleteGenera(category);
	}
}
