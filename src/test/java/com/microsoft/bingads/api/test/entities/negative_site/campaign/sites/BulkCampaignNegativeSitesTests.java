package com.microsoft.bingads.api.test.entities.negative_site.campaign.sites;

import com.microsoft.bingads.api.test.entities.negative_site.campaign.sites.read.BulkCampaignNegativeSitesReadTest;
import com.microsoft.bingads.api.test.entities.negative_site.campaign.sites.write.BulkCampaignNegativeSitesWriteTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BulkCampaignNegativeSitesReadTest.class, BulkCampaignNegativeSitesWriteTest.class})
public class BulkCampaignNegativeSitesTests {

}
