package com.microsoft.bingads.v10.bulk.entities;

import com.microsoft.bingads.v10.bulk.BulkServiceManager;
import com.microsoft.bingads.v10.campaignmanagement.CityTargetBid;
import com.microsoft.bingads.v10.bulk.BulkFileReader;
import com.microsoft.bingads.v10.bulk.BulkFileWriter;
import com.microsoft.bingads.v10.bulk.BulkOperation;

/**
 * Represents one sub location target bid within a location target that is associated with an ad group.
 *
 * This class exposes properties that can be read and written as fields of the Ad Group Location Target record in a bulk file.
 *
 * <p>
 *     For more information, see Ad Group Location Target at
 *     <a href="http://go.microsoft.com/fwlink/?LinkID=620255">http://go.microsoft.com/fwlink/?LinkID=620255</a>.
 * </p>
 *
 * <p>
 *     Each location sub type contains a list of bids.
 *     For example {@link BulkLocationTargetWithStringLocation#getCityTarget} contains a list of {@link CityTargetBid}.
 *     Each {@link CityTargetBid} instance corresponds to one Ad Group Location Target record in the bulk file.
 *     If you upload a {@link BulkLocationTargetWithStringLocation#getCityTarget},
 *     then you are effectively replacing any existing city bids for the corresponding location target
 * </p>
 *
 * <p>
 *     The {@link BulkLocationTargetBidWithStringLocation#getLocationType} property determines the geographical location sub type.
 * </p>
 *
 * @see BulkServiceManager
 * @see BulkOperation
 * @see BulkFileReader
 * @see BulkFileWriter
 */
public class BulkAdGroupLocationTargetBid extends BulkLocationTargetBid {

    /**
     * Initializes a new instanced of the BulkAdGroupLocationTargetBid class.
     */
    public BulkAdGroupLocationTargetBid() {
        super(new BulkAdGroupTargetIdentifier(BulkAdGroupLocationTargetBid.class));
    }

    /**
     * Gets the identifier of the ad group that the target is associated.
     *
     * <p>
     *     Corresponds to the 'Parent Id' field in the bulk file.
     * </p>
     */
    public Long getAdGroupId() {
        return getEntityId();
    }

    /**
     * Sets the identifier of the ad group that the target is associated.
     *
     * <p>
     *     Corresponds to the 'Parent Id' field in the bulk file.
     * </p>
     */
    public void setAdGroupId(Long adGroupId) {
        setEntityId(adGroupId);
    }

    /**
     * Gets the name of the ad group that the target is associated.
     *
     * <p>
     *     Corresponds to the 'Ad Group' field in the bulk file.
     * </p>
     */
    public String getAdGroupName() {
        return getEntityName();
    }

    /**
     * Sets the name of the ad group that the target is associated.
     *
     * <p>
     *     Corresponds to the 'Ad Group' field in the bulk file.
     * </p>
     */
    public void setAdGroupName(String adGroupName) {
        setEntityName(adGroupName);
    }

    /**
     * Gets the name of the campaign that target is associated.
     *
     * <p>
     *     Corresponds to the 'Campaign' field in the bulk file.
     * </p>
     */
    public String getCampaignName() {
        return getParentEntityName();
    }

    /**
     * Sets the name of the campaign that target is associated.
     *
     * <p>
     *     Corresponds to the 'Campaign' field in the bulk file.
     * </p>
     */
    public void setCampaignName(String campaignName) {
        setParentEntityName(campaignName);
    }
}
