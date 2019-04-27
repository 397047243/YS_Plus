package cn.xrz.springboot_1;

import cn.xrz.springboot_1.entity.User;
import cn.xrz.springboot_1.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1ApplicationTests {


    @Test
    public void contextLoads() {

        User user = new User();
        user.setName("sss");
        System.out.println(user);
    }

}
