package answer.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.dao.UserAnswerRecordMapper;
import com.cy.answer.model.UserAnswerRecord;

public class UserAnswerRecordTest extends BaseJunit4Test{
	
	@Autowired
	private UserAnswerRecordMapper userAnswerRecordMapper;
	
	@Test
	public void testRecord(){
		UserAnswerRecord userAnswerRecord = new UserAnswerRecord();
		userAnswerRecord.setUserId(1);
		userAnswerRecord.setUpdateTime(new Date());
		//userAnswerRecord.set
		userAnswerRecordMapper.insertSelective(userAnswerRecord);
		
	}
}
