package com.mad.abts;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class matchesTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Test
    public void winchance1() {
        matches mt= new matches();
        int result = mt.winchance1(120,7);

        assertEquals(41,result,.1);
    }

    @Test
    public void winchance2() {
        matches mt1= new matches();
        int result = mt1.winchance2(20,6);

        assertEquals(88,result,.1);
    }
}