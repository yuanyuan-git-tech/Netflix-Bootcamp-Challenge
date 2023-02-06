package com.company.Summative1YuanyuanZhao.controller;


import com.company.Summative1YuanyuanZhao.models.Answer;
import com.company.Summative1YuanyuanZhao.models.Definition;
import com.company.Summative1YuanyuanZhao.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ApiController {
    private List<Definition> wordList = new ArrayList<>();
    private List<Quote> quoteList = new ArrayList<>();
    private List<Answer> answerList = new ArrayList<>();
    private static int idCounterOfQuote = 1;
    private static int idCounterOfWord = 1;
    private static int idCounterOfAnswer = 1;

    public ApiController() {
        wordList.add(new Definition("Homework","schoolwork that a student is required to do at home.", idCounterOfWord++));
        wordList.add(new Definition("Student","a person who is studying at a school or college.", idCounterOfWord++));
        wordList.add(new Definition("Musician","a person who plays a musical instrument, especially as a profession, or is musically talented.", idCounterOfWord++));
        wordList.add(new Definition("Running","the action or movement of a runner.", idCounterOfWord++));
        wordList.add(new Definition("Boy","a male child or adolescent.", idCounterOfWord++));
        wordList.add(new Definition("Table","a piece of furniture with a flat top and one or more legs, providing a level surface on which objects may be placed, and that can be used for such purposes as eating, writing, working, or playing games.", idCounterOfWord++));
        wordList.add(new Definition("Girl","a female child or adolescent.", idCounterOfWord++));
        wordList.add(new Definition("Book","a written or printed work consisting of pages glued or sewn together along one side and bound in covers.", idCounterOfWord++));
        wordList.add(new Definition("Chair","a separate seat for one person, typically with a back and four legs.", idCounterOfWord++));
        wordList.add(new Definition("Biology","the study of living organisms, divided into many specialized fields that cover their morphology, physiology, anatomy, behavior, origin, and distribution.", idCounterOfWord++));


        quoteList.add(new Quote("Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall.", idCounterOfQuote++));
        quoteList.add(new Quote("Walt Disney", "The way to get started is to quit talking and begin doing.", idCounterOfQuote++));
        quoteList.add(new Quote("Steve Jobs", "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.", idCounterOfQuote++));
        quoteList.add(new Quote("Eleanor Roosevelt", "If life were predictable it would cease to be life, and be without flavor.", idCounterOfQuote++));
        quoteList.add(new Quote("Oprah Winfrey", "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.", idCounterOfQuote++));
        quoteList.add(new Quote("James Cameron", "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.", idCounterOfQuote++));
        quoteList.add(new Quote("John Lennon", "Life is what happens when you're busy making other plans.", idCounterOfQuote++));
        quoteList.add(new Quote("Mother Teresa", "Spread love everywhere you go. Let no one ever come to you without leaving happier.", idCounterOfQuote++));
        quoteList.add(new Quote("Franklin D. Roosevelt", "When you reach the end of your rope, tie a knot in it and hang on.", idCounterOfQuote++));
        quoteList.add(new Quote("Margaret Mead", "Always remember that you are absolutely unique. Just like everyone else.", idCounterOfQuote++));
        quoteList.add(new Quote("Robert Louis Stevenson", "Don't judge each day by the harvest you reap but by the seeds that you plant.", idCounterOfQuote++));


        answerList.add(new Answer("What are two things you can never eat for breakfast?", "Lunch and Dinner", idCounterOfAnswer++));
        answerList.add(new Answer("What is always coming but never arrives? ", "Tomorrow", idCounterOfAnswer++));
        answerList.add(new Answer("What gets wetter the more it dries? ", "A towel", idCounterOfAnswer++));
        answerList.add(new Answer("What can be broken but never held?", "A promise", idCounterOfAnswer++));
        answerList.add(new Answer("What word is spelled incorrectly in every single dictionary?", "Incorrectly", idCounterOfAnswer++));
        answerList.add(new Answer("What is it that lives if it is fed, and dies if you give it a drink?", "Fire", idCounterOfAnswer++));
        answerList.add(new Answer("What never asks a question but gets answered all the time?", "Your cellphone", idCounterOfAnswer++));
        answerList.add(new Answer("What word would you use to describe a man who does not have all his fingers on one hand?", "Normal, because people usually have half their fingers on one hand.", idCounterOfAnswer++));
        answerList.add(new Answer("What goes up but never ever comes down?", "Your age", idCounterOfAnswer++));
        answerList.add(new Answer("What can one catch that is not thrown?", "A cold", idCounterOfAnswer++));
    }




    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        return quoteList.get(new Random().nextInt(quoteList.size()));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord() {
        return wordList.get(new Random().nextInt(wordList.size()));
    }


    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer postAnswer(@RequestBody Answer answer) {
        answer.setId(idCounterOfAnswer++);
        answerList.add(answer);
        return answer;
    }

}
