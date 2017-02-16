/* ////////////////////////////////////////////////////////////

File Name: TestingDriver.java
Copyright (c) 2016 Anchit Sood (sood.anchit@gmail.com).  All rights reserved.


Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, 
   this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.


This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

//////////////////////////////////////////////////////////// */



/**
 ******************************************************************************
 *                    Amortized Dictionary
 ******************************************************************************
 *
 * A diagnostic class for your Dictionary implementation.
 *
 * This class uses Java Exceptions and Reflections to
 * emulate the functionality of JUnit testing.
 *
 *****************************************************************************/


public class TestingDriver
{
	public static void simpleAddTest()
	{
		try
		{

			Dictionary<Integer> d = new Dictionary<Integer>();
			d.add(1);
			if(!d.toString().equals("1: [1]\n"))
			{
				throw new Exception();
			}
			d.add(2);
			if(!d.toString().equals("2: [1, 2]\n"))
			{
				throw new Exception();
			}
			d.add(3);
			if(!d.toString().equals("1: [3]\n2: [1, 2]\n"))
			{
				throw new Exception();
			}
			d = new Dictionary<Integer>();
			for(int n = 1; n <= 16; n++)
			{
				d.add(n);
			}
			if(!d.toString().equals("16: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]\n"))
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Your add(e) definitely isn't working.");
		}
	}


	public static void simpleContainsTest()
	{
		try
		{
			Dictionary<Integer> d = new Dictionary<Integer>();
			if(d.contains(1) != false)
			{
				throw new Exception();
			}
			d.add(1);
			if(d.contains(1) != true || d.contains(2) != false)
			{
				throw new Exception();
			}
			d.add(2);
			if(d.contains(1) != true || d.contains(2) != true || d.contains(3) != false)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Your contains(e) definitely isn't working.");
		}
	}


	public static void simpleSizeTest()
	{
		try
		{
			Dictionary<Integer> d = new Dictionary<Integer>();
			for(int n = 1; n <= 100; n++)
			{
				if(d.size() != n-1)
				{
					throw new Exception();
				}
				d.add(n);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Your size() definitely isn't working.");
		}
	}


	// public static void main(String[] args)
	// {
		// boolean passedAllTests = true;

		// Class<?> c = null;
		// try
		// {
			// c = Class.forName("TestingDriver");
		// }
		// catch (ClassNotFoundException e1)
		// {
			// System.out.println("Something is wrong with your computer ... TestingDriver.java cannot be accessed.");
		// }

		// for(java.lang.reflect.Method m : c.getDeclaredMethods())
		// {
			// if(m.getName().indexOf("Test") == -1)
			// {
				// continue;
			// }

			// try
			// {
				// m.invoke(null);
			// }
			// catch(Exception e)
			// {
				// System.out.println(e.getCause().getMessage());
				// passedAllTests = false;
			// }
		// }

		// System.out.println();
		// if(passedAllTests)
		// {
			// System.out.println("Looks good!  Make sure you do more rigorous testing.");
		// }
		// else
		// {
			// System.out.println("Try to fix the above problems.");
		// }

	// }
	


	public static void main(String[] args)
	{
			Dictionary<Integer> d = new Dictionary<Integer>();
			
			for (int i = 1; i <= 100; ++i)
			{
				d.add(i);
			}
			System.out.println(d.toString());
			System.out.println(d.size());
	}	

	
}
