package liquibase.integration.groovy

class Main {
/*	
	static void migrate(appCtx) {
	  	appCtxHolder.set(appCtx)
	    boolean attachedSession = false
	    try {
	     	  attachedSession = attachHibernateSession()
		      assignSystemProperties();
		      def fileOpener = findFileOpener() 
		      log.debug("Using a file opener of type ${fileOpener?.class}")
		      Database db = getDatabase();
		      if(fileOpener.getResourceAsStream("./migrations/changelog.groovy")) {
		        new LiquibaseDsl("./migrations/changelog.groovy", fileOpener, db).update(null)
		      } else {
		        log.warn("No changelog found")
		      }
	    } catch(Exception e) {
			GrailsUtil.deepSanitize(e)
	      	throw e
	    } finally {
	      	if(attachedSession) {
		        try {
		          detachHibernateSession()
		        } catch(Exception e2) {
		          GrailsUtil.deepSanitize(e2)
		          log.error("Cannot detach the Hibernate session", e2)
		        }
		      }
		      appCtxHolder.set(null)
		    }
	  }*/
}