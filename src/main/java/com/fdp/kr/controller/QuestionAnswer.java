package com.fdp.kr.controller;

import java.util.List;

import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;

public interface QuestionAnswer {
	public boolean postquestion(User user, String question, Tag tag);
	public boolean postanswer(Question question, String answer);
	public boolean voteanswer(Answer answer, String userId);
	public List<Question> listQuestions(User userId);
	public List<Question> listQuestions(Tag tag);
	public List<Question> listQuestions(String questionId);
	public List<Question> listQuestionsFromQuery(String query);
}
