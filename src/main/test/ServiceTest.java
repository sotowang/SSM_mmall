import com.soto.mmall.common.ServerResponse;
import com.soto.mmall.pojo.User;
import com.soto.mmall.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    private IUserService iUserService;

    @Test
    public void Test() {
        //测试登陆
//        ServerResponse serverResponse = iUserService.login("admin", "admin");
//        ServerResponse<String> serverResponse = iUserService.checkValid("363fe", "username");
        //注册测试
//        User user = new User(null,"admin1","admin","soto1@qq.com","188888","问题","答案");
//        ServerResponse serverResponse =iUserService.register(user);

        ServerResponse<String> serverResponse = iUserService.checkAnswer("admin1", "问题", "答案");

        ServerResponse<String> serverResponse1 = iUserService.forgetResetPassword("admin1", "admin111", serverResponse.getData());
        System.out.println(serverResponse1.getMsg());

    }

}
