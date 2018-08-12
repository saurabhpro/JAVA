/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.a_creational.b_builder.myLunchBuilder;

@SuppressWarnings("ALL")
public class LunchOrderBuilder {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBuilder() {
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

//	LunchOrder build() {
//		return new LunchOrder(this);
//	}

    LunchOrderBuilder addBread(String bread) {
        this.bread = bread;
        return this;        //so that can be chained
    }

    LunchOrderBuilder addCondiments(String condiments) {
        this.condiments = condiments;
        return this;
    }

    LunchOrderBuilder addDressing(String dressing) {
        this.dressing = dressing;
        return this;
    }

    LunchOrderBuilder addMeat(String meat) {
        this.meat = meat;
        return this;
    }

}

