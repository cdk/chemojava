/* $RCSfile$
 * $Author: mariobaseda $
 * $Date: 2007-01-03 17:57:14 +0100 (We, 03 Jan 2007) $
 * $Revision: 5602 $
 * 
 * Copyright (C) 2007 by Mario Baseda <mariobaseda@users.sourceforge.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */
package org.openscience.cdk.qsar.model.weka;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openscience.cdk.CDKTestCase;
import org.openscience.cdk.libio.weka.Weka;

/**
 * TestSuite that runs a test for the KmeansCluster
 *
 * @author Mario Baseda
 * @cdk.module test-qsar
 */
public class KmeansClusterTest extends CDKTestCase {

	/**
	 * Constructor of the KmeansClusterTest
	 */
	public KmeansClusterTest(){}

	/**
	 * A unit test suite for JUnit
	 *
	 * @return The test suite
	 */
	public static Test suite() {
		return new TestSuite(KmeansClusterTest.class);
	}

	/**
	 * @throws Exception
	 */
	public void testKmeansCluster_N() throws Exception{
		String[] options = {"-N", "3"};
		KmeansCluster test = new KmeansCluster();
		test.setOptions(options);
		int[] typAttrib = {Weka.NUMERIC, Weka.NUMERIC, Weka.NUMERIC};
		String[] classAttrib = {"A_", "B_", "C_"};
		double[][] x = {{10, 10, 10}, {10, -10, -10}, {-10, -10, -10},
				{11, 11, 11}, {11, -11, -11}, {-11, -11, -11}};
		Double[][] xD = new Double[x.length][x[0].length];
		for (int i = 0; i < xD.length; i++)
			for (int j = 0; j < xD[i].length; j++)
				xD[i][j] = new Double(x[i][j]);
		String[] y = {"A_", "B_", "C_", "A_", "B_", "C_"};
		String[] attrib = {"X1", "X2", "X3"};
		test.setData(attrib, typAttrib, classAttrib, y, xD);
		test.build();
		Double[][] newx = {
				{new Double(99), new Double(89), new Double(79)},
				{new Double(19), new Double(29), new Double(39)},
		};
		test.setParameters(newx);
		test.clusterInstance();;
		assertNotNull (test.getClusterInstance());
		assertNotNull (test.getClusterCentroids());
		assertEquals(3.0, Math.rint(test.getSquaredError()), 0.01);
		assertNotNull (test.getClusterStandardDevs());
		assertNotNull (test.getClusterSizes());
		assertEquals(3, test.numberOfCluster());
	}

	/**
	 * @throws Exception
	 */
	public void testKmeansCluster_S() throws Exception{
		String[] options = {"-S", "4"};
		KmeansCluster test = new KmeansCluster();
		test.setOptions(options);
		int[] typAttrib = {Weka.NUMERIC, Weka.NUMERIC, Weka.NUMERIC};
		String[] classAttrib = {"A_", "B_", "C_"};
		double[][] x = {{10, 10, 10}, {10, -10, -10}, {-10, -10, -10},
				{11, 11, 11}, {11, -11, -11}, {-11, -11, -11}};
		Double[][] xD = new Double[x.length][x[0].length];
		for (int i = 0; i < xD.length; i++)
			for (int j = 0; j < xD[i].length; j++)
				xD[i][j] = new Double(x[i][j]);
		String[] y = {"A_", "B_", "C_", "A_", "B_", "C_"};
		String[] attrib = {"X1", "X2", "X3"};
		test.setData(attrib, typAttrib, classAttrib, y, xD);
		test.build();
		Double[][] newx = {
				{new Double(99), new Double(89), new Double(79)},
				{new Double(19), new Double(29), new Double(39)},
		};
		test.setParameters(newx);
		test.clusterInstance();
		assertNotNull (test.getClusterInstance());
		assertEquals(2, test.numberOfCluster());
		assertNotNull (test.getClusterCentroids());
		assertEquals(4.0, Math.rint(test.getSquaredError()), 0.01);
		assertNotNull (test.getClusterStandardDevs());
		assertNotNull (test.getClusterSizes());
	}
}
