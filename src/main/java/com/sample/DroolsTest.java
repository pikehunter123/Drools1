package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Caller message = new Caller("frp","tomcat",null);
            kSession.insert(message);
            kSession.fireAllRules(1);
            System.out.println("Result system name="+message.getSystem());            
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Caller {

    	public Caller(String principalName, String userAgent, String clientName) {
			super();
			this.principalName = principalName;
			this.userAgent = userAgent;
			this.clientName = clientName;
		}

		private String principalName;
        private String userAgent;
        private String clientName;

        private String system;

		public String getPrincipalName() {
			return principalName;
		}

		public void setPrincipalName(String principalName) {
			this.principalName = principalName;
		}

		public String getUserAgent() {
			return userAgent;
		}

		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}

		public String getClientName() {
			return clientName;
		}

		public void setClientName(String clientName) {
			this.clientName = clientName;
		}

		public String getSystem() {
			return system;
		}

		public void setSystem(String system) {
			this.system = system;
		}

        
    }

}
