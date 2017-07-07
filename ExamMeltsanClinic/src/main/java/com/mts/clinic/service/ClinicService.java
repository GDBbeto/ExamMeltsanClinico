package com.mts.clinic.service;

import java.util.List;

import com.mts.clinic.vo.CiudadMunicipioVO;
import com.mts.clinic.vo.DoctorVO;
import com.mts.clinic.vo.PacientesVO;



public interface ClinicService {
	List<PacientesVO> pacientes();
	List<DoctorVO> medicos();
	List<CiudadMunicipioVO> ciudad();
}
