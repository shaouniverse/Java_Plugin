package jfreeTest;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.VerticalAlignment;
import org.jfree.data.category.DefaultCategoryDataset;

public class TestOne2 {
	public static void main(String[] args) throws IOException {
		/********设置全局的字体***********/
		{
			//创建主题样式  
	        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
	        //设置标题字体  
	        mChartTheme.setExtraLargeFont(new Font("微软雅黑", Font.PLAIN, 16));
	        //设置轴向字体  
	        mChartTheme.setLargeFont(new Font("微软雅黑", Font.PLAIN, 12));
	        //设置图例字体  
	        mChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 12));
	        //应用主题样式  
	        ChartFactory.setChartTheme(mChartTheme);
		}
		//DefaultCategoryDataset实现CategoryDataset接口
//		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		/*****放入数据*****/
		
			//对应左侧的折线图
			DefaultCategoryDataset lineLeftChartDataset = new DefaultCategoryDataset();
			String[] groupNames = { "微博", "微信", "新闻", "评论", "论坛" };
	        Random r = new Random();
	        for (String name : groupNames) {
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1940");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1950");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1960");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1970");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1980");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "1990");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "2000");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "2010");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "2020");
	        	lineLeftChartDataset.addValue(r.nextInt(300), name, "2030");
	        }
		
	        DefaultCategoryDataset lineRightChartDataset = new DefaultCategoryDataset();
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1940");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1950");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1960");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1970");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1980");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "1990");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "2000");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "2010");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "2020");
	        lineRightChartDataset.addValue(r.nextInt(1000), "视频", "2030");
		
		//创建折线图
		//createLineChart dataset类型为CategoryDataset代表数据集
		//ChartFactory.createLineChart("图表标题", "x轴(类别)标签", "Y(值)轴标签", defaultCategoryDataset);
		//orientation取向	PlotOrientation.VERTICAL垂直
		//					PlotOrientation.HORIZONTAL水平
		//legend图例
		boolean legend = true;
		//tooltips 工具提示配置图表以生成工具提示
		boolean tooltips = true;
		//urls urls配置图表生成URL
		boolean urls = true;
		JFreeChart createLineChart = ChartFactory.createLineChart("图表标题", "x轴(类别)标签", "Y(值)轴标签", lineLeftChartDataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		//createXYLineChart   dataset类型为XYDataset
		//ChartFactory.createXYLineChart("图表标题", "x轴标签", "Y轴标签", dataset)
		//ChartFactory.createXYLineChart("图表标题", "x轴标签", "Y轴标签", dataset, orientation, legend, tooltips, urls)
		
		//设置文本是否抗锯齿
		createLineChart.setTextAntiAlias(true);
		
		
//		Font textFont = new Font("微软雅黑", Font.PLAIN, 12);
//		TextTitle textTitle = createLineChart.getTitle();
//		textTitle.setFont(textFont);// 为标题设置上字体
		
		/*****图表区样式*****/
		{
		//获得图表对象
		CategoryPlot categoryPlot = createLineChart.getCategoryPlot();
		// 图表区域背景色
		categoryPlot.setBackgroundPaint(ChartColor.WHITE);
		// 设置表格线颜色及样式 - 横线
		categoryPlot.setRangeGridlinePaint(ChartColor.GRAY);
		// 隐藏边框
		categoryPlot.setOutlineVisible(false);
		
		LineAndShapeRenderer renderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
		renderer.setDefaultShapesVisible(true);
        renderer.setUseFillPaint(true);
//		categoryPlot.setRangeGridlinesVisible(false);
			/*******设置x y 右侧y轴设置*******/
			{
				//获得默认x轴
				CategoryAxis domainAxis = categoryPlot.getDomainAxis();
				//设置轴的颜色
				domainAxis.setAxisLinePaint(ChartColor.RED);
				//获得默认左y轴
				ValueAxis rangeAxis = categoryPlot.getRangeAxis();
				
				//Y轴默认显示整数
				rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				//Y轴最小为0
				rangeAxis.setLowerBound(0.0);
				
				//右侧Y轴
				NumberAxis numberAxis = new NumberAxis("右侧Y轴");
				//设置x轴与右侧Y轴对应
				CategoryPlot categoryplot =  (CategoryPlot) createLineChart.getPlot();
				categoryplot.setRangeAxis(1, numberAxis);
				//右侧Y轴放值
				categoryplot.setDataset(1, lineRightChartDataset);
				categoryplot.mapDatasetToRangeAxis(1, 1);
				//设置右侧Y轴默认为整数
				ValueAxis rangeAxisRight = categoryPlot.getRangeAxis(1);
				rangeAxisRight.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
				//Y轴最小为0
				rangeAxisRight.setLowerBound(0.0);
				
				//对应右侧线并在图例中显示
				LineAndShapeRenderer lineRendererLeft = new LineAndShapeRenderer();
				lineRendererLeft.setDefaultShapesVisible(true);
				categoryplot.setRenderer(1, lineRendererLeft);
			}
		
			/*************图例相关******************/
			LegendTitle legendSet = createLineChart.getLegend(0);
			legendSet.setVerticalAlignment(VerticalAlignment.CENTER);
			legendSet.setPosition(RectangleEdge.TOP);
		}
		
		/****创建文件***/
		{
		String filePath = "F:\\img\\line-chart.jpg";
		File chartFile = new File(filePath);
		int width = 800; /* Width of the image */
        int height = 600; /* Height of the image */
		ChartUtils.saveChartAsJPEG(chartFile, createLineChart, width, height);
		chartFile.createNewFile();
		System.out.println(filePath);
		}
	}
	
	/**
	 * 创建文件
	 * @param path
	 * @throws IOException
	 */
	public void makeFile(String path) throws IOException {
		String filePath = "F:\\img\\line-chart.jpg";
		File chartFile = new File(filePath);
		chartFile.createNewFile();
		System.out.println(filePath);
	}
	
	
	public void other() throws IOException {
		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		//创建折线图
		//createLineChart dataset类型为CategoryDataset
		ChartFactory.createLineChart("图表标题", "x轴(类别)标签", "Y(值)轴标签", defaultCategoryDataset);
		//ChartFactory.createLineChart("图表标题", "x轴(类别)标签", "Y(值)轴标签", dataset, orientation, legend, tooltips, urls)
		
		//createXYLineChart   dataset类型为XYDataset
		//ChartFactory.createXYLineChart("图表标题", "x轴标签", "Y轴标签", dataset)
		//ChartFactory.createXYLineChart("图表标题", "x轴标签", "Y轴标签", dataset, orientation, legend, tooltips, urls)
		String filePath = "F:\\img\\line-chart.jpg";
		
		File chartFile = new File(filePath);
		chartFile.createNewFile();
		System.out.println(filePath);
	}
}
