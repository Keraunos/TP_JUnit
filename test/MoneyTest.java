/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaetan
 */
public class MoneyTest {
    
    public MoneyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of amount method, of class Money.
     */
    @Test
    public void testAmount() {
        System.out.println("amount");
        Money instance = null;
        int expResult = 0;
        int result = instance.amount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currency method, of class Money.
     */
    @Test
    public void testCurrency() {
        System.out.println("currency");
        Money instance = null;
        String expResult = "";
        String result = instance.currency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        System.out.println("ADD");
        int sum1 = 20;
        int sum2 = 30;
        Money m = new Money(sum1, "CHF");
        Money instance = new Money(sum2, "CHF");
        int expResult = sum1 + sum2;
        Money result = instance.add(m);
        assertEquals(expResult, result.amount());
    }

    /**
     * Test of equals method, of class Money.
     */
    @Test
    public void testEquals() {
        System.out.println("EQUALS");
        Money money1 = new Money(3786, "CHF");
        Money money2 = new Money(283, "EUR");
        
        System.out.println("--> compare to null");
        assertTrue(!money1.equals(null));
        
        System.out.println("--> compare 2 Money objects");
        assertEquals(money1, money1);
        
        System.out.println("--> compare a Money object to a copy");
        assertEquals(money1, new Money(money1.amount(), money1.currency()));
        
        System.out.println("--> compare to different Money objects");
        assertTrue(!money1.equals(money2));
    }
}
