
package rs.ac.bg.fon.silab.server.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dices" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="games" type="{http://web.server.silab.fon.bg.ac.rs/}game" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="matrix" type="{http://web.server.silab.fon.bg.ac.rs/}matrix" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="myResult" type="{http://web.server.silab.fon.bg.ac.rs/}result" minOccurs="0"/>
 *         &lt;element name="numberOfThrows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="opponentResults" type="{http://web.server.silab.fon.bg.ac.rs/}result" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseObject", propOrder = {
    "code",
    "dices",
    "games",
    "matrix",
    "message",
    "myResult",
    "numberOfThrows",
    "opponentResults"
})
public class ResponseObject {

    protected int code;
    @XmlElement(nillable = true)
    protected List<Integer> dices;
    @XmlElement(nillable = true)
    protected List<Game> games;
    protected Matrix matrix;
    protected String message;
    protected Result myResult;
    protected int numberOfThrows;
    @XmlElement(nillable = true)
    protected List<Result> opponentResults;

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

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
     * Gets the value of the games property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the games property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Game }
     * 
     * 
     */
    public List<Game> getGames() {
        if (games == null) {
            games = new ArrayList<Game>();
        }
        return this.games;
    }

    /**
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link Matrix }
     *     
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matrix }
     *     
     */
    public void setMatrix(Matrix value) {
        this.matrix = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the myResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getMyResult() {
        return myResult;
    }

    /**
     * Sets the value of the myResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setMyResult(Result value) {
        this.myResult = value;
    }

    /**
     * Gets the value of the numberOfThrows property.
     * 
     */
    public int getNumberOfThrows() {
        return numberOfThrows;
    }

    /**
     * Sets the value of the numberOfThrows property.
     * 
     */
    public void setNumberOfThrows(int value) {
        this.numberOfThrows = value;
    }

    /**
     * Gets the value of the opponentResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opponentResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpponentResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Result }
     * 
     * 
     */
    public List<Result> getOpponentResults() {
        if (opponentResults == null) {
            opponentResults = new ArrayList<Result>();
        }
        return this.opponentResults;
    }

}
