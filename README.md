# alshayatest

<h1> This is web based UI automation framework created using Java cucumber selenium with maven. </h1>

#All Dependencies and plugins are added to POM.xml

#This is Page object model framework with Page Factory implementation.

#Config related data is available in config.properties in "src/test/resources/config/config.properties"

#he feature files are in the location: "src/test/resources/features"

#To run the automation scripts there are multiple ways.

#1.From Runner class(PetTest.java) available in "src/test/java/TestRunner" as JUnit. Reports will be available in target/cucumber-report folder. The test runner runs the feature file based on the tag given

2.By maven command as : mvn clean compile mvn test

By running the feature file directly, right click on feature file and Run Note : Need to provide step definitions path as glue, in the Edit configurations. Once execution is done, report can be exported from Intellij editor.
