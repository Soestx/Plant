package top.soest.mapper;

import org.apache.ibatis.annotations.Delete;
import top.soest.entity.Category;

import java.util.List;

public interface CategoryMapper {

	List<Category> getKingdoms(Category category);

	List<Category> getPhylums(Category category);

	List<Category> getClasses(Category category);

	List<Category> getOrders(Category category);

	List<Category> getFamilies(Category category);

	List<Category> getGenus(Category category);

	Category addKingdoms(Category category);

	Category addPhylums(Category category);

	Category addClasses(Category category);

	Category addOrders(Category category);

	Category addFamilies(Category category);

	Category addGenus(Category category);

	Category updateKingdoms(Category category);

	Category updatePhylums(Category category);

	Category updateClasses(Category category);

	Category updateOrders(Category category);

	Category updateFamilies(Category category);

	Category updateGenus(Category category);

	@Delete("delete from kingdom where id = #{id}")
	void deleteKingdoms(Category category);

	@Delete("delete from phylum where id = #{id}")
	void deletePhylums(Category category);

	@Delete("delete from class where id = #{id}")
	void deleteClasses(Category category);

	@Delete("delete from orders where id = #{id}")
	void deleteOrders(Category category);

	@Delete("delete from family where id = #{id}")
	void deleteFamilies(Category category);

	@Delete("delete from genus where id = #{id}")
	void deleteGenera(Category category);
}
