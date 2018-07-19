import com.soto.mmall.dao.UserMapper;
import com.soto.mmall.util.MD5Util;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMapper {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {
        System.out.println(userMapper);
        //插入用户
//        userMapper.insertSelective(
//                new User(null, "sotowang", "123", "soto@qq.com", "1888888888", "问题", "答案", 1, new Date(), new Date()));
        //

//        3.批量插入多个用户；批量，使用可以执行批量操作的sqlSession
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        for (int i = 0; i < 1000; i++) {
//            String uid = UUID.randomUUID().toString().substring(0, 5);
//            mapper.insertSelective(new User(null, uid, uid, uid+"@qq.com", "1888888888", "问题", "答案", 1, new Date(), new Date()));
//        }
//        System.out.println("批量完成");

        //4.登陆测试
//        User user = userMapper.selectLogin("sotowang", "123");
//        System.out.println(user.getUsername());
        //测试email
//        int count = userMapper.checkEmail("soto@qq.com");

        //测试delete
//        for (int i = 23; i < 88; i++) {
//            userMapper.deleteByPrimaryKey(i);
//        }


        //resetPassword
        String md5Password = MD5Util.MD5EncodeUtf8("admin111");
        int rowCount = userMapper.updatePasswordByUsername("admin1", md5Password);
        System.out.println(rowCount);


    }

}
