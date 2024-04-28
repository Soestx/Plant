package top.soest.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import top.soest.entity.Species;

@Mapper
public interface SpeciesMapper {
	Species getByMap(Species species);

	Page<Species> pageQuery(Species species);
}
