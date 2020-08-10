package com.db.constants;

public interface ApplicationConstants {
	
	public final String MYSQL_PROPERTIES_PREFIX="db1.datasource"; 
	public final String MYSQL_HIBERNATE_DIALECT="org.hibernate.dialect.MySQL5Dialect";
	public final String MYSQL_DOMAIN_PACKAGES="com.db.domain.mysql";
	public final String MYSQL_PERSISTENCE_UNIT="mysql";
	
	public final String POSTGRE_PROPERTIES_PREFIX="db2.datasource"; 
	public final String POSTGRE_HIBERNATE_DIALECT="org.hibernate.dialect.PostgreSQLDialect";
	public final String POSTGRE_DOMAIN_PACKAGES="com.db.domain.postgre";
	public final String POSTGRE_PERSISTENCE_UNIT="postgre";
	
	public final String HIBERNATE_HBM2DDL_PROPERTY="update";
	
}