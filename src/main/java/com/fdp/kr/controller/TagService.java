package com.fdp.kr.controller;

import java.util.List;

import com.fdp.kr.datamodel.Tag;

public interface TagService {
	public String createTag(String tag);
	public List<Tag> getAllTags();
}
