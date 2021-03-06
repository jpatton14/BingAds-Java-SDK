
package com.microsoft.bingads.v11.customerbilling;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOperationError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOperationError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationError" type="{https://bingads.microsoft.com/Customer/v11/Exception}OperationError" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOperationError", namespace = "https://bingads.microsoft.com/Customer/v11/Exception", propOrder = {
    "operationErrors"
})
public class ArrayOfOperationError {

    @XmlElement(name = "OperationError", nillable = true)
    protected List<OperationError> operationErrors;

    /**
     * Gets the value of the operationErrors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationErrors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationError }
     * 
     * 
     */
    public List<OperationError> getOperationErrors() {
        if (operationErrors == null) {
            operationErrors = new ArrayList<OperationError>();
        }
        return this.operationErrors;
    }

}
