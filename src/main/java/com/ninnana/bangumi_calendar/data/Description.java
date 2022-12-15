package com.ninnana.bangumi_calendar.data;

import java.util.List;

public class Description
{
	
	private int id;
	private int type;
	private String name;
	private String name_cn;
	private String summary;
	private boolean nsfw;
	private boolean locked;
	private String date;
	private String platform;
	private List<TagsBean> tags;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName_cn()
	{
		return name_cn;
	}
	
	public void setName_cn(String name_cn)
	{
		this.name_cn = name_cn;
	}
	
	public String getSummary()
	{
		return summary;
	}
	
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	
	public boolean isNsfw()
	{
		return nsfw;
	}
	
	public void setNsfw(boolean nsfw)
	{
		this.nsfw = nsfw;
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getPlatform()
	{
		return platform;
	}
	
	public void setPlatform(String platform)
	{
		this.platform = platform;
	}
	
	public List<TagsBean> getTags()
	{
		return tags;
	}
	
	public void setTags(List<TagsBean> tags)
	{
		this.tags = tags;
	}
	
	public static class TagsBean
	{
		private String name;
		private int count;
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public int getCount()
		{
			return count;
		}
		
		public void setCount(int count)
		{
			this.count = count;
		}
	}
}
