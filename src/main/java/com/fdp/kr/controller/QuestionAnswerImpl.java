package com.fdp.kr.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fdp.kr.data.DataSingleton;
import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.datamodel.Vote;
import com.fdp.kr.external.ApiAI;
import com.fdp.kr.response.QuestionResponse;
import com.fdp.kr.response.ResponseUtils;

public class QuestionAnswerImpl implements QuestionAnswer{
	

	public boolean postquestion(User user, String questionString, Tag tag) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Question question = new Question();
		question.setQuestionText(questionString);
		question.setAnswers(new ArrayList<>());
		question.setTag(tag);
		question.setQuestionId("q:"+String.valueOf(dataSingleton.getQuestionSequence()));
		dataSingleton.setQuestionSequence(dataSingleton.getQuestionSequence() + 1);
		dataSingleton.getQuestionsMap().put(question.getQuestionId(), question);
		if(dataSingleton.getUserToQuestionMap().get(user.getUserId())!=null){
			dataSingleton.getUserToQuestionMap().get(user.getUserId()).add(question.getQuestionId());
		}
		else{
			List<String> questions = new ArrayList<String>();
			questions.add(question.getQuestionId());
			dataSingleton.getUserToQuestionMap().put(user.getUserId(), questions);
		}
		if(dataSingleton.getTagToQuestionMap().get(tag.getTagId())!=null){
			dataSingleton.getTagToQuestionMap().get(tag.getTagId()).add(question.getQuestionId());
		}
		else{
			List<String> questions = new ArrayList<String>();
			questions.add(question.getQuestionId());
			dataSingleton.getTagToQuestionMap().put(tag.getTagId(), questions);
		}
		return true;
	}

	public boolean postanswer(Question question, String answerText, String userId) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Answer answer = new Answer();
		answer.setAnswer(answerText);
		answer.setUserId(userId);
		answer.setVotes(new ArrayList<>());
		String answerId = ("a:"+String.valueOf(dataSingleton.getAnswerSequence()));
		answer.setAnswerId(answerId);
		dataSingleton.setAnswerSequence(dataSingleton.getAnswerSequence() + 1);
		List<String> answers = question.getAnswers();
		if (answers == null){
			answers = new ArrayList<>();
		}
		answers.add(answerId);
		dataSingleton.getQuestionsMap().get(question.getQuestionId()).getAnswers().add(answerId);
		dataSingleton.getAnswersMap().put(answerId, answer);
		dataSingleton.getAnswerToQuestionMap().put(answerId, question.getQuestionId());
		return true;
	}

	public boolean voteanswer(Answer answer, String userId) {
		//Loop through all questions - Find this answerId add vote to it
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Vote vote = new Vote();
		String voteId = "v"+String.valueOf(dataSingleton.getVoteSequence());
		dataSingleton.setVoteSequence(dataSingleton.getVoteSequence() + 1);

		vote.setVoteId(voteId);
		User user = new User();
		user.setUserId(userId);
		vote.setUser(user);
		dataSingleton.getVoteMap().put(voteId, vote);
		dataSingleton.getAnswersMap().get(answer.getAnswerId()).getVotes().add(vote);
		dataSingleton.getVoteToAnswerMap().put(voteId, answer.getAnswerId());
		return true;
	}

	public List<QuestionResponse> listQuestions(User user) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		List<String> questionIds = dataSingleton.getUserToQuestionMap().get(user.getUserId());
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>();
		for (String questionId : questionIds){
			questionResponses.add(ResponseUtils.getQuestionResponse(questionId));
		}
		return questionResponses;
	}

	public List<QuestionResponse> listQuestions(Tag tag) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		List<String> questionIds = dataSingleton.getTagToQuestionMap().get(tag.getTagId());
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>();
		for (String questionId : questionIds){
			questionResponses.add(ResponseUtils.getQuestionResponse(questionId));
		}
		return questionResponses;
	}

	public QuestionResponse listQuestions(String questionId) {
		return ResponseUtils.getQuestionResponse(questionId);
	}

	public List<QuestionResponse> listQuestionsFromQuery(String query) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Map<String, Integer> questionRelevanceMap = new HashMap<String, Integer>();
		List<String> keywords = ApiAI.getKeywords(query);
		List<String> derivedKeywords = new ArrayList<>();
		for (String keyword : keywords){
			if (keyword.split(" ").length > 0)
					derivedKeywords.addAll(Arrays.asList(keyword.split(" ")));
		}
		keywords.addAll(derivedKeywords);
		for(String questionId : dataSingleton.getQuestionsMap().keySet()){
			int questionRelevance = 0;
			for (String keyword : keywords){
				if (dataSingleton.getQuestionsMap().get(questionId).getQuestionText().toLowerCase().contains(keyword.toLowerCase())){
					questionRelevance = questionRelevance + 1;
				}
			}
			if(questionRelevance > 0)
			questionRelevanceMap.put(questionId, questionRelevance);
		}
		ValueComparator bvc = new ValueComparator(questionRelevanceMap);
		TreeMap<String, Integer> sortedQuestionRelevanceMap = new TreeMap<String,Integer>(bvc);
		sortedQuestionRelevanceMap.putAll(questionRelevanceMap);
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>();
		for(String questionId : sortedQuestionRelevanceMap.keySet()){
			questionResponses.add(ResponseUtils.getQuestionResponse(questionId));
		}
		return questionResponses;
	}
	
	private class ValueComparator implements Comparator<String> {
	    Map<String, Integer> base;

	    public ValueComparator(Map<String, Integer> base) {
	        this.base = base;
	    }
	    
	    public int compare(String a, String b) {
	        if (base.get(a) >= base.get(b)) {
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}

	

}
