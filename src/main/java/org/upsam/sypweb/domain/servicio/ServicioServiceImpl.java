package org.upsam.sypweb.domain.servicio;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.user.Role;
import org.upsam.sypweb.domain.user.User;
import org.upsam.sypweb.domain.user.UserDTO;
import org.upsam.sypweb.domain.user.UserRepository;
import org.upsam.sypweb.view.ServicioView;

@Transactional(readOnly = true)
@Service
public class ServicioServiceImpl implements ServicioService {
	/**
	 * Repositorio de la entidad {@link Servicio}
	 */
	private ServicioRepository servicioRepository;
	/**
	 * Convierte objeto de tipo {@link Servicio} en objetos de tipo {@link ServicioView}
	 */
	private ServicioConverter servicioConverter;
	/**
	 * Repositorio de la entidad {@link User}
	 */
	private UserRepository userRepository;

	/**
	 * 
	 * @param servicioRepository
	 * @param servicioConverter
	 * @param userRepository
	 */
	@Inject
	public ServicioServiceImpl(ServicioRepository servicioRepository, ServicioConverter servicioConverter, UserRepository userRepository) {
		super();
		this.servicioRepository = servicioRepository;
		this.servicioConverter = servicioConverter;
		this.userRepository = userRepository;
	}

	@Override
	public List<ServicioView> getUsedUservicesBy(Mujer mujer) {
		List<Servicio> usedServices = servicioRepository.getUsedUservicesBy(mujer);
		return servicioConverter.convert(usedServices);
	}

	@Override
	public List<ServicioView> getServicesBy(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user != null) {
			if (Role.ROLE_ADMINISTRATIVO.equals(user.getAuthority())) {
				return servicioConverter.convert(servicioRepository.findAll());
				
			} else if (Role.ROLE_ESPECIALISTA.equals(user.getAuthority())) {
				QServicio servicio = QServicio.servicio;
				return servicioConverter.convert(servicioRepository.findAll(servicio.responsable.eq(user)));
			}
		}
		return servicioConverter.convert(servicioRepository.findAll());
	}

	@Override
	public UserDTO findUserByUserName(String userName) {
		return toUserDTO(userName, servicioRepository.findByResponsable(userRepository.findByUserName(userName)));
	}

	private UserDTO toUserDTO(String userName, Servicio servicio) {
		ServicioDTO servicioDTO = null;
		if (servicio != null) {
			servicioDTO = new ServicioDTO(servicio.getId(), servicio.getDescripcion());
		}
		return  new UserDTO(userName, servicioDTO);
	}

}
