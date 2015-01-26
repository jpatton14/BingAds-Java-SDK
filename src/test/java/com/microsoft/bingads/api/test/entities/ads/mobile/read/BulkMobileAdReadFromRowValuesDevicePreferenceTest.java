package com.microsoft.bingads.api.test.entities.ads.mobile.read;

import com.microsoft.bingads.api.test.entities.ads.mobile.BulkMobileAdTest;
import com.microsoft.bingads.bulk.entities.BulkMobileAd;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BulkMobileAdReadFromRowValuesDevicePreferenceTest extends BulkMobileAdTest {

    @Parameter(value = 1)
    public Long expectedResult;

    /*
     * Test data generator.
     * This method is called the the JUnit parameterized test runner and
     * returns a Collection of Arrays.  For each Array in the Collection,
     * each array element corresponds to a parameter in the constructor.
     */
    @Parameters
    public static Collection<Object[]> data() {
        // In this example, the parameter generator returns a List of
        // arrays.  Each array has two elements: { datum, expected }.
        // These data are hard-coded into the class, but they could be
        // generated or loaded in any way you like.
        return Arrays.asList(new Object[][]{
            {"All", 0L},
            {"Mobile", 30001L},
            {"", 0L}
        });
    }

    @Test
    public void testRead() {
        this.<Long>testReadProperty("Device Preference", this.datum, this.expectedResult, new Function<BulkMobileAd, Long>() {
            @Override
            public Long apply(BulkMobileAd c) {
                return c.getMobileAd().getDevicePreference();
            }
        });
    }
}
