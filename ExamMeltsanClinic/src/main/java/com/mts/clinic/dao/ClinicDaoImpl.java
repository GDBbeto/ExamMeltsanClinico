package com.mts.clinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import com.mts.clinic.vo.CiudadMunicipioVO;
import com.mts.clinic.vo.DoctorVO;
import com.mts.clinic.vo.PacientesVO;
import com.mts.domain.CommonRequestCelula;
import com.mts.domain.CommonRequestDireccion;
import com.mts.domain.CommonRequestPaciente;
import com.mts.domain.Jdbc;


public class ClinicDaoImpl extends Jdbc implements ClinicDao{

	private String qryPaciente;
	private String qryCiudadMunicipio;
	private String qryInsertDireccion;
	private String qryInsertCelula;
	private String qryInsertPaciente;
	private String qrySelectDoctor;

	
	@Override
	   public void inserDomicilio(CommonRequestDireccion params){
		   
	 	 this.jdbcTemplate.update(qryInsertDireccion,
	 			 new Object []{params.getCalle(),params.getColonia(),params.getId_ciudad()
	 					 });
	 	 
	   }
	
	@Override
	   public void insertCelula(CommonRequestCelula params){
		   
	 	 this.jdbcTemplate.update(qryInsertCelula,
	 			 new Object []{params.getNombre(), params.getApellidoPaterno(),params.getCurp(),params.getApellidoMaterno()	 					 
	 					 });
	 	 
	   }
	
	@Override
	   public void insertPaciente(CommonRequestPaciente params){
		   
	 	 this.jdbcTemplate.update(qryInsertPaciente,
	 			 new Object []{ params.getNombre(),params.getTelefono(),params.getActivo(),	 					 
	 					 });	 	 
	   }
	
	
	@Override
	   public List<CiudadMunicipioVO> ciudad(){
		System.out.println("ok");
		List<CiudadMunicipioVO> result =  this.jdbcTemplate.query(qryCiudadMunicipio,CIUDAD_MUN_MAPPER);
		return result;		   
	   }
	
	private static final RowMapper<CiudadMunicipioVO> CIUDAD_MUN_MAPPER = new RowMapper<CiudadMunicipioVO>() {
		@Override
		public CiudadMunicipioVO mapRow(ResultSet rs, int num) throws SQLException {
			CiudadMunicipioVO result = new CiudadMunicipioVO();
           
			result.setIdCiudadMun(rs.getString("ID_CIUDAD_MUNICIPIO"));
			result.setNombreMun(rs.getString("NOMBRE"));
		
			
			return result;
		}
	};
	
	@Override
	   public List<DoctorVO> medicos(){
		
		List<DoctorVO> result =  this.jdbcTemplate.query(qrySelectDoctor,DOCTOR_MAPPER);
		return result;		   
	   }
	
	@Override
	   public List<PacientesVO> pacientes(){
		
		List<PacientesVO> result =  this.jdbcTemplate.query(qryPaciente,PACIENTES_MAPPER);
		return result;		   
	   }
	
	
	private static final RowMapper<DoctorVO> DOCTOR_MAPPER = new RowMapper<DoctorVO>() {
		@Override
		public DoctorVO mapRow(ResultSet rs, int num) throws SQLException {
			DoctorVO result = new DoctorVO();
           
			result.setId_doctor(rs.getString("ID_DOCTOR"));
			result.setNombre(rs.getString("NOMBRE"));
			result.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
			result.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
			result.setTelefono(rs.getString("TELEFONO"));
			result.setNomEsp(rs.getString("NOM_ESP"));
			result.setCurp(rs.getString("CURP"));
			result.setDireccion(rs.getString("dire"));
			
			
			return result;
		}
	};
	
	
	private static final RowMapper<PacientesVO> PACIENTES_MAPPER = new RowMapper<PacientesVO>() {
		@Override
		public PacientesVO mapRow(ResultSet rs, int num) throws SQLException {
			PacientesVO result = new PacientesVO();
           
			result.setId(rs.getString("ID_PACIENTES"));
			result.setNombre(rs.getString("NOMBRE"));
			result.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
			result.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
			result.setTelefono(rs.getString("TELEFONO"));
			result.setCurp(rs.getString("CURP"));
			result.setDirecion(rs.getString("dire"));
			result.setIdCelula(rs.getString("ID_CELULA_IDENTIFICACION"));
			result.setIdDirecion(rs.getString("ID_DIRECCION"));
			
			return result;
		}
	};
	
	
	
	public String getQryPaciente() {
		return qryPaciente;
	}

	public void setQryPaciente(String qryPaciente) {
		this.qryPaciente = qryPaciente;
	}

	public String getQryCiudadMunicipio() {
		return qryCiudadMunicipio;
	}

	public void setQryCiudadMunicipio(String qryCiudadMunicipio) {
		this.qryCiudadMunicipio = qryCiudadMunicipio;
	}

	public String getQryInsertDireccion() {
		return qryInsertDireccion;
	}

	public void setQryInsertDireccion(String qryInsertDireccion) {
		this.qryInsertDireccion = qryInsertDireccion;
	}

	public String getQryInsertCelula() {
		return qryInsertCelula;
	}

	public void setQryInsertCelula(String qryInsertCelula) {
		this.qryInsertCelula = qryInsertCelula;
	}

	public String getQryInsertPaciente() {
		return qryInsertPaciente;
	}

	public void setQryInsertPaciente(String qryInsertPaciente) {
		this.qryInsertPaciente = qryInsertPaciente;
	}

	public String getQrySelectDoctor() {
		return qrySelectDoctor;
	}

	public void setQrySelectDoctor(String qrySelectDoctor) {
		this.qrySelectDoctor = qrySelectDoctor;
	}
	
	
	
	
	
	
}
