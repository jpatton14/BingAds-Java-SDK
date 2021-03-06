package com.microsoft.bingads.v11.bulk.entities;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v11.internal.bulk.BulkMapping;
import com.microsoft.bingads.v11.internal.bulk.ComplexBulkMapping;
import com.microsoft.bingads.v11.internal.bulk.MappingHelpers;
import com.microsoft.bingads.v11.bulk.BulkFileReader;
import com.microsoft.bingads.v11.bulk.BulkFileWriter;
import com.microsoft.bingads.v11.bulk.BulkOperation;
import com.microsoft.bingads.v11.bulk.BulkServiceManager;
import com.microsoft.bingads.v11.campaignmanagement.PriceAdExtension;
import com.microsoft.bingads.v11.campaignmanagement.PriceExtensionType;
import com.microsoft.bingads.v11.campaignmanagement.ArrayOfPriceTableRow;
import com.microsoft.bingads.v11.internal.bulk.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a price ad extension that can be read or written in a bulk file.
 * This class exposes the properties
 * that can be read and written as fields of the Price Ad Extension record in a
 * bulk file.
 * <p/>
 * For more information, see Price Ad Extension at
 * <a href="https://go.microsoft.com/fwlink/?linkid=846127">https://go.microsoft.com/fwlink/?linkid=846127</a>
 *
 * @see BulkServiceManager
 * @see BulkOperation
 * @see BulkFileReader
 * @see BulkFileWriter
 */
public class BulkPriceAdExtension extends BulkAdExtension<PriceAdExtension> {

    /**
     * Gets the price ad extension.
     */
    public PriceAdExtension getPriceAdExtension() {
        return getAdExtension();
    }

    /**
     * Sets the price ad extension.
     */
    public void setPriceAdExtension(PriceAdExtension priceAdExtension) {
        setAdExtension(priceAdExtension);
    }

    private static final List<BulkMapping<BulkPriceAdExtension>> MAPPINGS;

    static {
        List<BulkMapping<BulkPriceAdExtension>> m = new ArrayList<BulkMapping<BulkPriceAdExtension>>();

        m.add(new SimpleBulkMapping<BulkPriceAdExtension, String>(
                StringTable.Language,
                new Function<BulkPriceAdExtension, String>() {
                    @Override
                    public String apply(BulkPriceAdExtension c) {
                        return c.getAdExtension().getLanguage();
                    }
                },
                new BiConsumer<String, BulkPriceAdExtension>() {
                    @Override
                    public void accept(String v, BulkPriceAdExtension c) {
                        c.getPriceAdExtension().setLanguage(v);
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkPriceAdExtension, String>(StringTable.PriceExtensionType,
                new Function<BulkPriceAdExtension, String>() {
                    @Override
                    public String apply(BulkPriceAdExtension c) { 
                    	PriceExtensionType priceExtensionType = c.getPriceAdExtension().getPriceExtensionType();
                        return priceExtensionType == null ? null : priceExtensionType.value();
                    }
                },
                new BiConsumer<String, BulkPriceAdExtension>() {
                    @Override
                    public void accept(String v, BulkPriceAdExtension c) {
                    	c.getPriceAdExtension().setPriceExtensionType(StringExtensions.parseOptional(v, new Function<String, PriceExtensionType>() {
                            @Override
                            public PriceExtensionType apply(String s) {
                                return PriceExtensionType.fromValue(s);
                            }
                        }));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkPriceAdExtension, String>(StringTable.TrackingTemplate,
                new Function<BulkPriceAdExtension, String>() {
                    @Override
                    public String apply(BulkPriceAdExtension c) {
                        return StringExtensions.toOptionalBulkString(c.getAdExtension().getTrackingUrlTemplate());
                    }
                },
                new BiConsumer<String, BulkPriceAdExtension>() {
                    @Override
                    public void accept(String v, BulkPriceAdExtension c) {
                        c.getAdExtension().setTrackingUrlTemplate(StringExtensions.getValueOrEmptyString(v));
                    }
                }
        ));
        
        m.add(new SimpleBulkMapping<BulkPriceAdExtension, String>(StringTable.CustomParameter,
                new Function<BulkPriceAdExtension, String>() {
                    @Override
                    public String apply(BulkPriceAdExtension c) {
                        return StringExtensions.toCustomParaBulkString(c.getAdExtension().getUrlCustomParameters());
                    }
                },
                new BiConsumer<String, BulkPriceAdExtension>() {
                    @Override
                    public void accept(String v, BulkPriceAdExtension c) {
                        try {
							c.getAdExtension().setUrlCustomParameters(StringExtensions.parseCustomParameters(v));
						} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                }
        ));

        m.add(new ComplexBulkMapping<BulkPriceAdExtension>(
                new BiConsumer<BulkPriceAdExtension, RowValues>() {
                    @Override
                    public void accept(BulkPriceAdExtension c, RowValues v) {
                    	PriceAdExtension priceAdExtension = c.getPriceAdExtension();                   	
                        if (priceAdExtension == null || priceAdExtension.getTableRows() == null) {
                            return;
                        }	                        
                        PriceTableRowHelper.addRowValuesFromPriceTableRows(priceAdExtension.getTableRows(), v);
                    }
                },
                new BiConsumer<RowValues, BulkPriceAdExtension>() {
                    @Override
                    public void accept(RowValues v, BulkPriceAdExtension c) {
                    	PriceAdExtension priceAdExtension = c.getPriceAdExtension(); 
                        if (priceAdExtension != null) {
                            priceAdExtension.setTableRows(new ArrayOfPriceTableRow());                        
                            PriceTableRowHelper.addPriceTableRowsFromRowValues(v, priceAdExtension.getTableRows());
                        }	
                    }
                }
        ));

        MAPPINGS = Collections.unmodifiableList(m);
    }

    @Override
    public void processMappingsFromRowValues(RowValues values) {
        PriceAdExtension extension = new PriceAdExtension();

        extension.setType("PriceAdExtension");

        setAdExtension(extension);

        super.processMappingsFromRowValues(values);

        MappingHelpers.convertToEntity(values, MAPPINGS, this);
    }

    @Override
    public void processMappingsToRowValues(RowValues values, boolean excludeReadonlyData) {
        validatePropertyNotNull(this.getPriceAdExtension(), "PriceAdExtension");

        super.processMappingsToRowValues(values, excludeReadonlyData);
        MappingHelpers.convertToValues(this, values, MAPPINGS);
    }
}
