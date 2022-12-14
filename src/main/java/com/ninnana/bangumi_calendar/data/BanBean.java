package com.ninnana.bangumi_calendar.data;

public class BanBean
{
	public BanBean(String imageURL, String title, String content)
	{
		this.imageURL = imageURL;
		this.title = title;
		this.content = content;
		if (imageURL == null) this.imageURL = "nai";
		else this.imageURL = imageURL.replaceFirst("http","https");
		if (title == null) this.title = "";
		if (content.equals("")) this.content = "你说的对，但是IDEA 全称 IntelliJ IDEA，是java编程语言的集成开发环境。IntelliJ在业界被公认为最好的Java" +
				"开发工具，尤其在智能代码助手、代码自动提示、重构、JavaEE支持、各类版本工具(git、svn等)、JUnit、CVS整合、代码分析、 创新的GUI设计等方面的功能可以说是超常的。IDEA是JetBrains公司的产品，这家公司总部位于捷克共和国的首都布拉格，开发人员以严谨著称的东欧程序员为主。它的旗舰版还支持HTML，CSS，PHP，MySQL，Python等。免费版只支持Java,Kotlin等少数语言。";
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
