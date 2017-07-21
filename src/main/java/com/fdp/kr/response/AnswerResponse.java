package com.fdp.kr.response;

import java.util.List;

public class AnswerResponse {
	private String answerId;
	private String answerText;
	private List<VoteResponse> votes;
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public List<VoteResponse> getVotes() {
		return votes;
	}
	public void setVotes(List<VoteResponse> votes) {
		this.votes = votes;
	}
	
	
	

}
