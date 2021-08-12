package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class matches extends AppCompatActivity {
    PieChart pieChart;
    PieChart pieChart2;
    PieData pieData;
    PieData pieData2;
    List<PieEntry> pieEntryList = new ArrayList<>();
    List<PieEntry> pieEntryList2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        pieChart = findViewById(R.id.piepercentage);
        pieChart.setUsePercentValues(true);
        pieEntryList.add(new PieEntry(55,"Kings"));
        pieEntryList.add(new PieEntry(45,"Tuskers"));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Team");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.getDescription().setText("Team");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        pieChart2 = findViewById(R.id.piepercentage2);
        pieChart2.setUsePercentValues(true);
        pieEntryList2.add(new PieEntry(30,"Gladiators"));
        pieEntryList2.add(new PieEntry(70,"Stallions"));
        PieDataSet pieDataSet2 = new PieDataSet(pieEntryList2,"Team");
        pieDataSet2.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart2.getDescription().setText("Team");
        pieData2 = new PieData(pieDataSet2);
        pieChart2.setData(pieData2);
        pieChart2.invalidate();
    }


}
