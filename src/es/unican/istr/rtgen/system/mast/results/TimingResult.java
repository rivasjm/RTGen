//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.19 at 05:12:38 PM CEST 
//


package es.unican.istr.rtgen.system.mast.results;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Timing_Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Timing_Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Worst_Global_Response_Times" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Best_Global_Response_Times" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Jitters" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Event_Name" use="required" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Identifier" />
 *       &lt;attribute name="Worst_Local_Response_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Best_Local_Response_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Worst_Blocking_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Num_Of_Suspensions" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Timing_Result", propOrder = {
    "worstGlobalResponseTimes",
    "bestGlobalResponseTimes",
    "jitters"
})
public class TimingResult {

    @XmlElement(name = "Worst_Global_Response_Times")
    protected GlobalResponseTimeList worstGlobalResponseTimes;
    @XmlElement(name = "Best_Global_Response_Times")
    protected GlobalResponseTimeList bestGlobalResponseTimes;
    @XmlElement(name = "Jitters")
    protected GlobalResponseTimeList jitters;
    @XmlAttribute(name = "Event_Name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String eventName;
    @XmlAttribute(name = "Worst_Local_Response_Time")
    protected Double worstLocalResponseTime;
    @XmlAttribute(name = "Best_Local_Response_Time")
    protected Double bestLocalResponseTime;
    @XmlAttribute(name = "Worst_Blocking_Time")
    protected Double worstBlockingTime;
    @XmlAttribute(name = "Num_Of_Suspensions")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numOfSuspensions;

    /**
     * Gets the value of the worstGlobalResponseTimes property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public GlobalResponseTimeList getWorstGlobalResponseTimes() {
        return worstGlobalResponseTimes;
    }

    /**
     * Sets the value of the worstGlobalResponseTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public void setWorstGlobalResponseTimes(GlobalResponseTimeList value) {
        this.worstGlobalResponseTimes = value;
    }

    /**
     * Gets the value of the bestGlobalResponseTimes property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public GlobalResponseTimeList getBestGlobalResponseTimes() {
        return bestGlobalResponseTimes;
    }

    /**
     * Sets the value of the bestGlobalResponseTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public void setBestGlobalResponseTimes(GlobalResponseTimeList value) {
        this.bestGlobalResponseTimes = value;
    }

    /**
     * Gets the value of the jitters property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public GlobalResponseTimeList getJitters() {
        return jitters;
    }

    /**
     * Sets the value of the jitters property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public void setJitters(GlobalResponseTimeList value) {
        this.jitters = value;
    }

    /**
     * Gets the value of the eventName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the worstLocalResponseTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWorstLocalResponseTime() {
        return worstLocalResponseTime;
    }

    /**
     * Sets the value of the worstLocalResponseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWorstLocalResponseTime(Double value) {
        this.worstLocalResponseTime = value;
    }

    /**
     * Gets the value of the bestLocalResponseTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBestLocalResponseTime() {
        return bestLocalResponseTime;
    }

    /**
     * Sets the value of the bestLocalResponseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBestLocalResponseTime(Double value) {
        this.bestLocalResponseTime = value;
    }

    /**
     * Gets the value of the worstBlockingTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWorstBlockingTime() {
        return worstBlockingTime;
    }

    /**
     * Sets the value of the worstBlockingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWorstBlockingTime(Double value) {
        this.worstBlockingTime = value;
    }

    /**
     * Gets the value of the numOfSuspensions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumOfSuspensions() {
        return numOfSuspensions;
    }

    /**
     * Sets the value of the numOfSuspensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumOfSuspensions(BigInteger value) {
        this.numOfSuspensions = value;
    }

}
