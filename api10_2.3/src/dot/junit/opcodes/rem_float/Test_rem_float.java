/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dot.junit.opcodes.rem_float;

import dot.junit.DxTestCase;
import dot.junit.DxUtil;
import dot.junit.opcodes.rem_float.d.T_rem_float_1;
import dot.junit.opcodes.rem_float.d.T_rem_float_6;

public class Test_rem_float extends DxTestCase {

    /**
     * @title Arguments = 2.7f, 3.14f
     */
    public void testN1() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(2.7f, t.run(2.7f, 3.14f));
    }

    /**
     * @title Dividend = 0
     */
    public void testN2() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(0f, t.run(0, 3.14f));
    }

    /**
     * @title Dividend is negative
     */
    public void testN3() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(-0.44000006f, t.run(-3.14f, 2.7f));
    }
    
    /**
     * @title Types of arguments - float, int. Dalvik doens't distinguish 32-bits types internally,
     * so this operation of float and int makes no sense but shall not crash the VM.  
     */
    public void testN4() {
        T_rem_float_6 t = new T_rem_float_6();
        try {
            t.run(3.14f, 15);
        } catch (Throwable e) {
        }
    }

    /**
     * @title Arguments = Float.MAX_VALUE, Float.NaN
     */
    public void testB1() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(Float.NaN, t.run(Float.MAX_VALUE, Float.NaN));
    }

    /**
     * @title Arguments = Float.POSITIVE_INFINITY,
     * Float.NEGATIVE_INFINITY
     */
    public void testB2() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(Float.NaN, t.run(Float.POSITIVE_INFINITY,
                Float.NEGATIVE_INFINITY));
    }

    /**
     * @title Arguments = Float.POSITIVE_INFINITY, -2.7f
     */
    public void testB3() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(Float.NaN, t.run(Float.POSITIVE_INFINITY, -2.7f));
    }

    /**
     * @title Arguments = -2.7f, Float.NEGATIVE_INFINITY
     */
    public void testB4() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(-2.7f, t.run(-2.7f, Float.NEGATIVE_INFINITY));
    }

    /**
     * @title Arguments = 0, 0
     */
    public void testB5() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(Float.NaN, t.run(0, 0));
    }

    /**
     * @title Arguments = 0, -2.7
     */
    public void testB6() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(0f, t.run(0, -2.7f));
    }

    /**
     * @title Arguments = -2.7, 0
     */
    public void testB7() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(Float.NaN, t.run(-2.7f, 0));
    }

    /**
     * @title Arguments = 1, Float.MAX_VALUE
     */
    public void testB8() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(0f, t.run(1, Float.MIN_VALUE));
    }

    /**
     * @title Arguments = Float.MAX_VALUE, -1E-9f
     */
    public void testB9() {
        T_rem_float_1 t = new T_rem_float_1();
        assertEquals(7.2584893E-10f, t.run(Float.MAX_VALUE, -1E-9f));
    }
    
    /**
     * @constraint A23 
     * @title number of registers
     */
    public void testVFE1() {
        try {
            Class.forName("dot.junit.opcodes.rem_float.d.T_rem_float_2");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    

    /**
     * @constraint B1 
     * @title types of arguments - float, double
     */
    public void testVFE2() {
        try {
            Class.forName("dot.junit.opcodes.rem_float.d.T_rem_float_3");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B1 
     * @title types of arguments - long, float
     */
    public void testVFE3() {
        try {
            Class.forName("dot.junit.opcodes.rem_float.d.T_rem_float_4");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B1 
     * @title types of arguments - reference, float
     */
    public void testVFE4() {
        try {
            Class.forName("dot.junit.opcodes.rem_float.d.T_rem_float_5");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }
}
