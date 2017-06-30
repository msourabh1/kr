package com.fdp.kr.data;

import java.util.HashMap;
import java.util.Map;

import com.fdp.kr.datamodel.Question;

public class DataSingleton {
	private Map<String, Question> questionsMap;
	
	public static DataSingleton dataSingleton;
	
	public DataSingleton(){
		questionsMap = new HashMap<String, Question>();
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

	
	

}