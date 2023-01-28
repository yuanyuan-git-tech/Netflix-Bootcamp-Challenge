package com.company.chatterbook;


import com.company.chatterbook.models.ChatterPost;
import com.company.chatterbook.models.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ChatterbookApplicationTests {
	ChatterbookApplication chatterBookApplication;
	@BeforeEach
	public void setUp() {
		chatterBookApplication = new ChatterbookApplication();
		User luis = new User("Luis");
	}

	@Test
	public void getUserByNameTest() {
		assertEquals("Luis", chatterBookApplication.getUserByName("Luis").get(0).getName());
		assertThrows(RuntimeException.class, () -> {chatterBookApplication.getUserByName("Yuanyuan");});
		assertEquals("Sue", chatterBookApplication.getUserByName(null).get(1).getName());
	}
	@Test
	public void getChatterPostByNameTest() {
		assertEquals("Hey! This is my first post!", chatterBookApplication.getChatterPostsByUserName("Luis").get(0).getText());
		assertEquals("Anybody want to be friends?", chatterBookApplication.getChatterPostsByUserName("Luis").get(1).getText());
		assertThrows(RuntimeException.class, () -> {chatterBookApplication.getChatterPostsByUserName(null);});
	}
}
