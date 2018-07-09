package answer.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.dao.QuestionMapper;
import com.cy.answer.model.Question;

public class QuestionTest extends BaseJunit4Test{

	@Autowired
	private QuestionMapper questionMapper;
	
	@Test
	public void testCount() {
		int count = questionMapper.countByExample(null);
		
		for(int i = 0; i < 10; i++) {
			Question question = questionMapper.randomOneQuestion();
			System.out.println(question);
		}
		
		System.out.println(count);
	}
}
