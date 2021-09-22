package com.mad.abts;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
public class teamstatsTest extends TestCase {
    private teamstats tstats;
    @Before
    public void setUp() throws Exception {
        tstats = new teamstats();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calPoints() {
        int result = tstats.calPoints(6,2);

        assertEquals(14,result);
    }

    @Test
    public void calWinPerc() {
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        double result = tstats.calWinPerc(7,4);
        result = Double.parseDouble(nf.format(result));
        assertEquals(57.14,result);
    }
}