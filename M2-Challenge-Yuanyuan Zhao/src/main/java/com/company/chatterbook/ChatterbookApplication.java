package com.company.chatterbook;

import com.company.chatterbook.controller.ChatterbookController;
import com.company.chatterbook.models.ChatterPost;
import com.company.chatterbook.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ChatterbookApplication {
	ChatterbookController chatterBookController = new ChatterbookController();
	public static void main(String[] args) {
		SpringApplication.run(ChatterbookApplication.class, args);
	}
	public List<User> getUserByName(String name) {
		return chatterBookController.getUserByName(name);
	}
	public List<ChatterPost> getChatterPostsByUserName(String name) {
		return chatterBookController.getChatterPostsByUserName(name);
	}

}
