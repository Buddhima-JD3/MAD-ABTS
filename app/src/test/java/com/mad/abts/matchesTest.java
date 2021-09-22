package com.mad.abts;

import com.mad.abts.database.Matches;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;

import static org.junit.Assert.*;

public class matchesTest extends TestCase {
private matches mt;
    @Before
    public void setUp() throws Exception {
        mt = new matches();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void winchance1() {
        int result = mt.winchance1(120,7);

        assertEquals(41,result);
    }

    @Test
    public void winchance2() {
        int result = mt.winchance1(20,6);

        assertEquals(68,result);
    }
}