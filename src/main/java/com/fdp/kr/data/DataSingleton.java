package com.fdp.kr.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.datamodel.Vote;

public class DataSingleton {
	private Map<String, Question> questionsMap;  //QuestionId to question
	private Map<String, String> answerToQuestionMap; // AnswerId to questionId
	private Map<String, String> voteToAnswerMap; //voteId to AnswerId;
	private Map<String, Answer> answersMap; //AnswerId to answer;
	private Map<String, Vote> voteMap; //voteId to vote
	private Map<String,List<String>> userToQuestionMap;
	private Map<String, List<String>> tagToQuestionMap;
	private Map<String, User> userMap;
	private Map<String,Tag> tagsMap;
	private int questionSequence;
	private int answerSequence;
	private int voteSequence;
	private int tagSequence;
	private int userSequence;
	
	public static DataSingleton dataSingleton;
	
	public DataSingleton(){
		questionsMap = new HashMap<String, Question>();
		answersMap = new HashMap<>();
		answerToQuestionMap = new HashMap<>();
		voteToAnswerMap = new HashMap<>();
		voteMap = new HashMap<>();
		userToQuestionMap = new HashMap<>();
		tagToQuestionMap = new HashMap<>();
		userMap = new HashMap<>();
		tagsMap = new HashMap<>();
		questionSequence = 0;
		answerSequence = 0;
		voteSequence = 0;
		userSequence = 0;
		tagSequence = 0;
	}
	
	public static DataSingleton getDataObject(){
		if(dataSingleton == null){
			dataSingleton = new DataSingleton();
		}
		return dataSingleton;
	}

	public Map<String, Question> getQuestionsMap() {
		return questionsMap;
	}

	public void setQuestionsMap(Map<String, Question> questionsMap) {
		this.questionsMap = questionsMap;
	}

	public int getQuestionSequence() {
		return questionSequence;
	}

	public void setQuestionSequence(int questionSequence) {
		this.questionSequence = questionSequence;
	}

	public int getAnswerSequence() {
		return answerSequence;
	}

	public void setAnswerSequence(int answerSequence) {
		this.answerSequence = answerSequence;
	}

	public int getVoteSequence() {
		return voteSequence;
	}

	public void setVoteSequence(int voteSequence) {
		this.voteSequence = voteSequence;
	}

	public Map<String, String> getAnswerToQuestionMap() {
		return answerToQuestionMap;
	}

	public void setAnswerToQuestionMap(Map<String, String> answerToQuestionMap) {
		this.answerToQuestionMap = answerToQuestionMap;
	}

	public Map<String, String> getVoteToAnswerMap() {
		return voteToAnswerMap;
	}

	public void setVoteToAnswerMap(Map<String, String> voteToAnswerMap) {
		this.voteToAnswerMap = voteToAnswerMap;
	}

	public Map<String, Answer> getAnswersMap() {
		return answersMap;
	}

	public void setAnswersMap(Map<String, Answer> answersMap) {
		this.answersMap = answersMap;
	}

	public Map<String, Vote> getVoteMap() {
		return voteMap;
	}

	public void setVoteMap(Map<String, Vote> voteMap) {
		this.voteMap = voteMap;
	}

	public Map<String, List<String>> getUserToQuestionMap() {
		return userToQuestionMap;
	}

	public void setUserToQuestionMap(Map<String, List<String>> userToQuestionMap) {
		this.userToQuestionMap = userToQuestionMap;
	}

	public Map<String, List<String>> getTagToQuestionMap() {
		return tagToQuestionMap;
	}

	public void setTagToQuestionMap(Map<String, List<String>> tagToQuestionMap) {
		this.tagToQuestionMap = tagToQuestionMap;
	}

	public Map<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}

	public Map<String, Tag> getTagsMap() {
		return tagsMap;
	}

	public void setTagsMap(Map<String, Tag> tagsMap) {
		this.tagsMap = tagsMap;
	}

	public int getTagSequence() {
		return tagSequence;
	}

	public void setTagSequence(int tagSequence) {
		this.tagSequence = tagSequence;
	}

	public int getUserSequence() {
		return userSequence;
	}

	public void setUserSequence(int userSequence) {
		this.userSequence = userSequence;
	}
	
	
	
	
}
