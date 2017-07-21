package com.fdp.kr.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdp.kr.controller.TagService;
import com.fdp.kr.controller.TagServiceImpl;
import com.fdp.kr.request.CreateTagRequest;

@Path("/tag")
public class TagResource {
	private TagService tagService;
	
	public TagResource(){
		tagService = new TagServiceImpl();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registeUser(CreateTagRequest createTagRequest) {
		String tagId = tagService.createTag(createTagRequest.getTag());
		return Response.status(200).entity(tagId).build();

	}
}
