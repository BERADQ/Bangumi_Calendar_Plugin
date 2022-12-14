package com.ninnana.bangumi_calendar.window;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.ninnana.bangumi_calendar.data.BanBean;
import com.ninnana.bangumi_calendar.data.Bangumi;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ninnana.bangumi_calendar.utils.GetBangumi.getBangumi;

public class BanFactory implements ToolWindowFactory
{
	
	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow)
	{
		Bangumi[] bangumi = getBangumi("https://api.bgm.tv/calendar");
		if (bangumi == null) throw new NullPointerException("bangumi获取失败");
		List<BanBean> banBeanList = new ArrayList<>();
		for (Bangumi bangumi1 : bangumi)
		{
			String wImage = "week";
			String wNameCn = bangumi1.getWeekday().getCn();
			String wSummary = "$$ThisIsWeek$$";
			banBeanList.add(new BanBean(wImage,wNameCn,wSummary));
			for (Bangumi.ItemsBean item : bangumi1.getItems())
			{
				String mImage = (item.getImages() == null) ? null : item.getImages().getMedium();
				String nameCn = Objects.equals(item.getName_cn(), "")? item.getName() : item.getName_cn();
				String summary = item.getSummary();
				banBeanList.add(new BanBean(mImage,nameCn,summary));
			}
		}
		BangumiWindow bangumiWindow = new BangumiWindow(project, toolWindow,banBeanList);
		ContentFactory factory = ContentFactory.SERVICE.getInstance();
		Content content = factory.createContent(bangumiWindow.getPanel1(), "", false);
		toolWindow.getContentManager().addContent(content);
		
		
	}
	
}
