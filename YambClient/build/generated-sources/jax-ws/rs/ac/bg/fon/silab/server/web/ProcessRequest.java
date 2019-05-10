
package rs.ac.bg.fon.silab.server.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://web.server.silab.fon.bg.ac.rs/}requestObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processRequest", propOrder = {
    "name"
})
public class ProcessRequest {

    protected RequestObject name;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link RequestObject }
     *     
     */
    public RequestObject getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestObject }
     *     
     */
    public void setName(RequestObject value) {
        this.name = value;
    }

}
