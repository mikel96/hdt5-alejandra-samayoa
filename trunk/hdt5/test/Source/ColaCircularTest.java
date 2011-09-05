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
public class ColaCircularTest {
    
    public ColaCircularTest() {
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
     * Test of size method, of class ColaCircular.
     */
    @Test
    public void testSize() {
        ColaCircular colita = new ColaCircular();
        colita.enqueue("Estreno");
        colita.enqueue("DelMes");
        assertEquals(2,colita.size());
    }

    /**
     * Test of enqueue method, of class ColaCircular.
     */
    @Test
    public void testEnqueue() {
       ColaCircular colita = new ColaCircular();
        colita.enqueue(567);
        colita.enqueue(776);
        assertEquals(567,colita.dequeue());
    }

    /**
     * Test of dequeue method, of class ColaCircular.
     */
    @Test
    public void testDequeue() {
        ColaCircular colita = new ColaCircular();
        colita.enqueue(569);
        colita.enqueue(343);
        assertEquals(569,colita.dequeue());
    }

    /**
     * Test of peek method, of class ColaCircular.
     */
    @Test
    public void testPeek() {
        ColaCircular colita = new ColaCircular();
        colita.enqueue("Estreno");
        colita.enqueue("DelMes");
        assertEquals("Estreno",colita.peek());
    }
}
