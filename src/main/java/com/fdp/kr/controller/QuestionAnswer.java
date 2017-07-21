package com.fdp.kr.controller;

import java.util.List;

import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.response.QuestionResponse;

public interface QuestionAnswer {
	public boolean postquestion(User user, String question, Tag tag);
	public boolean postanswer(Question question, String answer, String userId);
	public boolean voteanswer(Answer answer, String userId);
	public List<QuestionResponse> listQuestions(User userId);
	public List<QuestionResponse> listQuestions(Tag tag);
	public QuestionResponse listQuestions(String questionId);
	public List<QuestionResponse> listQuestionsFromQuery(String query);
}
