import liquibase.DatabaseChangeLog;
import liquibase.FileOpener;
import liquibase.database.Database;

class LiquibaseWrapper {

	def database

	LiquibaseWrapper(Database database) {
		this.database = database
	}

	void makeInstanceChangeSet(instance) {
		def columns = instance.properties
		def tableName = instace.class.name
		
		/* Liquibase actions */ 
		
		def addColumn = { columnName,type-> 
			addColumn(tableName:tableName){
				column(name:columnName,type:type)
			}
		}
		def renameColumn = {}
		def modifyColumn = {}
		def dropColumn = {}
		def alterSequence = {}
		def createTable = {}
		def renameTable = {}
		def dropTable = {}
		
		def createView = {}
		def renameView = {}
		def mergeColumns = {}
		
	}
}