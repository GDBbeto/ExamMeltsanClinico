package com.mts.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.clinic.dao.ClinicDao;
import com.mts.clinic.vo.CiudadMunicipioVO;
import com.mts.clinic.vo.DoctorVO;
import com.mts.clinic.vo.PacientesVO;
import com.mts.domain.CommonRequestCelula;
import com.mts.domain.CommonRequestDireccion;
import com.mts.domain.CommonRequestPaciente;



@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicDao clientDao;
	
	
	public List<DoctorVO> medicos(){
		return clientDao.medicos();
	   }
	
	  public List<PacientesVO> pacientes(){
		return clientDao.pacientes();
	   }
	  public List<CiudadMunicipioVO> ciudad(){
		  return clientDao.ciudad();
	  }
	
	

	public ClinicDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClinicDao clientDao) {
		this.clientDao = clientDao;
	}
	
	public void inserDomicilio(CommonRequestDireccion params){
		clientDao.inserDomicilio(params);
	}
	public void insertCelula(CommonRequestCelula params){
		clientDao.insertCelula(params);
	}
	public void insertPaciente(CommonRequestPaciente params){
		clientDao.insertPaciente(params);
	}
	
}
