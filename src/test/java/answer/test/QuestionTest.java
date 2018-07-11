package answer.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.answer.dao.QuestionDao;

public class QuestionTest extends BaseJunit4Test{

	@Autowired
	private QuestionDao questionDao;
	
	@Test
	public void testCount() {

	}
}
