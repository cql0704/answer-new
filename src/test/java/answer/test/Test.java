package answer.test;

import com.cy.answer.utils.StringUtil;

public class Test {
	public static void main(String[] args) {
		
		System.out.println( StringUtil.isEmpty(null) );
		
		System.out.println( StringUtil.isEmpty("") );
		
		System.out.println( StringUtil.isEmpty(" ") );
		
		System.out.println( StringUtil.isEmpty(""," ") );
	}
}
