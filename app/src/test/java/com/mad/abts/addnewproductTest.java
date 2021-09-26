package com.mad.abts;

import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;

public class addnewproductTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Test
    public void totalprofit() {
        addnewproduct pd= new addnewproduct();
        double result = pd.totalprofit(20,5000.223);

        assertEquals(100004.46,result,.1);
    }

}

