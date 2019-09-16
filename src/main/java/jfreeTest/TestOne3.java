package jfreeTest;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
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
import org.jfree.data.time.TimeSeriesCollection;

public class TestOne3 {
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
		
	        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
//	        timeSeriesCollection.add
	        TestOne3 testOne3 = new TestOne3();
	        List<Double> equation = testOne3.getCurveEquation(testOne3.getData().get(0), testOne3.getData().get(1),2);
	        // get Max and Min of x;
			List<Double> xList = testOne3.getData().get(0);
			double max = testOne3.getMax(xList);
			double min = testOne3.getMin(xList);
			double step = max - min;
			double x = min;
			double step2 = step / 800.0;
			// 按照多项式的形式 还原多项式，并利用多项式计算给定x时y的值
			for (int i = 0; i < 800; i++) {
				x = x + step2;
				int num = equation.size() - 1;
				double temp = 0.0;
				for (int j = 0; j < equation.size(); j++) {
					temp = temp + Math.pow(x, (num - j)) * equation.get(j);
				}
//				lineRightChartDataset.addValue(temp, "拟合曲线", "19400");
			}
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19400");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19500");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19600");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19700");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19800");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "19900");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "20000");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "20100");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "20200");
//	        lineRightChartDataset.addValue(r.nextInt(1000), "拟合曲线", "20300");
	        
	        
	        
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
				//带日期的情况要让数据倾斜
				domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
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
				numberAxis.setAxisLineVisible(false);
				numberAxis.setTickMarksVisible(false);
				//设置x轴与右侧Y轴对应
				//1生成坐标点点的形状
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
	// 模拟设置绘图数据（点）
	public List<List<Double>> getData() {
		// x为x轴坐标
		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();
		x.add(1.0);
		x.add(2.0);
		x.add(3.0);
		x.add(4.0);
		x.add(5.0);
		x.add(6.0);
		x.add(7.0);
		x.add(8.0);
		x.add(9.0);
		x.add(10.0);
		Random r = new Random();
		y.add((double) r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));
		y.add((double)r.nextInt(1000));

		List<List<Double>> list = new ArrayList<List<Double>>();
		list.add(x);
		list.add(y);
		return list;

	}
	
	// 获取List中Double数据的最大最小值
	public double getMax(List<Double> data) {
		double res = data.get(0);
		for (int i = 0; i < data.size() - 1; i++) {
			if (res < data.get(i + 1)) {
				res = data.get(i + 1);
			}
		}
		return res;
	}

	public double getMin(List<Double> data) {
		double res = data.get(0);
		for (int i = 0; i < data.size() - 1; i++) {
			if (res > data.get(i + 1)) {
				res = data.get(i + 1);
			}
		}
		return res;
	}
	
	//以下代码为最小二乘法计算多项式系数 
	//最小二乘法多项式拟合 
		public List<Double> getCurveEquation(List<Double> x, List<Double> y, int m) {
			if (x.size() != y.size() || x.size() <= m + 1) {
				return new ArrayList<Double>();
			}
			List<Double> result = new ArrayList<Double>();
			List<Double> S = new ArrayList<Double>();
			List<Double> T = new ArrayList<Double>();
			// 计算S0 S1 …… S2m
			for (int i = 0; i <= 2 * m; i++) {
				double si = 0.0;
				for (double xx : x) {
					si = si + Math.pow(xx, i);
				}
				S.add(si);
			}
			// 计算T0 T1 …… Tm
			for (int j = 0; j <= m; j++) {
				double ti = 0.0;
				for (int k = 0; k < y.size(); k++) {
					ti = ti + y.get(k) * Math.pow(x.get(k), j);
				}
				T.add(ti);
			}

			// 把S和T 放入二维数组，作为矩阵
			double[][] matrix = new double[m + 1][m + 2];
			for (int k = 0; k < m + 1; k++) {
				double[] matrixi = matrix[k];
				for (int q = 0; q < m + 1; q++) {
					matrixi[q] = S.get(k + q);
				}
				matrixi[m + 1] = T.get(k);
			}
			for (int p = 0; p < matrix.length; p++) {
				for (int pp = 0; pp < matrix[p].length; pp++) {
					System.out.print(" matrix[" + p + "][" + pp + "]=" + matrix[p][pp]);
				}
				System.out.println();
			}
			// 把矩阵转化为三角矩阵
			matrix = this.matrixConvert(matrix);
			// 计算多项式系数，多项式从高到低排列
			result = this.MatrixCalcu(matrix);
			return result;
		}
		
		// 计算一元多次方程前面的系数， 其排列为 xm xm-1 …… x0（多项式次数从高到低排列）
		public List<Double> MatrixCalcu(double[][] d) {

			int i = d.length - 1;
			int j = d[0].length - 1;
			List<Double> list = new ArrayList<Double>();
			double res = d[i][j] / d[i][j - 1];
			list.add(res);

			for (int k = i - 1; k >= 0; k--) {
				double num = d[k][j];
				for (int q = j - 1; q > k; q--) {
					num = num - d[k][q] * list.get(j - 1 - q);
				}
				res = num / d[k][k];
				list.add(res);
			}
			return list;
		}
		
		// 矩阵转换为三角矩阵
		public double[][] matrixConvert(double[][] d) {
			for (int i = 0; i < d.length - 1; i++) {
				double[] dd1 = d[i];
				double num1 = dd1[i];

				for (int j = i; j < d.length - 1; j++) {
					double[] dd2 = d[j + 1];
					double num2 = dd2[i];

					for (int k = 0; k < dd2.length; k++) {
						dd2[k] = (dd2[k] * num1 - dd1[k] * num2);
					}
				}
			}
			for (int ii = 0; ii < d.length; ii++) {
				for (int kk = 0; kk < d[ii].length; kk++)
					System.out.print(d[ii][kk] + " ");
				System.out.println();
			}
			return d;
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
