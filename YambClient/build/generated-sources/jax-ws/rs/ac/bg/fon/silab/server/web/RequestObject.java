
package rs.ac.bg.fon.silab.server.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dices" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="igraId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="korisnickoIme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selectedField" type="{http://web.server.silab.fon.bg.ac.rs/}field" minOccurs="0"/>
 *         &lt;element name="selectedGame" type="{http://web.server.silab.fon.bg.ac.rs/}game" minOccurs="0"/>
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestObject", propOrder = {
    "dices",
    "igraId",
    "korisnickoIme",
    "operation",
    "selectedField",
    "selectedGame",
    "sifra"
})
public class RequestObject {

    @XmlElement(nillable = true)
    protected List<Integer> dices;
    protected Long igraId;
    protected String korisnickoIme;
    protected String operation;
    protected Field selectedField;
    protected Game selectedGame;
    protected String sifra;

    /**
     * Gets the value of the dices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getDices() {
        if (dices == null) {
            dices = new ArrayList<Integer>();
        }
        return this.dices;
    }

    /**
     * Gets the value of the igraId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIgraId() {
        return igraId;
    }

    /**
     * Sets the value of the igraId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIgraId(Long value) {
        this.igraId = value;
    }

    /**
     * Gets the value of the korisnickoIme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Sets the value of the korisnickoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the selectedField property.
     * 
     * @return
     *     possible object is
     *     {@link Field }
     *     
     */
    public Field getSelectedField() {
        return selectedField;
    }

    /**
     * Sets the value of the selectedField property.
     * 
     * @param value
     *     allowed object is
     *     {@link Field }
     *     
     */
    public void setSelectedField(Field value) {
        this.selectedField = value;
    }

    /**
     * Gets the value of the selectedGame property.
     * 
     * @return
     *     possible object is
     *     {@link Game }
     *     
     */
    public Game getSelectedGame() {
        return selectedGame;
    }

    /**
     * Sets the value of the selectedGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Game }
     *     
     */
    public void setSelectedGame(Game value) {
        this.selectedGame = value;
    }

    /**
     * Gets the value of the sifra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

}
