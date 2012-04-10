package org.upsam.sypweb.async.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.upsam.sypweb.domain.citas.CitaDTO;
import org.upsam.sypweb.email.ConcejaliaMailingService;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) }, 
		mappedName = "jms/ConcejaliaQueue")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class NotificationProcessor implements MessageListener {
	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(NotificationProcessor.class.getName());
	/**
	 * Servicío de mensajería de la concejalía
	 */
	private ConcejaliaMailingService concejaliaMailingService;
	
	@Override
	public void onMessage(Message message) {
		ObjectMessage msj = (ObjectMessage) message;
		try {
			CitaDTO cita = (CitaDTO) msj.getObject();
			concejaliaMailingService.sendAppointmentConfirmation(cita);
			
		} catch (JMSException e) {
			logger.log(Level.INFO, "Se produjo un error al obtener el mensaje de la cola", e);
		}
	}

	/**
	 * @param concejaliaMailingService the concejaliaMailingService to set
	 */
	@Inject
	public void setConcejaliaMailingService(ConcejaliaMailingService concejaliaMailingService) {
		this.concejaliaMailingService = concejaliaMailingService;
	}

}
