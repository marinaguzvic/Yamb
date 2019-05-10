/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.web;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.server.logic.so.AbstractGenericSO;
import rs.ac.bg.fon.silab.server.logic.so.factory.SOFactory;

/**
 *
 * @author MARINA
 */
@WebService(serviceName = "YambService")
public class YambService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "processRequest")
    public ResponseObject processRequest(@WebParam(name = "name") RequestObject request) {
        AbstractGenericSO so = SOFactory.create(request);
        ResponseObject response = so.templateExecute(request);
        return response;
    }
}
