/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaetan
 */
public class FirstTestTest {
    
    @Test
    public void testEmptyCollection() {
        Collection collection = new ArrayList();
        assertTrue(collection.isEmpty());
    }
    
    @Test
    public void testTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testFalse() {
        assertFalse(true);
    }
    
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("tests.FirstTest");
    }
}
