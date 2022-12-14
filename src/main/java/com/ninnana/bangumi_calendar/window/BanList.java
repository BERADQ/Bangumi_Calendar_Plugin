package com.ninnana.bangumi_calendar.window;


import com.intellij.ui.JBColor;
import com.intellij.ui.paint.PaintUtil;
import com.intellij.util.ui.UIUtil;
import com.ninnana.bangumi_calendar.data.BanBean;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BanList extends JPanel
{
	private HashMap<BanBean, Image> image = new HashMap<>();
	private Rectangle imageRect;
	private Graphics2D g2d;
	
	private int splitWidth = 2;
	
	public void setTheHeight(int componentWidth)
	{
		this.componentWidth = componentWidth;
		imageRect = new Rectangle(componentWidth, (int) (componentWidth / ab));
	}
	
	private int componentWidth;
	
	public void setFontTit(InputStream fontTit)
	{
		
		try
		{
			deriveFontTit = Font.createFont(Font.TRUETYPE_FONT, fontTit).deriveFont(25.0F);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public void setWeekFontTit(InputStream fontTit)
	{
		
		try
		{
			weekFontTit = Font.createFont(Font.TRUETYPE_FONT, fontTit).deriveFont(53.0F);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public void setFontTex(InputStream fontTex)
	{
		
		try
		{
			deriveFontTex = Font.createFont(Font.TRUETYPE_FONT, fontTex).deriveFont(14.0F);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	private Font deriveFontTit;
	private Font weekFontTit;
	private Font deriveFontTex;
	List<BanBean> theBanBeans;
	
	private double ab;
	
	public BanList(List<BanBean> banBean)
	{
		theBanBeans = banBean;
		URL url;
		for (BanBean bean : theBanBeans)
		{
			if (bean == null) continue;
			if (bean.getImageURL().equals("nai"))
			{
				try
				{
					image.put(bean, ImageIO.read(this.getClass().getResourceAsStream("/iicon/deim.jpg")));
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				continue;
			}
			if (bean.getImageURL().equals("week"))
			{
				try
				{
					image.put(bean, ImageIO.read(this.getClass().getResourceAsStream("/iicon/week.png")));
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				continue;
			}
			try
			{
				url = new URL(bean.getImageURL());
				image.put(bean, ImageIO.read(url.openStream()));
			} catch (Exception e)
			{
				throw new RuntimeException(e);
			}
			
		}
		InputStream titTile = this.getClass().getResourceAsStream("/fonts/SmileySans-Oblique.ttf");
		setFontTit(titTile);
		InputStream texTile = this.getClass().getResourceAsStream("/fonts/SFMonoSC-Regular.ttf");
		setFontTex(texTile);
		InputStream weekTile = this.getClass().getResourceAsStream("/fonts/SmileySans-Oblique.ttf");
		setWeekFontTit(weekTile);
		Image firstImage = image.get(theBanBeans.get(1));
		this.componentWidth = firstImage.getWidth(null);
		i = getTheHeight();
		cushioning = UIUtil.createImage(getGraphicsConfiguration(), 1080, i,
				BufferedImage.TYPE_INT_ARGB,
				PaintUtil.RoundingMode.CEIL);
		g2d = (Graphics2D) cushioning.getGraphics();
		this.addComponentListener(new whenCh());
		this.setMinimumSize(new Dimension(componentWidth + 64, i));
		this.setMaximumSize(new Dimension(1080, -1));
	}
	
	private int getTheHeight()
	{
		int n = 0;
		for (BanBean theBanBean : theBanBeans)
		{
			if (theBanBean.getContent().equals("$$ThisIsWeek$$"))
			{
				n += 64;
			} else
			{
				Image temp1Image = image.get(theBanBean);
				ab = (double) temp1Image.getWidth(null) / (double) temp1Image.getHeight(null);
				imageRect = new Rectangle(componentWidth, (int) (componentWidth / ab));
				
				n += imageRect.getHeight();
			}
			n += splitWidth;
		}
		return n;
	}
	
	private class whenCh implements ComponentListener
	{
		
		@Override
		public void componentResized(ComponentEvent e)
		{
			i = 0;
			g2d.setBackground(JBColor.WHITE);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			for (BanBean bean : theBanBeans)
			{
				Image temp1Image = image.get(bean);
				ab = (double) temp1Image.getWidth(null) / (double) temp1Image.getHeight(null);
				imageRect = new Rectangle(componentWidth, (int) (componentWidth / ab));
				int width = Math.min(getWidth(), 1080);
				int height = getHeight();
				if (bean.getContent().equals("$$ThisIsWeek$$"))
				{
					g2d.drawImage(temp1Image, 0, i, 64, 64, null);
					g2d.setFont(weekFontTit);
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2d.drawString(
							blockOverLength(bean.getTitle(), width - 64, g2d, weekFontTit),
							64,
							32 + (g2d.getFontMetrics(weekFontTit).getAscent() -
									g2d.getFontMetrics(weekFontTit).getDescent()) / 2 + i);
					i += 64;
					g2d.setColor(JBColor.BLACK);
					g2d.setStroke(new BasicStroke(splitWidth));
					g2d.drawLine(0, i, getWidth(), i);
					i += splitWidth;
					continue;
				}
				g2d.drawImage(temp1Image, 0, i, (int) imageRect.getWidth(), (int) imageRect.getHeight(), null);
				g2d.setFont(deriveFontTit);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawString(
						blockOverLength(bean.getTitle(), (int) (width - imageRect.getWidth()) - 2, g2d, deriveFontTit),
						(int) imageRect.getWidth() + 5, 27 + i);
				g2d.setFont(deriveFontTex);
				if (imageRect.getHeight() > 27 + 14)
					lineWrappingStrings(bean.getContent(),
							g2d, deriveFontTex, (int) (width - imageRect.getWidth()) - 2, (int) imageRect.getWidth(),
							44 + i,
							14, (int) imageRect.getHeight() - 42);
				i += imageRect.getHeight();
				g2d.setColor(JBColor.BLACK);
				g2d.setStroke(new BasicStroke(splitWidth));
				g2d.drawLine(0, i, getWidth(), i);
				i += splitWidth;
			}
			
		}
		
		@Override
		public void componentMoved(ComponentEvent e)
		{
		
		}
		
		@Override
		public void componentShown(ComponentEvent e)
		{
		
		}
		
		@Override
		public void componentHidden(ComponentEvent e)
		{
		
		}
	}
	
	private Dimension miniSize = null;
	private final Image cushioning;
	private int i;
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		g.drawImage(cushioning, 0, 0, null);
		
		if (miniSize == null)
		{
			miniSize = new Dimension(-1, i);
			this.setPreferredSize(miniSize);
		}
	}
	
	private int getStringWidth(Graphics g, Font font, String s)
	{
		AtomicInteger tempInt = new AtomicInteger();
		s.chars().forEach(cha -> {
			tempInt.addAndGet(g.getFontMetrics(font).charWidth(cha));
		});
		return tempInt.get() + (g.getFontMetrics(font).charWidth(s.charAt(s.length() - 1))
				+ g.getFontMetrics(font).charWidth('|'));
	}
	
	private void lineWrappingStrings(String s, Graphics g, Font font, int regionWidth, int x, int y, int lineHeight,
	                                 int maxHeight)
	{
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (char aChar : chars)
		{
			sb.append(aChar);
			String s1 = sb.toString();
			int stringWidth = getStringWidth(g, font, s1);
			if (stringWidth > regionWidth)
			{
				maxHeight -= lineHeight;
				if (maxHeight < lineHeight && sb.length() > 3)
				{
					sb.setLength(sb.length() - 2);
					sb.append("……");
					break;
				}
				g.drawString(s1, x, y);
				y += lineHeight;
				sb.setLength(0);
			}
		}
		g.drawString(sb.toString(), x, y);
	}
	
	private String blockOverLength(String s, int maxWidth, Graphics g, Font font)
	{
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray())
		{
			maxWidth -= g.getFontMetrics(font).charWidth(c);
			if (maxWidth < 0 && sb.length() > 0)
			{
				sb.setLength(sb.length() - 1);
				sb.append("…");
				break;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	
}
