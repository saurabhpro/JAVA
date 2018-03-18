/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special;
/**
 * Created by Saurabh on 12/17/2016.
 */
public class InstanceFamily {

	private String m = msg("3");

	{
		m = msg("2");
	}

	InstanceFamily() {
		m = msg("1");
	}

	private static String msg(String msg) {
		System.out.println(msg);
		return msg;
	}

	public static void main(String[] args) {
		InstanceFamily o = new InstanceFamily();
		System.out.println(o.m);
	}
}
/*
  {
  m = msg("2");
  }
  String m = msg("3");
  <p>
  translates to
  <p>
  String m = msg("2");
  <p>
  StaticFamily() {
  this.m = msg("3");
  }
 */
