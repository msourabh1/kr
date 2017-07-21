package com.fdp.kr.controller;

import java.util.List;

import com.fdp.kr.data.DataSingleton;
import com.fdp.kr.datamodel.Tag;

public class TagServiceImpl implements TagService{

	public String createTag(String tagString) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		Tag tag = new Tag();
		String tagId = "t:"+String.valueOf(dataSingleton.getTagSequence());
		tag.setTagId(tagId);
		dataSingleton.setTagSequence(dataSingleton.getTagSequence() + 1);
		tag.setTagString(tagString);
		dataSingleton.getTagsMap().put(tag.getTagId(), tag);
		return tagId;
	}

	public List<Tag> getAllTags() {
		return null;
	}

}
