package com.example.calc.test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.example.calc.Calc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class CalcTest {
    private static final Logger LOGGER = Logger.getLogger(CalcTest.class);

    @BeforeMethod
    public void beforeMethod(Method method, Object[] data) {
        LOGGER.info(String.format(
            "Running: %s#%s(%s)",
            method.getDeclaringClass().getCanonicalName(),
            method.getName(),
            Arrays.stream(data).map(x -> x.toString()).collect(Collectors.joining(", "))));
    }

    @DataProvider(name = "testAdd")
    public Object[][] createData() {
        return new Object[][] { { 0, 0, 0 },{ 0, 1, 1 } };
    }

    @Test(dataProvider = "testAdd")
    public void testAdd(int x, int y, int expected) {
        LOGGER.info(String.format(
            "Running: com.example.calc.test.CalcTest#testAdd(%d, %d, %d)", x, y, expected));

        Calc calc = new Calc();
        assertEquals(calc.add(x, y), expected);
    }
}
