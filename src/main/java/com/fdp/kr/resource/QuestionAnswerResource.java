package com.fdp.kr.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdp.kr.controller.QuestionAnswer;
import com.fdp.kr.controller.QuestionAnswerImpl;
import com.fdp.kr.datamodel.Answer;
import com.fdp.kr.datamodel.Question;
import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.request.PostAnswerRequest;
import com.fdp.kr.request.PostQuestionRequest;
import com.fdp.kr.request.VoteAnswerRequest;
import com.fdp.kr.response.QuestionResponse;

@Path("/qa")
public class QuestionAnswerResource {
	
	QuestionAnswer questionAnswer;
	
	public  QuestionAnswerResource() {
		questionAnswer = new QuestionAnswerImpl();
	}


	@POST
	@Path("/question")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postQuestion(PostQuestionRequest postQuestionRequest){
		User user = new User();
		user.setUserId(postQuestionRequest.getUserId());
		Tag tag = new Tag();
		tag.setTagId(postQuestionRequest.getTag());
		questionAnswer.postquestion(user, 
				postQuestionRequest.getQuestionText(), tag);
		return Response.status(200).entity("Success").build();

	}
	

	@POST
	@Path("/answer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAnswer(PostAnswerRequest postAnswerRequest){
		Question question = new Question();
		question.setQuestionId(postAnswerRequest.getQuestionId());
		questionAnswer.postanswer(question, postAnswerRequest.getAnswerText(), 
				postAnswerRequest.getUserId());
		return Response.status(200).entity("Success").build();
	}

	@GET
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionResponse> getQuestionsByUserId(@PathParam("userId") String userId){
		User user = new User();
		user.setUserId(userId);
		return questionAnswer.listQuestions(user);
	}

	@GET
	@Path("/tag/{tagId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionResponse> getQuestionByTagId(@PathParam("tagId") String tagId){
		Tag tag = new Tag();
		tag.setTagId(tagId);
		return questionAnswer.listQuestions(tag);
	}
	
	@POST
	@Path("/vote")
	@Consumes
	public Response voteAnswer(VoteAnswerRequest voteAnswerRequest){
		Answer answer = new Answer();
		answer.setAnswerId(voteAnswerRequest.getAnswerId());
		questionAnswer.voteanswer(answer, voteAnswerRequest.getUserId());
		return Response.status(200).entity("Success").build();
	}
	
	@GET
	@Path("/query/{queryString}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionResponse> getQuestionByQueryString(@PathParam("queryString") String query){
		return questionAnswer.listQuestionsFromQuery(query);
	}
}
