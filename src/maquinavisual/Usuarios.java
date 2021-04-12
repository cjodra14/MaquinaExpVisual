package maquinavisual;

public class Usuarios {
	private int rowid;	
	private String nombre;
	private float saldo=0f;

	Usuarios(){
		
	}
	Usuarios(String n){
		nombre=n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public int getRowid() {
		return rowid;
	}
	public void setRowid(int rowid) {
		this.rowid = rowid;
	}
	

}
