package cn.xrz.springboot_1.mapper;

import cn.xrz.springboot_1.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
public interface StudentMapper {

    @Select("select * from students where name = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("insert into students(name,password) value(#{name},#{password})")
    int insert(@Param("name") String name,@Param("password") String password);

    @Select("select * from students")
    List<Student> getList();

}
