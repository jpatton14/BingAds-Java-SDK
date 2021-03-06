package com.microsoft.bingads.v11.api.test.entities.ads.text.write;

import com.microsoft.bingads.v11.api.test.entities.ads.text.BulkTextAdTest;
import com.microsoft.bingads.v11.bulk.entities.BulkTextAd;
import com.microsoft.bingads.v11.campaignmanagement.ArrayOfCustomParameter;
import com.microsoft.bingads.v11.campaignmanagement.ArrayOfKeyValuePairOfstringstring;
import com.microsoft.bingads.v11.campaignmanagement.CustomParameter;
import com.microsoft.bingads.v11.campaignmanagement.CustomParameters;
import com.microsoft.bingads.v11.campaignmanagement.KeyValuePairOfstringstring;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BulkTextAdWriteToRowValuesNativePreference extends BulkTextAdTest {
	
	@Parameter(value = 1)
	public String expected;
	
	@Parameters
	public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                {null, null},
                {"Native", "Native"},
                {"All", "All"},
            });
	}

    @Test
    public void testWrite() {
    	this.<String>testWriteProperty("Ad Format Preference", expected, datum, new BiConsumer<BulkTextAd, String>() {
            @Override
            public void accept(BulkTextAd c, String v) {
            	c.getAd().setAdFormatPreference(v);
            }
        });
    }
}