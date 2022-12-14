package com.ninnana.bangumi_calendar.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.ninnana.bangumi_calendar.data.BanBean;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.List;

public class BangumiWindow
{
	
	
	private JPanel panel1;
	private JScrollPane IPane;
	private BanList banList1;
	
	
	private List<BanBean> banBeanList;
	
	public BangumiWindow(@NotNull Project project, @NotNull ToolWindow toolWindow, List<BanBean> banBean)
	{
		this.banBeanList = banBean;
		
		IPane.getVerticalScrollBar().addAdjustmentListener(l -> banList1.updateUI());
	}
	
	private class mouseMo implements MouseMotionListener
	{
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			banList1.updateUI();
		}
		
		@Override
		public void mouseMoved(MouseEvent e)
		{
		}
	}
	
	public JPanel getPanel1()
	{
		return panel1;
	}
	
	
	public void setAlter(String sb)
	{
	}
	
	public void setAlter(File f)
	{
	}
	
	private void createUIComponents()
	{
		banList1 = new BanList(banBeanList);
	}
}
