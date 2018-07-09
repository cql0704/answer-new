package answer.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.dao.UserInfoMapper;
import com.cy.answer.model.UserInfo;

public class UserTest extends BaseJunit4Test{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Test
	public void testSave() {
		UserInfo userInfo = new UserInfo();
		userInfo.setWxId("5");
		userInfo.setHeadImage("5");
		userInfo.setNickName("5");
		userInfo.setRegistTime(new Date());
		userInfo.setLastLoginTime(new Date());
		int userId = userInfoMapper.insertBackId(userInfo);
		System.out.println(userInfo.getUserId());
		System.out.println("userId:"+userId);
	}
}
