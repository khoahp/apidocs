//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.02 at 02:30:27 PM ICT 
//


package org.mobilink.docfile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;


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
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="issuerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeNotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="promulgationDate " type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="signerInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="documentType " type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="register" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="registerDate " type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="seqNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "templateId",
    "issuerCode",
    "codeNo",
    "codeNotation",
    "promulgationDate0020",
    "signerInfo",
    "documentType0020",
    "typeName",
    "subject",
    "register",
    "registerDate0020",
    "seqNum",
    "dueDate",
    "status"
})
@XmlRootElement(name = "DocFileInputModel")
public class DocFileInputModel {

    protected long templateId;
    @XmlElement(required = true)
    protected String issuerCode;
    @XmlElement(required = true)
    protected String codeNo;
    @XmlElement(required = true)
    protected String codeNotation;
    @XmlElement(name = "promulgationDate ", required = true)
    @XmlSchemaType(name = "date")
    protected Date promulgationDate0020;
    @XmlElement(required = true)
    protected String signerInfo;
    @XmlElement(name = "documentType ")
    protected int documentType0020;
    @XmlElement(required = true)
    protected String typeName;
    @XmlElement(required = true)
    protected String subject;
    protected int register;
    @XmlElement(name = "registerDate ", required = true)
    @XmlSchemaType(name = "date")
    protected Date registerDate0020;
    protected int seqNum;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date dueDate;
    @XmlElement(required = true)
    protected String status;

    /**
     * Gets the value of the templateId property.
     * 
     */
    public long getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     */
    public void setTemplateId(long value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the issuerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerCode() {
        return issuerCode;
    }

    /**
     * Sets the value of the issuerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerCode(String value) {
        this.issuerCode = value;
    }

    /**
     * Gets the value of the codeNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNo() {
        return codeNo;
    }

    /**
     * Sets the value of the codeNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNo(String value) {
        this.codeNo = value;
    }

    /**
     * Gets the value of the codeNotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNotation() {
        return codeNotation;
    }

    /**
     * Sets the value of the codeNotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNotation(String value) {
        this.codeNotation = value;
    }

    /**
     * Gets the value of the promulgationDate0020 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getPromulgationDate_0020() {
        return promulgationDate0020;
    }

    /**
     * Sets the value of the promulgationDate0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPromulgationDate_0020(Date value) {
        this.promulgationDate0020 = value;
    }

    /**
     * Gets the value of the signerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerInfo() {
        return signerInfo;
    }

    /**
     * Sets the value of the signerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerInfo(String value) {
        this.signerInfo = value;
    }

    /**
     * Gets the value of the documentType0020 property.
     * 
     */
    public int getDocumentType_0020() {
        return documentType0020;
    }

    /**
     * Sets the value of the documentType0020 property.
     * 
     */
    public void setDocumentType_0020(int value) {
        this.documentType0020 = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the register property.
     * 
     */
    public int getRegister() {
        return register;
    }

    /**
     * Sets the value of the register property.
     * 
     */
    public void setRegister(int value) {
        this.register = value;
    }

    /**
     * Gets the value of the registerDate0020 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getRegisterDate_0020() {
        return registerDate0020;
    }

    /**
     * Sets the value of the registerDate0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegisterDate_0020(Date value) {
        this.registerDate0020 = value;
    }

    /**
     * Gets the value of the seqNum property.
     * 
     */
    public int getSeqNum() {
        return seqNum;
    }

    /**
     * Sets the value of the seqNum property.
     * 
     */
    public void setSeqNum(int value) {
        this.seqNum = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(Date value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}