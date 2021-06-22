package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PersonDAO;
import dto.Person;

class PersonTest {
	int size = 0;
	
	@BeforeEach
	void setUp() throws Exception {
		size = PersonDAO.getInstance().selectPersonList().size();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//assertEquals(5, size, "등록된 사람은 5명이 아니다.");
		//123456 주민번호 검색
		assertNotNull(PersonDAO.getInstance().selectPersonBySno("123456"), "123456 주민번호는 없다.");
	}

}
