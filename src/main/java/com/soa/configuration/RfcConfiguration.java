/**
 * 
 */
package com.soa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soa.soap.RfcClient;

/**
 * 
 */
@Configuration
public class RfcConfiguration {

    /**
     * Creación del objeto para serializar/deserializar los objetos en el 
     * paquete definido y quedando registrado en el contexto de spring.
     * @return Objeto serializador.
     */
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soa.dto");
        return marshaller;
    }
    
    /**
     * Objeto que funge como cliente http para consumir el servicio definido
     * en la uri, y se le asigna el objeto encargadado de 
     * serializar/deserializar los objetos de request y response en el llamado.
     * @param marshaller
     * @return Objeto cliente SOAP para el servicio dado.
     */

    @Bean
    public RfcClient concatenarClient(Jaxb2Marshaller marshaller) {
        RfcClient client = new RfcClient();
        client.setDefaultUri("http://localhost:8080/rfc");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
