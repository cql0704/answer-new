package answer.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.dao.QuestionDao;
import com.cy.answer.exception.BizException;
import com.cy.answer.service.QuestionService;

public class QuestionTest extends BaseJunit4Test{

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	public void testCount() {
		
		try {
			questionService.addQuestion("content", "answer", null , "opt");
			System.out.println("ok");
		} catch (BizException e) {
			
			e.printStackTrace();
		}
		
	}
}
