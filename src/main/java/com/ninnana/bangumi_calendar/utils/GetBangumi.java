package com.ninnana.bangumi_calendar.utils;

import com.google.gson.Gson;
import com.ninnana.bangumi_calendar.data.Bangumi;
import com.ninnana.bangumi_calendar.data.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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
	
	public static Description get4Description(final String API_URI, int id)
	{
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new IErrorHandler());
		ResponseEntity<String> entity;
		
		RequestEntity<Void> requestEntity = RequestEntity.get(API_URI, id).header("User-Agent",
				"bgm247763991b82e9231", "a0acfda6f18444ed03a5ba4773958a63").build();
		entity = restTemplate.exchange(requestEntity, String.class);
		
		HttpStatus hs = entity.getStatusCode();
		if (hs.is2xxSuccessful())
		{
			String body = entity.getBody();
			
			Gson gson = new Gson();
			
			return gson.fromJson(body, Description.class);
		}
		return null;
	}
	
	private static class IErrorHandler implements ResponseErrorHandler
	{
		
		@Override
		public boolean hasError(ClientHttpResponse response) throws IOException
		{
			return false;
		}
		
		@Override
		public void handleError(ClientHttpResponse response) throws IOException
		{
		}
	}
}
