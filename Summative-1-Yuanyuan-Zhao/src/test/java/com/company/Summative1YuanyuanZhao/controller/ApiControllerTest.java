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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.http.MediaType;


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


    @Test
    public void getQuote() throws Exception {
        mockMvc.perform(get("/quote")).andExpect(status().isOk());
    }
    @Test
    public void getWord() throws Exception {
        mockMvc.perform(get("/word")).andExpect(status().isOk());
    }
    @Test
    public void postAnswer() throws Exception {
        // ARRANGE
        Answer inputAnswer = new Answer();
        inputAnswer.setAnswer("I am good.");
        inputAnswer.setQuestion("How are you?");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);
        mockMvc.perform(
                post("/magic")
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                // Print results to console
                .andExpect(status().isCreated());        // ASSERT (status code is 201)
    }

}
