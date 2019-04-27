package cn.xrz.springboot_1.service;

import cn.xrz.springboot_1.entity.Student;
import cn.xrz.springboot_1.entity.User;
import cn.xrz.springboot_1.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public Student findByNmae(String name){
        return studentMapper.findByName(name);
    }

    public int insert(String name,String password){
        return studentMapper.insert(name,password);
    }

    /**
     * 获取指定页数的学生
     * @param pageNo    页数
     * @param pageSize  每页展示条数
     * @return
     */
    public PageInfo<Student> getList(int pageNo,int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Student> list = studentMapper.getList();
        return new PageInfo<Student>(list);
    }

}
