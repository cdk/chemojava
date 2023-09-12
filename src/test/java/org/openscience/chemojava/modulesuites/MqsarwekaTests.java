package org.openscience.chemojava.modulesuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openscience.chemojava.libio.weka.WekaTest;

/**
 * TestSuite that runs all the tests for the CDK reaction module.
 *
 * @cdk.module  test-qsarweka
 * @cdk.depends weka.jar
 * @cdk.depends junit.jar
 */
@RunWith(Suite.class)
@SuiteClasses({
    WekaTest.class
})
public class MqsarwekaTests {
    
}
