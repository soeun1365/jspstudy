package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Calculator;

class CalculatorTest {

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("bofore");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	@DisplayName("1 + 1 = 2")	//@DisplayName("")으로 Junit view에서 확인가능
	void test() {	//메소드이름 test는 자유 @Test이것만 붙어있으면된다.
		
		Calculator calculator = new Calculator();
		//assertNull(calculator);		// assertNull() null인지 묻는것 (Null이면 통과/ Not Null 실패), 싱글톤인지 체크할때 쓰기도함, null이 아니기때문에 Failure Trace에서 주소값이 뜸
		assertNotNull(calculator);
		
		assertEquals(2, calculator.add(1, 1));	// assertEquals(기대한값, 실제값)	//기대한값 != 실제값 일때 Failure Trace출력됨
		assertEquals(3, calculator.add(1, 1), "1 + 1 = 2 이어야 한다.");
		
		System.out.println("test");		// assertNotNull() NotNull인지 묻는것 (Not Null이면 통과/ Null 실패)
		//fail("Not yet implemented");	// fail("") 강제로 fail만드는것으로 ()안에 문자열은 Failure Trace에 출력됨
		
		
/* 		사용예시) 삽입테스트, 삭제테스트, 조회테스트...
			if(DAO.getInstance().insert(person) == 0) {
					fail("삽입실패")
			}
*/
/* 		사용예시) 삽입 기대값, 실제값으로 테스트
		 	assertEquals(1, DAO.getInstance().insert(person), "삽입실패");
*/
	}

}
