
package rs.ac.bg.fon.silab.server.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.bg.fon.silab.server.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessRequestResponse_QNAME = new QName("http://web.server.silab.fon.bg.ac.rs/", "processRequestResponse");
    private final static QName _ProcessRequest_QNAME = new QName("http://web.server.silab.fon.bg.ac.rs/", "processRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.bg.fon.silab.server.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessRequestResponse }
     * 
     */
    public ProcessRequestResponse createProcessRequestResponse() {
        return new ProcessRequestResponse();
    }

    /**
     * Create an instance of {@link ProcessRequest }
     * 
     */
    public ProcessRequest createProcessRequest() {
        return new ProcessRequest();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link ResponseObject }
     * 
     */
    public ResponseObject createResponseObject() {
        return new ResponseObject();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link FieldArray }
     * 
     */
    public FieldArray createFieldArray() {
        return new FieldArray();
    }

    /**
     * Create an instance of {@link RequestObject }
     * 
     */
    public RequestObject createRequestObject() {
        return new RequestObject();
    }

    /**
     * Create an instance of {@link Matrix }
     * 
     */
    public Matrix createMatrix() {
        return new Matrix();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.server.silab.fon.bg.ac.rs/", name = "processRequestResponse")
    public JAXBElement<ProcessRequestResponse> createProcessRequestResponse(ProcessRequestResponse value) {
        return new JAXBElement<ProcessRequestResponse>(_ProcessRequestResponse_QNAME, ProcessRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.server.silab.fon.bg.ac.rs/", name = "processRequest")
    public JAXBElement<ProcessRequest> createProcessRequest(ProcessRequest value) {
        return new JAXBElement<ProcessRequest>(_ProcessRequest_QNAME, ProcessRequest.class, null, value);
    }

}
