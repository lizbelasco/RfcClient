/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.LizbethRequest;
import com.soa.dto.LizbethResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class RfcClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(RfcClient.class);

    public LizbethResponse execute() {

        LizbethRequest request = new LizbethRequest();
        request.setNombre("Lizbeth");
        request.setApellidoPaterno("Velasco");
        request.setApellidoMaterno("Ricardez");
        request.setFechaNacimiento("24/09/2001");

        log.info("Executing WS");

        LizbethResponse response = (LizbethResponse) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/rfc", request, 
                new SoapActionCallback("http://soa.com/LizbethRequest"));

        return response;
    }

}