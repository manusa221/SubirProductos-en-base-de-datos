
public class usuario {//creo una clase de usuario//
	
	protected String usuario;
	protected String password;
	
	public usuario () {//constructor//
		
		this.usuario="";
		this.password="";
	}
	// sobrecarga del constructor//
    public usuario (String u, String p) {
		
		this.usuario=u;
		this.password=p;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
