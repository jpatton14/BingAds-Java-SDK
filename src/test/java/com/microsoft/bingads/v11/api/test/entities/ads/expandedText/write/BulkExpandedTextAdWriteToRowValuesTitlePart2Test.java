package com.microsoft.bingads.v11.api.test.entities.ads.expandedText.write;

import com.microsoft.bingads.v11.api.test.entities.ads.expandedText.BulkExpandedTextAdTest;
import com.microsoft.bingads.v11.bulk.entities.BulkExpandedTextAd;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BulkExpandedTextAdWriteToRowValuesTitlePart2Test extends BulkExpandedTextAdTest {

    @Parameter(value = 1)
    public String propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Test Title Part 2", "Test Title Part 2"},
            {"", ""},
            {null, null},});
    }

    @Test
    public void testWrite() {
        this.<String>testWriteProperty("Title Part 2", this.datum, this.propertyValue, new BiConsumer<BulkExpandedTextAd, String>() {
            @Override
            public void accept(BulkExpandedTextAd c, String v) {
                c.getExpandedTextAd().setTitlePart2(v);
            }
        });
    }
}
