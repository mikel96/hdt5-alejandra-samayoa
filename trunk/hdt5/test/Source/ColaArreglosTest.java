/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pingus
 */
public class ColaArreglosTest {
    
    public ColaArreglosTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dequeue method, of class ColaArreglos.
     */
    @Test
    public void testDequeue() {
        ColaArreglos colita = new ColaArreglos();
        colita.enqueue(5);
        colita.enqueue(3);
        assertEquals(5,colita.dequeue());
    }

    /**
     * Test of enqueue method, of class ColaArreglos.
     */
    @Test
    public void testEnqueue() {
        ColaArreglos colita = new ColaArreglos();
        colita.enqueue("Estreno");
        colita.enqueue("DelMes");
        assertEquals("Estreno",colita.dequeue());
    }

    /**
     * Test of peek method, of class ColaArreglos.
     */
    @Test
    public void testPeek() {
        ColaArreglos colita = new ColaArreglos();
        colita.enqueue(true);
        colita.enqueue(false);
        assertEquals(true,colita.peek());
        
    }

    /**
     * Test of size method, of class ColaArreglos.
     */
    @Test
    public void testSize() {
        ColaArreglos colita = new ColaArreglos();
        colita.enqueue("Estreno");
        colita.enqueue("DelMes");
        assertEquals(2,colita.size());
    }
}
