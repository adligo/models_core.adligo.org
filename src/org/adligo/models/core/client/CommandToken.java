package org.adligo.models.core.client;

import java.io.Serializable;

import org.adligo.i.util.client.I_Immutable;

public class CommandToken implements Serializable, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommandTokenMutant mutant = null;

	public CommandToken() {
		mutant = new CommandTokenMutant();
	}
	
	public CommandToken(I_CommandToken other) {
		mutant = new CommandTokenMutant(other);
	}
	
	public CommandToken(String command, Serializable other) {
		mutant = new CommandTokenMutant();
		mutant.setCommand(command);
		mutant.setData(other);
	}
	
	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}

	public Serializable getData() {
		return mutant.getData();
	}

	public String getCommand() {
		return mutant.getCommand();
	}
	
}
