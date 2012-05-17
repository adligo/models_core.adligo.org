package org.adligo.models.core.client;

import java.io.Serializable;

public class CommandTokenMutant implements Serializable, I_CommandToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Serializable data;
	private String command;
	
	public CommandTokenMutant() {}
	
	public CommandTokenMutant(I_CommandToken other) {
		data = other.getData();
		command = other.getCommand();
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_CommandToken#getData()
	 */
	@Override
	public Serializable getData() {
		return data;
	}
	public void setData(Serializable data) {
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_CommandToken#getCommand()
	 */
	@Override
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
}