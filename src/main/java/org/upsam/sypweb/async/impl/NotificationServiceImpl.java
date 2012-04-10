package org.upsam.sypweb.async.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.upsam.sypweb.async.NotificationService;
import org.upsam.sypweb.domain.citas.CitaDTO;

@Service
public class NotificationServiceImpl implements NotificationService {
	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(NotificationServiceImpl.class.getName());
	/**
	 * Template de Spirng para el envío de mensajes
	 */
	private JmsTemplate jmsTemplate;
	/**
	 * Destino
	 */
	private Destination destination;

	/**
	 * @param jmsTemplate
	 * @param destination
	 */
	@Inject
	public NotificationServiceImpl(JmsTemplate jmsTemplate, Destination destination) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.destination = destination;
	}

	@Override
	public void sendAppointmentConfirmation(final CitaDTO cita) {
		try {
			jmsTemplate.send(destination, new MessageCreator() {
	
				@Override
				public Message createMessage(Session session) throws JMSException {
					ObjectMessage msg = session.createObjectMessage();
					msg.setObject(cita);
					return msg;
				}
			});
			
		} catch (JmsException e) {
			logger.log(Level.INFO, "Se produjo un error al envíar el mensaje a la cola", e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Se produjo un error no esperado", e);
		}
	}

}
