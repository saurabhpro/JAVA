/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.a_creational.d_factory;

import java.util.Calendar;

import static java.util.Calendar.*;

public class FactoryEverydayDemo {

    public static void main(String args[]) {

        Calendar cal = Calendar.getInstance();
        //Calendar cal = Calendar.get

        System.out.println(cal);

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));


        //after java 8, calender has builders
        Calendar cal2 = new Builder().setCalendarType("japanese").setFields(YEAR, 1, DAY_OF_YEAR, 1).build();
        System.out.println(cal2);
        cal2 = new Builder().setCalendarType("iso8601").setWeekDate(2013, 1, MONDAY).build();
        System.out.println(cal2);
    }

}
