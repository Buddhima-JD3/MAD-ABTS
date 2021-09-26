package com.mad.abts;

import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;

public class playerstatsTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Test
    public void calAverage() {
        adminplayerprofile average = new adminplayerprofile();
        double result = average.calAverage(100,10);
        assertEquals(10,result,.1);
    }
}
