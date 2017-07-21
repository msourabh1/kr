package com.fdp.kr.external;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class ApiAI {
	public static String APIAI_ACCESS_TOKEN = "3b1db0140f83491583dda0f5587e77e3";

	public static List<String> getKeywords(String query) {
		List<String> keywords = new ArrayList<String>();
		AIConfiguration configuration = new AIConfiguration(APIAI_ACCESS_TOKEN);
		AIDataService dataService = new AIDataService(configuration);
		AIRequest request = new AIRequest(query);
		try {
			AIResponse response = dataService.request(request);
			if (response.getResult().getAction().equals("question")) {
				JsonArray jsonArray = response.getResult().getParameters().get("any").getAsJsonArray();
				for (int i = 0; i < jsonArray.size(); i++) {
					keywords.add(jsonArray.get(i).getAsString());
				}
			}
			return keywords;
		} catch (AIServiceException e) {
			e.printStackTrace();
		}
		return null;

	}
}
