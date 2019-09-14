/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author youssefc
 */
public class ChartForm {
Float id ;
    Form f = new Form("Budget", new BorderLayout());

    public ChartForm() {
        
        
        createPieChartForm();
        
    }

private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(20);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
    int k = 0;
    for (double value : values) {
        series.add("user " + ++k, value);
    }

    return series;
}

public void createPieChartForm() {
    
                 ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/BonPlanMobile/chart.php";
        con.setUrl(Url);
        NetworkManager.getInstance().addToQueue(con);
                        JSONParser jsonp = new JSONParser();
                        
                con.addResponseListener((NetworkEvent evt) -> {
                    try {
                        Map<String, Object> tasks  = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                        System.out.println("roooooot:" +tasks);
                                            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                        for (Map<String, Object> obj : list) {
                         id = Float.parseFloat(obj.get("count(*)").toString());


                    }
                                 System.out.println(""+id);
double[] values = new double[]{id, 14, 11, 10, 19};

    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLACK, ColorUtil.GREEN, ColorUtil.LTGRAY, ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(50);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    
//    r.setGradientStart(0, ColorUtil.BLUE);
//    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("1995", values), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    f.add(BorderLayout.CENTER, c);
    f.show();

                    } catch (IOException ex) {
                    }    });
                                               
                                                   

    // Generate the values
    



    }

}
