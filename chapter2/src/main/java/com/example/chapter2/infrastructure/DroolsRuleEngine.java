package com.example.chapter2.infrastructure;

public class DroolsRuleEngine {
    private KieContainer kContainer;

    public DroolsRuleEngine() {
        KieServices ks = KieServices.Factory.get();
        KContainer = ks.getKieClasspathContainer();
    }

    public void evaluate(String sessionName, List<?> facts) {
        KieSession kSession = kContainer.newKieSession(sessionName);
        try {
            facts.forEach(x -> kSession.insert(x));
            kSession.fieAllRules();
        } finally {
            kSession.dispose();
        }
    }
}
