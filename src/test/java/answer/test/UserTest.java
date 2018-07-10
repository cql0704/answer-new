package answer.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.controller.UserInfoController;
import com.cy.answer.dao.UserInfoMapper;
import com.cy.answer.model.ResultModel;

public class UserTest extends BaseJunit4Test{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserInfoController userInfoController;
	
	@Test
	public void testSave() {
		ResultModel resultModel = userInfoController.saveOrUpdateUser("5", "5", "5");
		System.out.println(resultModel);
	}
}
