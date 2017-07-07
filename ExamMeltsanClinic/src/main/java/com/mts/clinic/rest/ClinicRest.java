package com.mts.clinic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mts.clinic.service.ClinicServiceImpl;
import com.mts.clinic.vo.CiudadMunicipioVO;
import com.mts.clinic.vo.DoctorVO;
import com.mts.clinic.vo.PacientesVO;
import com.mts.domain.CommonRequestCelula;
import com.mts.domain.CommonRequestDireccion;
import com.mts.domain.CommonRequestPaciente;
import com.mts.domain.CommonResponse;







@Component
@Path("client")
public class ClinicRest {
	
	@Autowired
    private ClinicServiceImpl clinicService;
	

	private static final Logger LOG = Logger.getLogger(ClinicRest.class);
	
	@POST
	@Path("pacientes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PacientesVO> pacientes(){
	    LOG.debug("ENTRADA DE VALOR PARA LA VENTANA DE USUARIO");	    
		return clinicService.pacientes();
	}
	@POST
	@Path("doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorVO> doctor(){
	    LOG.debug("ENTRADA DE VALOR PARA LA VENTANA DE USUARIO");	    
		return clinicService.medicos();
	}
	
	@POST
	@Path("ciudad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CiudadMunicipioVO> ciudad(){
	    LOG.debug("traer la lista de las ciudades o municipios");	    
		return clinicService.ciudad();
	}
	
	@POST
	@Path("pacientesInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PacientesVO pacientesInfo(){
	    LOG.debug("ENTRADA DE VALOR PARA LA VENTANA DE USUARIO");
	    PacientesVO o= new PacientesVO();
		return o;
	}
	
	
	@POST
	@Path("insertDomicilio")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse insertDirre(CommonRequestDireccion params){
		
		CommonResponse respuesta = new CommonResponse();
	
		
		
		if (LOG.isDebugEnabled()){
			LOG.debug("MENSAJE CON LOG4J");
			LOG.debug(params.getCalle());
			LOG.debug(params.getColonia());
		}
		
		try{
			clinicService.inserDomicilio(params);		
			respuesta.setSuccess(true);
			respuesta.setMensaje("Se agrego Domicilio");
		}catch (Exception e) {
			// TODO: handle exception
			respuesta.setSuccess(false);
			respuesta.setMensaje("No se pudo agregar a ocurrido un error: "+ e.getMessage());
		}


		return respuesta;		
	}
	@POST
	@Path("insertCelula")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse insertCelu(CommonRequestCelula params){
		
		CommonResponse respuesta = new CommonResponse();
		if (LOG.isDebugEnabled()){
			LOG.debug("MENSAJE CON LOG4J");
			LOG.debug(params.getCurp());
			LOG.debug(params.getNombre());
		}
		
		try{
			clinicService.insertCelula(params);		
			respuesta.setSuccess(true);
			respuesta.setMensaje("Se agrego celula");
		}catch (Exception e) {
			// TODO: handle exception
			respuesta.setSuccess(false);
			respuesta.setMensaje("No se pudo agregar a ocurrido un error: "+ e.getMessage());
		}


		return respuesta;		
	}
	@POST
	@Path("insertPaciente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse insertPaciente(CommonRequestPaciente params){
		
		CommonResponse respuesta = new CommonResponse();
		if (LOG.isDebugEnabled()){
			LOG.debug("MENSAJE CON LOG4J");
			LOG.debug(params.getNombre());
			LOG.debug(params.getTelefono());
		}
		
		try{
			clinicService.insertPaciente(params);		
			respuesta.setSuccess(true);
			respuesta.setMensaje("Se agrego paciente");
		}catch (Exception e) {
			// TODO: handle exception
			respuesta.setSuccess(false);
			respuesta.setMensaje("No se pudo agregar a ocurrido un error: "+ e.getMessage());
		}


		return respuesta;		
	}
	public ClinicServiceImpl getClinicService() {
		return clinicService;
	}

	public void setClinicService(ClinicServiceImpl clinicService) {
		this.clinicService = clinicService;
	}
  
}
