package top.soest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.soest.entity.Manager;

@Mapper
public interface AdminMapper {

	@Select("select * from manager where account = #{account}")
	Manager getByAccount(String account);

	@Insert("insert into manager (name,user_name,account, password, degree,creat_time) values (#{name},#{userName}, #{account}, #{password}, #{degree},#{createTime})")
	void insert(Manager manager);

	@Select("select * from manager where id = #{id}")
	Manager getById(Long threadLocal);
}
