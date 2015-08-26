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
 * <p>Java class for Simulation_Timing_Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Simulation_Timing_Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Worst_Global_Response_Times" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Avg_Global_Response_Times" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Best_Global_Response_Times" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Jitters" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Response_Time_List" minOccurs="0"/>
 *         &lt;element name="Local_Miss_Ratios" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Miss_Ratio_List" minOccurs="0"/>
 *         &lt;element name="Global_Miss_Ratios" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Global_Miss_Ratio_List" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Event_Name" use="required" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Identifier" />
 *       &lt;attribute name="Worst_Local_Response_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Avg_Local_Response_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Best_Local_Response_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Worst_Blocking_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Avg_Blocking_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Max_Preemption_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Suspension_Time" type="{http://mast.unican.es/xmlmast/xmlmast_1_4/Mast_Result}Time" />
 *       &lt;attribute name="Num_Of_Suspensions" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="Num_Of_Queued_Activations" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_Timing_Result", propOrder = {
    "worstGlobalResponseTimes",
    "avgGlobalResponseTimes",
    "bestGlobalResponseTimes",
    "jitters",
    "localMissRatios",
    "globalMissRatios"
})
public class SimulationTimingResult {

    @XmlElement(name = "Worst_Global_Response_Times")
    protected GlobalResponseTimeList worstGlobalResponseTimes;
    @XmlElement(name = "Avg_Global_Response_Times")
    protected GlobalResponseTimeList avgGlobalResponseTimes;
    @XmlElement(name = "Best_Global_Response_Times")
    protected GlobalResponseTimeList bestGlobalResponseTimes;
    @XmlElement(name = "Jitters")
    protected GlobalResponseTimeList jitters;
    @XmlElement(name = "Local_Miss_Ratios")
    protected MissRatioList localMissRatios;
    @XmlElement(name = "Global_Miss_Ratios")
    protected GlobalMissRatioList globalMissRatios;
    @XmlAttribute(name = "Event_Name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String eventName;
    @XmlAttribute(name = "Worst_Local_Response_Time")
    protected Double worstLocalResponseTime;
    @XmlAttribute(name = "Avg_Local_Response_Time")
    protected Double avgLocalResponseTime;
    @XmlAttribute(name = "Best_Local_Response_Time")
    protected Double bestLocalResponseTime;
    @XmlAttribute(name = "Worst_Blocking_Time")
    protected Double worstBlockingTime;
    @XmlAttribute(name = "Avg_Blocking_Time")
    protected Double avgBlockingTime;
    @XmlAttribute(name = "Max_Preemption_Time")
    protected Double maxPreemptionTime;
    @XmlAttribute(name = "Suspension_Time")
    protected Double suspensionTime;
    @XmlAttribute(name = "Num_Of_Suspensions")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numOfSuspensions;
    @XmlAttribute(name = "Num_Of_Queued_Activations")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numOfQueuedActivations;

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
     * Gets the value of the avgGlobalResponseTimes property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public GlobalResponseTimeList getAvgGlobalResponseTimes() {
        return avgGlobalResponseTimes;
    }

    /**
     * Sets the value of the avgGlobalResponseTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalResponseTimeList }
     *     
     */
    public void setAvgGlobalResponseTimes(GlobalResponseTimeList value) {
        this.avgGlobalResponseTimes = value;
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
     * Gets the value of the localMissRatios property.
     * 
     * @return
     *     possible object is
     *     {@link MissRatioList }
     *     
     */
    public MissRatioList getLocalMissRatios() {
        return localMissRatios;
    }

    /**
     * Sets the value of the localMissRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link MissRatioList }
     *     
     */
    public void setLocalMissRatios(MissRatioList value) {
        this.localMissRatios = value;
    }

    /**
     * Gets the value of the globalMissRatios property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalMissRatioList }
     *     
     */
    public GlobalMissRatioList getGlobalMissRatios() {
        return globalMissRatios;
    }

    /**
     * Sets the value of the globalMissRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalMissRatioList }
     *     
     */
    public void setGlobalMissRatios(GlobalMissRatioList value) {
        this.globalMissRatios = value;
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
     * Gets the value of the avgLocalResponseTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvgLocalResponseTime() {
        return avgLocalResponseTime;
    }

    /**
     * Sets the value of the avgLocalResponseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvgLocalResponseTime(Double value) {
        this.avgLocalResponseTime = value;
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
     * Gets the value of the avgBlockingTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvgBlockingTime() {
        return avgBlockingTime;
    }

    /**
     * Sets the value of the avgBlockingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvgBlockingTime(Double value) {
        this.avgBlockingTime = value;
    }

    /**
     * Gets the value of the maxPreemptionTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxPreemptionTime() {
        return maxPreemptionTime;
    }

    /**
     * Sets the value of the maxPreemptionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxPreemptionTime(Double value) {
        this.maxPreemptionTime = value;
    }

    /**
     * Gets the value of the suspensionTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSuspensionTime() {
        return suspensionTime;
    }

    /**
     * Sets the value of the suspensionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSuspensionTime(Double value) {
        this.suspensionTime = value;
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

    /**
     * Gets the value of the numOfQueuedActivations property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumOfQueuedActivations() {
        return numOfQueuedActivations;
    }

    /**
     * Sets the value of the numOfQueuedActivations property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumOfQueuedActivations(BigInteger value) {
        this.numOfQueuedActivations = value;
    }

}