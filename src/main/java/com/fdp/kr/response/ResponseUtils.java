package com.fdp.kr.response;

import java.util.ArrayList;
import java.util.List;

import com.fdp.kr.data.DataSingleton;
import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.datamodel.Vote;

public class ResponseUtils {
	
	public static QuestionResponse getQuestionResponse(String questionId){
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Question question = dataSingleton.getQuestionsMap().get(questionId);
		QuestionResponse questionResponse = new QuestionResponse();
		questionResponse.setQuestionId(questionId);
		questionResponse.setQuestionText(question.getQuestionText());
		List<AnswerResponse> answerResponses = new ArrayList<AnswerResponse>();
		for(String answerId : question.getAnswers()){
			answerResponses.add(getAnswerResponse(answerId));
		}
		questionResponse.setAnswers(answerResponses);
		return questionResponse;
	}
	
	public static AnswerResponse getAnswerResponse(String answerId){
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Answer answer = dataSingleton.getAnswersMap().get(answerId);
		AnswerResponse answerResponse = new AnswerResponse();
		answerResponse.setAnswerId(answerId);
		answerResponse.setAnswerText(answer.getAnswer());
		List<VoteResponse> voteResponses = new ArrayList<VoteResponse>();
		for(Vote vote: answer.getVotes()){
			voteResponses.add(getVoteResponse(vote.getVoteId()));
		}
		answerResponse.setVotes(voteResponses);
		return answerResponse;
	}
	
	public static VoteResponse getVoteResponse(String voteId){
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Vote vote = dataSingleton.getVoteMap().get(voteId);
		VoteResponse voteResponse = new VoteResponse();
		voteResponse.setVoteId(vote.getVoteId());
		voteResponse.setUser(getUserResponse(vote.getUser().getUserId()));
		return voteResponse;
	}
	
	public static UserResponse getUserResponse(String userId){
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		User user = dataSingleton.getUserMap().get(userId);
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstname(user.getFirstname());
		userResponse.setLastname(user.getLastname());
		userResponse.setUserId(user.getUserId());
		userResponse.setTags(user.getTags());
		return userResponse;
	}

}
