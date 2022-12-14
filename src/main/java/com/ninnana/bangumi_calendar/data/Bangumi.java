package com.ninnana.bangumi_calendar.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Bangumi
{
	
	private WeekdayBean weekday;
	private List<ItemsBean> items;
	
	public WeekdayBean getWeekday()
	{
		return weekday;
	}
	
	public void setWeekday(WeekdayBean weekday)
	{
		this.weekday = weekday;
	}
	
	public List<ItemsBean> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemsBean> items)
	{
		this.items = items;
	}
	
	public static class WeekdayBean
	{
		private String en;
		private String cn;
		private String ja;
		private int id;
		
		public String getEn()
		{
			return en;
		}
		
		public void setEn(String en)
		{
			this.en = en;
		}
		
		public String getCn()
		{
			return cn;
		}
		
		public void setCn(String cn)
		{
			this.cn = cn;
		}
		
		public String getJa()
		{
			return ja;
		}
		
		public void setJa(String ja)
		{
			this.ja = ja;
		}
		
		public int getId()
		{
			return id;
		}
		
		public void setId(int id)
		{
			this.id = id;
		}
	}
	
	public static class ItemsBean
	{
		private int id;
		private String url;
		private int type;
		private String name;
		private String name_cn;
		private String summary;
		private String air_date;
		private int air_weekday;
		private RatingBean rating;
		private int rank;
		private ImagesBean images;
		private CollectionBean collection;
		
		public int getId()
		{
			return id;
		}
		
		public void setId(int id)
		{
			this.id = id;
		}
		
		public String getUrl()
		{
			return url;
		}
		
		public void setUrl(String url)
		{
			this.url = url;
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
		
		public String getAir_date()
		{
			return air_date;
		}
		
		public void setAir_date(String air_date)
		{
			this.air_date = air_date;
		}
		
		public int getAir_weekday()
		{
			return air_weekday;
		}
		
		public void setAir_weekday(int air_weekday)
		{
			this.air_weekday = air_weekday;
		}
		
		public RatingBean getRating()
		{
			return rating;
		}
		
		public void setRating(RatingBean rating)
		{
			this.rating = rating;
		}
		
		public int getRank()
		{
			return rank;
		}
		
		public void setRank(int rank)
		{
			this.rank = rank;
		}
		
		public ImagesBean getImages()
		{
			return images;
		}
		
		public void setImages(ImagesBean images)
		{
			this.images = images;
		}
		
		public CollectionBean getCollection()
		{
			return collection;
		}
		
		public void setCollection(CollectionBean collection)
		{
			this.collection = collection;
		}
		
		public static class RatingBean
		{
			private int total;
			private CountBean count;
			private double score;
			
			public int getTotal()
			{
				return total;
			}
			
			public void setTotal(int total)
			{
				this.total = total;
			}
			
			public CountBean getCount()
			{
				return count;
			}
			
			public void setCount(CountBean count)
			{
				this.count = count;
			}
			
			public double getScore()
			{
				return score;
			}
			
			public void setScore(double score)
			{
				this.score = score;
			}
			
			public static class CountBean
			{
				@SerializedName("10")
				private int _$10;
				@SerializedName("9")
				private int _$9;
				@SerializedName("8")
				private int _$8;
				@SerializedName("7")
				private int _$7;
				@SerializedName("6")
				private int _$6;
				@SerializedName("5")
				private int _$5;
				@SerializedName("4")
				private int _$4;
				@SerializedName("3")
				private int _$3;
				@SerializedName("2")
				private int _$2;
				@SerializedName("1")
				private int _$1;
				
				public int get_$10()
				{
					return _$10;
				}
				
				public void set_$10(int _$10)
				{
					this._$10 = _$10;
				}
				
				public int get_$9()
				{
					return _$9;
				}
				
				public void set_$9(int _$9)
				{
					this._$9 = _$9;
				}
				
				public int get_$8()
				{
					return _$8;
				}
				
				public void set_$8(int _$8)
				{
					this._$8 = _$8;
				}
				
				public int get_$7()
				{
					return _$7;
				}
				
				public void set_$7(int _$7)
				{
					this._$7 = _$7;
				}
				
				public int get_$6()
				{
					return _$6;
				}
				
				public void set_$6(int _$6)
				{
					this._$6 = _$6;
				}
				
				public int get_$5()
				{
					return _$5;
				}
				
				public void set_$5(int _$5)
				{
					this._$5 = _$5;
				}
				
				public int get_$4()
				{
					return _$4;
				}
				
				public void set_$4(int _$4)
				{
					this._$4 = _$4;
				}
				
				public int get_$3()
				{
					return _$3;
				}
				
				public void set_$3(int _$3)
				{
					this._$3 = _$3;
				}
				
				public int get_$2()
				{
					return _$2;
				}
				
				public void set_$2(int _$2)
				{
					this._$2 = _$2;
				}
				
				public int get_$1()
				{
					return _$1;
				}
				
				public void set_$1(int _$1)
				{
					this._$1 = _$1;
				}
			}
		}
		
		public static class ImagesBean
		{
			private String large;
			private String common;
			private String medium;
			private String small;
			private String grid;
			
			public String getLarge()
			{
				return large;
			}
			
			public void setLarge(String large)
			{
				this.large = large;
			}
			
			public String getCommon()
			{
				return common;
			}
			
			public void setCommon(String common)
			{
				this.common = common;
			}
			
			public String getMedium()
			{
				return medium;
			}
			
			public void setMedium(String medium)
			{
				this.medium = medium;
			}
			
			public String getSmall()
			{
				return small;
			}
			
			public void setSmall(String small)
			{
				this.small = small;
			}
			
			public String getGrid()
			{
				return grid;
			}
			
			public void setGrid(String grid)
			{
				this.grid = grid;
			}
		}
		
		public static class CollectionBean
		{
			private int doing;
			
			public int getDoing()
			{
				return doing;
			}
			
			public void setDoing(int doing)
			{
				this.doing = doing;
			}
		}
		
	}
	
	public static String getStringFor(Bangumi[] bangumis)
	{
		StringBuilder sb = new StringBuilder();
		if (bangumis == null)
		{
			throw new NullPointerException("参数为空，无法转换。o(><；)oo");
		} else
		{
			sb.append("##################################################\n");
			for (Bangumi bangumi : bangumis)
			{
				sb.append(padRight("#" + bangumi.getWeekday().getCn() + ":", 49)).append("#\n");
				bangumi.getItems().forEach(item -> {
					String nameCn = item.getName_cn();
					String name = item.getName();
					sb.append(padRight("#    " + (Objects.equals(nameCn, "") ? name : nameCn), 49)).append("#\n");
				});
				sb.append("##################################################\n");
			}
		}
		return sb.toString();
	}
	
	private static String padRight(String s, int i)
	{
		
		if (s.length() < i)
		{
			int f = i - s.replaceAll("[^\\x00-\\xff]", "**").length();
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			for (int j = 0; j < f; j++)
			{
				sb.append(" ");
			}
			return sb.toString();
		}
		return s;
	}
	
}
