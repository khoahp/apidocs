//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.10 at 11:39:38 AM ICT 
//


package org.mobilink.activity.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="participantNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="docFileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="docArchiveId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "percentage",
    "participantNote",
    "activityId",
    "docFileId",
    "docArchiveId"
})
@XmlRootElement(name = "AtvChecklistDoingInputModel")
public class AtvChecklistDoingInputModel {
	@FormParam("percentage")
    protected Long percentage;
	@FormParam("participantNote")
    protected String participantNote;
	@FormParam("activityId")
    protected Long activityId;
	@FormParam("docFileId")
    protected Long docFileId;
	@FormParam("docArchiveId")
    protected Long docArchiveId;

    /**
     * Gets the value of the percentage property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPercentage(Long value) {
        this.percentage = value;
    }

    /**
     * Gets the value of the participantNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantNote() {
        return participantNote;
    }

    /**
     * Sets the value of the participantNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantNote(String value) {
        this.participantNote = value;
    }

    /**
     * Gets the value of the activityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * Sets the value of the activityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActivityId(Long value) {
        this.activityId = value;
    }

    /**
     * Gets the value of the docFileId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocFileId() {
        return docFileId;
    }

    /**
     * Sets the value of the docFileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocFileId(Long value) {
        this.docFileId = value;
    }

    /**
     * Gets the value of the docArchiveId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocArchiveId() {
        return docArchiveId;
    }

    /**
     * Sets the value of the docArchiveId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocArchiveId(Long value) {
        this.docArchiveId = value;
    }

}
