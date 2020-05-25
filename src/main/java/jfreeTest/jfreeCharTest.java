package jfreeTest;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;


public class jfreeCharTest {
	public static void main(String[] args) {
		linePic();
	}

	private static void linePic() {
		//文字的样式
		Font font1 = new Font("微软雅黑", Font.PLAIN, 12);
		
		/**********************数据*************************/
		//数据
		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		String category = "数据对应的名字";

		/***********************数据end****************************/
		//横坐标对应的值
		
		defaultCategoryDataset.setValue(12, category, "横坐标1");
		defaultCategoryDataset.setValue(30, category, "tow");
		defaultCategoryDataset.setValue(40, category, "横坐标3");
		
		JFreeChart jFreeChartLine = ChartFactory.createLineChart("图片标题", "类别轴标签", "值轴的标签", defaultCategoryDataset);
		/***************横纵坐标 jfreeChar图片标题 图例 文字样式***********************/
		//标题样式
		jFreeChartLine.getTitle().setFont(font1);
		
		//右侧折线图
		CategoryPlot categoryplot = (CategoryPlot) jFreeChartLine.getPlot();
		
		//横坐标样式
		categoryplot.getDomainAxis().setLabelFont(font1);
		categoryplot.getDomainAxis().setTickLabelFont(font1);
		
		//左侧的字体格式
		categoryplot.getRangeAxis().setLabelFont(font1);
		categoryplot.getRangeAxis().setTickLabelFont(font1);
		
		//图例字体
		jFreeChartLine.getLegend().setItemFont(font1);
		/***************横纵坐标 jfreeChar图片标题 图例 文字样式   end ***********************/
		
		//图例显示与否
		//jFreeChartLine.getLegend().setVisible(false);
		// 设置图例边框颜色
		//jFreeChartLine.getLegend().setFrame(new BlockBorder(Color.RED));
		
		//控制图例的位置
		LegendTitle legend = jFreeChartLine.getLegend();
		legend.setPosition(RectangleEdge.RIGHT);
		
		//折线图后的背景色
		jFreeChartLine.getCategoryPlot().setBackgroundPaint(Color.WHITE);
		
		//整体的边框
//		jFreeChartLine.setBorderVisible(true);
//		jFreeChartLine.setBorderPaint(Color.RED);
//		jFreeChartLine.setBorderStroke(new BasicStroke(10));
		//整体外部背景色设置
		jFreeChartLine.setBackgroundPaint(ChartColor.WHITE);
		
		int width = 690; /* Width of the image */
        int height = 300; /* Height of the image */
        File areaChart = new File("D:/cc.png");
        
        try {
			ChartUtils.saveChartAsJPEG(areaChart, jFreeChartLine, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
