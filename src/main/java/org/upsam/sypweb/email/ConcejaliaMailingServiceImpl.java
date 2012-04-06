package org.upsam.sypweb.email;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.upsam.sypweb.domain.citas.CitaDTO;

@Component
public class ConcejaliaMailingServiceImpl implements ConcejaliaMailingService {

	/**
	 * Servicio de envío de mails
	 */
	private JavaMailSender mailSender;
	/**
	 * Plantilla de mails
	 */
	private VelocityEngine velocityEngine;

	/**
	 * @param mailSender
	 * @param templateMessage
	 */
	@Inject
	public ConcejaliaMailingServiceImpl(JavaMailSender mailSender, VelocityEngine velocityEngine) {
		super();
		this.mailSender = mailSender;
		this.velocityEngine = velocityEngine;
	}

	@Override
	public void sendAppointmentConfirmation(final CitaDTO cita) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setSubject("Recordatorio de su cita");
				message.setTo(cita.getEmail());
				message.setFrom("administrador@concejalia.es");
				Map<String, CitaDTO> model = new HashMap<String, CitaDTO>();
				model.put("cita", cita);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email/appointment-confirmation.vm", "UTF-8", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);

	}

}
