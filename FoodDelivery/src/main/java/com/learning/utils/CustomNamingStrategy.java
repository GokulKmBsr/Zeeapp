package com.learning.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {
	
	private final static String POSTFIX ="_table";
	//by default all the tables should be ended with name _table.
	//we don't want to apply this _table for each and every spec
	//we want to set it as a thumb rule
	
	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		//return super.toPhysicalTableName(name, context);
		if(identifier==null) {
			return null;
		}
		final String newName = identifier.getText()+POSTFIX;
				//table name 1.if @table annotation 
		return identifier.toIdentifier(newName);
	}
	
	@Override
	public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		//return super.toPhysicalColumnName(name, context);
	
	if(identifier==null) {
		return null;
	}
	return Identifier.toIdentifier(identifier.getText().toLowerCase());
	}

}
