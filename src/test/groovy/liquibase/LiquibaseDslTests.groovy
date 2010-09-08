import groovy.util.GroovyTestCase
import liquibase.*
import liquibase.database.*
import liquibase.log.LogFactory;
import liquibase.dsl.command.MigrateCommand
import liquibase.dsl.properties.LbdslProperties as Props
import liquibase.parser.groovy.*
import java.sql.*
import groovy.sql.Sql

class LiquibaseDslTests extends GroovyTestCase {
	
	void drop(sql,tablenName) {
		try {
			sql.execute "drop table ${tableName}"
		} catch(Exception e) {}
	}
	
    void testUpdateShouldCreateTable() {
		def conn = DriverManager.getConnection("jdbc:mysql://localhost/mylab?user=root");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		def sql = new Sql(conn)
		
		drop(sql,"fail_continue_ran")
		drop(sql,"DATABASECHANGELOG")
		drop(sql,"DATABASECHANGELOGLOCK")
						
		System.properties["lbdsl.home"] = new File((String)System.properties["user.home"], (String)".lbdsl").canonicalPath

		def db =  DatabaseFactory.instance.findCorrectDatabaseImplementation(conn)
		def fileOpener = new FileSystemFileOpener()
		def liquibase = new LiquibaseDsl("./src/test/resources/changelog.groovy", fileOpener, db) //TODO: should use relative path
		
		liquibase.update(null)
		
		sql.eachRow("select * from fail_continue_ran") { }
	}
	
	
	void ignoreObjectAsMigration() {
		
		liquibase-dsl.update {
			
			changeSet(id:"create-tables",author:"fede") {
				User.create()
				PhoneNumber.create()
				
				User.phoneNumbers.create()
				
				User.firstName.renameTo("name") //create and drop
				User.lastName.renameTo("last") //creates and drop
				
				User.zipcode.drop()
			}
 			
		}
		
	}
}