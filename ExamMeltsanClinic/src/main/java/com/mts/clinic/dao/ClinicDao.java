package com.mts.clinic.dao;

import java.util.List;

import com.mts.clinic.vo.CiudadMunicipioVO;
import com.mts.clinic.vo.DoctorVO;
import com.mts.clinic.vo.PacientesVO;
import com.mts.domain.CommonRequestCelula;
import com.mts.domain.CommonRequestDireccion;
import com.mts.domain.CommonRequestPaciente;



public interface ClinicDao {
	List<PacientesVO> pacientes();
	List<DoctorVO> medicos();
	List<CiudadMunicipioVO> ciudad();
	void inserDomicilio(CommonRequestDireccion params);
	void insertCelula(CommonRequestCelula params);
	void insertPaciente(CommonRequestPaciente params);
}
