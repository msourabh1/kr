package com.fdp.kr.controller;

import java.util.List;

import com.fdp.kr.data.DataSingleton;
import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;

public class QuestionAnswerImpl implements QuestionAnswer{

	public boolean postquestion(User user, String questionString, Tag tag) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Question question = new Question();
		question.setQuestionText(questionString);
		question.setTag(tag);
		question.setQuestionId("q:"+String.valueOf(dataSingleton.getQuestionSequence()));
		dataSingleton.setQuestionSequence(dataSingleton.getQuestionSequence() + 1);
		dataSingleton.getQuestionsMap().put(user.getUserId(), question);
		return true;
	}

	public boolean postanswer(Question question, String answerText) {
		return false;
	}

	public boolean voteanswer(Answer answer, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Question> listQuestions(User userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> listQuestions(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> listQuestions(String questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> listQuestionsFromQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
