package com.ninnana.bangumi_calendar.data;

import static com.ninnana.bangumi_calendar.utils.GetBangumi.get4Description;

public class BanBean
{
	public BanBean(String imageURL, String title, String content, int id)
	{
		this.imageURL = imageURL;
		this.title = title;
		this.content = content;
		if (imageURL == null) this.imageURL = "nai";
		else this.imageURL = imageURL.replaceFirst("http", "https");
		if (title == null) this.title = "";
		if (content.equals(""))
		{
			Description description = get4Description("https://api.bgm.tv/v0/subjects/{subject_id}", id);
			this.content = description == null ? "" : description.getSummary();
		}
		if (id == -1)
		{
			this.content = "$$ThisIsWeek$$";
		}
	}
	
	private String imageURL;
	private String title;
	private String content;
	
	public String getImageURL()
	{
		return imageURL;
	}
	
	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
