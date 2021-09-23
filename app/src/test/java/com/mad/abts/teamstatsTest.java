package com.mad.abts;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.NumberFormat;

import static org.junit.Assert.*;

public class teamstatsTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Test
    public void calPoints() {
        teamstats tstats = new teamstats();
        int result = tstats.calPoints(6,2);
        assertEquals(14,result,.1);
    }

    @Test
    public void calWinPerc() {
        teamstats tstats = new teamstats();
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        double result = tstats.calWinPerc(4,6);
        result = Double.parseDouble(nf.format(result));
        assertEquals(66.66,result,.1);
    }
}