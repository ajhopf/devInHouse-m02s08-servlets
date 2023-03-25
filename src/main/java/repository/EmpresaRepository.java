package repository;

import java.util.ArrayList;

import model.EmpresaEx2;

public class EmpresaRepository {
	private static ArrayList<EmpresaEx2> empresas = new ArrayList<>();
	
	public static EmpresaEx2 getEmpresaById(Integer id) {
		return empresas.get(id);
	}
	
	public static boolean addEmpresa(EmpresaEx2 empresa) {
		return empresas.add(empresa);
	}
	
	public static ArrayList<EmpresaEx2> getEmpresas() {
		return empresas;
	}	
}
