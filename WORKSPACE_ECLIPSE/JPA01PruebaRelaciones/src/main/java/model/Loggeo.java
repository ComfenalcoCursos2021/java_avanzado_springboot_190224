package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loggeo database table.
 * 
 */
@Entity
@NamedQuery(name="Loggeo.findAll", query="SELECT l FROM Loggeo l")
public class Loggeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nick;

	private String password;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public Loggeo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}