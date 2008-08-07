/* $RCSfile$
 * $Author: egonw $
 * $Date: 2008-03-22 16:09:15 +0100 (Sat, 22 Mar 2008) $
 * $Revision: 10505 $
 *
 * Copyright (C) 2002-2007  The Chemistry Development Kit (CDK) project
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

package org.openscience.cdk.libio.joelib;

import joelib.molecule.JOEAtom;
import joelib.molecule.JOEBond;
import joelib.molecule.JOEMol;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openscience.cdk.Atom;
import org.openscience.cdk.Bond;
import org.openscience.cdk.Molecule;
import org.openscience.cdk.CDKTestCase;
import org.openscience.cdk.exception.NoSuchAtomException;
import org.openscience.cdk.isomorphism.IsomorphismTester;
import org.openscience.cdk.libio.joelib.Convertor;

/**
 * @cdk.module test-libio
 */
public class JOELibIOTest extends CDKTestCase {

    public JOELibIOTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(JOELibIOTest.class);
    }


    public void testAtom() {
        Atom a = new Atom("C");
        a.setX3d(1.0);
        a.setY3d(2.0);
        a.setZ3d(3.0);

        JOEAtom converted = Convertor.convert(a);
        Atom reverted = Convertor.convert(converted);

        assertEquals(a.getPoint3d(), reverted.getPoint3d());
    }

    public void testBond() {
        Atom a = new Atom("C");
        Atom b = new Atom("O");
        Bond bond = new Bond(a, b, IBond.Order.DOUBLE);

        JOEBond converted = Convertor.convert(bond);
        Bond reverted = Convertor.convert(converted);

        assertEquals(bond.getOrder(), reverted.getOrder());;
    }

    public void testBenzene() throws Exception {
        Molecule mol = new Molecule();
        mol.addAtom(new Atom("C")); // 0
        mol.addAtom(new Atom("C")); // 1
        mol.addAtom(new Atom("C")); // 2
        mol.addAtom(new Atom("C")); // 3
        mol.addAtom(new Atom("C")); // 4
        mol.addAtom(new Atom("C")); // 5

        mol.addBond(0, 1, IBond.Order.SINGLE); // 1
        mol.addBond(1, 2, IBond.Order.DOUBLE); // 2
        mol.addBond(2, 3, IBond.Order.SINGLE); // 3
        mol.addBond(3, 4, IBond.Order.DOUBLE); // 4
        mol.addBond(4, 5, IBond.Order.SINGLE); // 5
        mol.addBond(5, 0, IBond.Order.DOUBLE); // 6

        JOEMol converted = Convertor.convert(mol);
        Molecule reverted = Convertor.convert(converted);

        assertEquals(mol.getAtomCount(), reverted.getAtomCount());
        assertEquals(mol.getBondCount(), reverted.getBondCount());

        IsomorphismTester it = new IsomorphismTester(mol);
        assertTrue(it.isIsomorphic(reverted));
    }

}
