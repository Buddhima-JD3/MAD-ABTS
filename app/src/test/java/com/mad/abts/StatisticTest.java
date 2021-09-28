package com.mad.abts;

import static org.junit.Assert.assertEquals;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;


public class StatisticTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Test
    public void calScoreAvg() {
        teams6 average = new teams6();
        double result = average.calScoreAvg(165,75);
        assertEquals(120,result,.1);
    }
}
