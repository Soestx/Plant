package top.soest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.soest.entity.Manager;
import top.soest.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where account = #{account}")
	User getByAccount(String account);
	
	void addUser(User user);

	User getByMap(User user);
}
