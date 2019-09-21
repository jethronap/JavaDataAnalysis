package stats;

import datastructs.NumericSample;
import org.junit.Test;
import stats.utils.Resample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ResampleTest {


    static final NumericSample getNumericSample(int size){

        NumericSample inSample = new NumericSample("TestIn", size);

        for(int i=0; i<inSample.size(); ++i){
            inSample.set(i, new Double(i));
        }

        return inSample;
    }


    /**
     * Test Scenario: The application passes a non-null sample as input
     * and a non-null sample instance as output.
     * Expected Output: Resampling should populate the output sample with the given size
     */
    @Test
    public void testResampleEqualSize(){

        NumericSample inSample = ResampleTest.getNumericSample(10);
        NumericSample outSample = Resample.resample(inSample, 10, 3);
        assertEquals(outSample.size(), 10);
    }


    /**
     * Test Scenario: The application passes a non-null sample as input. A smaller resampled sample is requested
     * Expected Output: Resampling should populate the output sample with the given size
     */
    @Test
    public void testResampleSmallerSize(){

        NumericSample inSample = ResampleTest.getNumericSample(10);
        NumericSample outSample = Resample.resample(inSample, 5, 3);
        assertEquals(outSample.size(),5 );
    }


    /**
     * Test Scenario: The application passes a non-null sample as input. A larger resampled sample is requested
     * Expected Output: Resampling should populate the output sample with the given size
     */
    @Test
    public void testResampleLargerSize(){
        assertFalse("Fix this test by adding support", true);
    }


}
