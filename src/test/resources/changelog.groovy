// The overall database change log
databaseChangeLog(logicalFilePath:'Demo-autobase') { 
 // includeAll('./migrations')
	
	changeSet( id: "failContinuePrecondition", author: "nvoxland" ){
		createTable( tableName: "fail_continue_ran" )	{
			column( name: "id", type: "int" )
		}
	}
	
}
