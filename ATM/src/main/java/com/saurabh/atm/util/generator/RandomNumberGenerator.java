package com.saurabh.atm.util.generator;

/**
 * Created by saurabhkumar on 14/05/17.
 */
public class RandomNumberGenerator {

		public static Long generate() {
			return DateUtil.getCurrentDateInIST().getTime();
		}

}
