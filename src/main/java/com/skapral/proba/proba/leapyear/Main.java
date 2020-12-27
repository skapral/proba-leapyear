/*-
 * ===========================================================================
 * proba-leapyear
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2019 - 2020 Kapralov Sergey
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * ============================================================================
 */
package com.skapral.proba.proba.leapyear;


import com.pragmaticobjects.oo.memoized.chm.MemoryCHM;
import java.util.Scanner;


/**
 *
 * @author skapral
 */
public class Main {
    /*
    [args] > main
    [y] > leap
      or. > @
        and.
          eq. (mod. y 4) 0
          not. (eq. (mod. y 100) 0)
        eq. (mod. y 400) 0
    and > @
      stdout "Enter a year:"
      stdout
        sprintf
          "%s is %sa leap year!"
          (scanner stdin).nextInt > year!
          if (leap year:y) "" "not "
    */
    public static void main(String... args) {
        MemoryCHM memory = new MemoryCHM(); // a place where all memoized values are kept
        new CycledCheck(
            new LeapYearCheck(
                new UserYear(
                    new Scanner(System.in),
                    memory
                )
            ),
            memory
        ).execute();
    }
}
