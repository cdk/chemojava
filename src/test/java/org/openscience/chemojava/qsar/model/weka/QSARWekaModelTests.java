/* $RCSfile$
 * $Author: miguelrojasch $
 * $Date: 2006-05-11 14:25:07 +0200 (Do, 11 Mai 2006) $
 * $Revision: 6221 $
 *
 *  Copyright (C) 2004-2007  Miguel Rojas <miguel.rojas@uni-koeln.de>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA. 
 */
package org.openscience.chemojava.qsar.model.weka;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * TestSuite that runs all the tests for the CDK libio-weka module.
 *
 * @cdk.module test-qsar
 * @cdk.depends junit.jar
 */
@RunWith(Suite.class)
@SuiteClasses({
    J48WModelTest.class,
    LinearRegressionWModelTest.class,
    DensityBasedClustererModelTest.class,
    EMClusterTest.class,
    FilterSupervisedResampleTest.class,
    FilterUnSupervisedResampleTest.class,
    FilterSupervisedResampleTest.class,
    KmeansClusterTest.class,
    MultilayerPerceptronModelTest.class,
    NaiveBayesModelTest.class,
    SimpleLinearRegressionModelTest.class,
    SMOModelTest.class,
    SMOregModelTest.class
})
public class QSARWekaModelTests {

}
