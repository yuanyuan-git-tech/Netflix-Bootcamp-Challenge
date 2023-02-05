package com.company.Summative1YuanyuanZhao.controller;

import com.company.Summative1YuanyuanZhao.controller.ApiController;
import com.company.Summative1YuanyuanZhao.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {


    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private List<Answer> answerList;

    @Before
    public void setUp() {

    }

    @Test
    public void getQuote() {

    }
    @Test
    public void getWord() {

    }
    @Test
    public void postAnswer() {

    }

}
