It is simple test automation framework
you can run it using command line - mvn clean test (chrome and local.properties will load by default)
if you want to use another browser and another properties you should use this command line for example - mvn clean test -Dtarget=qa -Dselenide.browser=firefox 