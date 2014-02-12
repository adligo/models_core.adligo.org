package org.adligo.models.core.shared;

import java.io.Serializable;

import org.adligo.i.util.shared.I_Immutable;

public class CommandToken implements I_Immutable {
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
