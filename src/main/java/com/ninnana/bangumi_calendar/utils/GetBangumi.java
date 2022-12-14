package com.ninnana.bangumi_calendar.utils;

import com.google.gson.Gson;
import com.ninnana.bangumi_calendar.data.Bangumi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetBangumi
{
	public static Bangumi[] getBangumi(final String API_URL)
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity;
		try
		{
			entity = restTemplate.getForEntity(API_URL, String.class);
		} catch (Exception ignored)
		{
			throw new RuntimeException("获取失败。w(ﾟДﾟ)w");
		}
		
		HttpStatus hs = entity.getStatusCode();
		if (hs.is2xxSuccessful())
		{
			String body = entity.getBody();
			
			Gson gson = new Gson();
			
			return gson.fromJson(body, Bangumi[].class);
		}
		return null;
	}
	
	
}
