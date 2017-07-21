package com.fdp.kr.response;

import java.util.List;

public class QuestionResponse {
	private String questionId;
	private String questionText;
	private List<AnswerResponse> answers;
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<AnswerResponse> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerResponse> answers) {
		this.answers = answers;
	}
}
