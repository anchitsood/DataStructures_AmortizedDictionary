/* ////////////////////////////////////////////////////////////

File Name: Dictionary.java
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
 * Implementation of an Amortized Array-Based Dictionary data structure.
 *
 * This data structure supports duplicates and does *NOT* support storage of
 * null references.
 *
 * User ID(s): anchits
 *
 *****************************************************************************/


import static java.util.Arrays.binarySearch;
import java.util.Arrays;


public class Dictionary<E extends Comparable<E>>  implements DictionaryInterface<E>
{
	/*
	 * Keeps track of the number of elements in the dictionary.
	 * Take a look at the implementation of size()
	 */
	private int size;
	/*
	 * The head reference to the linked list of Nodes.
	 * Take a look at the Node class.
	 */
	private Node head;

	/**
	 * Creates an empty dictionary.
	 */
	public Dictionary()
	{
		size = 0;
		head = null;
	}

	/**
	 * Adds item to the dictionary, thus making contains(item) true.
	 * Increments size to ensure size() is correct.
	 */
	public void add(E item)
	{
		if(item == null)
		{
			throw new NullPointerException("Error passing null object to add");
		}

		/*
		 * Your code goes here...
		 */
		
		else
		{
			Comparable[] new_stuff = new Comparable[1];
			new_stuff[0] = item;
		    Node nd = new Node(new_stuff, null);
			nd.next = head;
			head = nd;
			size+=1;
			
			for (;;)
			{
				if (head.next==null)
				{
					break;
				}
				
				if (head.array.length == head.next.array.length)
				{
					mergeDown();
				}
				
				else
				{
					break;
				}
			}
		}

		//throw new RuntimeException("You need to implement this method!");
	}

	/**
	 * Starting with the smallest array, mergeDown() merges arrays of the same size together until
	 * all the arrays have different size.
	 *
	 * This is very useful for implementing add(item)!
	 */
	private void mergeDown()
	{
		/*
		 * Your code goes here...
		 */
		Comparable[] src1 = head.array;
		Comparable[] src2 = head.next.array;
		int m = src1.length;
		int i = 0, j = 0, k = 0;
		Comparable[] dest = new Comparable[2*m];
		
		while (i < m && j < m)
		{
			if (src1[i].compareTo((E)src2[j]) <= 0)
			{
				dest[k] = src1[i];
				++i;
			}
			else
			{
				dest[k] = src2[j];
				++j;
			}
			++k;
		}
		
		// The following code is not really needed since we append 2 arrays of equal size, but let's include it for the sake of completeness
		if (i < m) 
		{
            for (int p = i; p < m; p++) 
			{
                  dest[k] = src1[p];
                  k++;
            }
		} 
		else 
		{
            for (int p = j; p < m; p++) 
			{
                  dest[k] = src2[p];
                  k++;
            }
		}
		
		head.array = dest;
		head.next = head.next.next;
		

		//throw new RuntimeException("You need to implement this method!");
	}
	


	/**
	 * Returns true if the dictionary contains an element equal to item, otherwise- false.
	 * Use the method contains() in the Node class.
	 */
	public boolean contains(E item)
	{
		if(item == null)
		{
			throw new NullPointerException("Error passing null object to contain");
		}

		/*
		 * Your code goes here...
		 */

		Node nd = head;
		
		while(nd!=null)
		{
	        if (nd.contains(item))
	        {
				return true;
			}				
			    nd=nd.next;
	    }
	        return false;
		//traverse a node, if not found, traverse child
		//if found = true and break	
		
	}
		

	/**
	 * Returns the size of the dictionary.
	 */
	public int size()
	{
		size = sizeof(head);
		return size;
	}
	
	private int sizeof(Node nd)
	{
		int sizes = 0;
		if (nd != null)
		{
			sizes+=nd.array.length + sizeof(nd.next);
		}
		else
		{
			sizes = 0;
		}
		
		return sizes;
	}

	/**
	 * Returns a helpful string representation of the dictionary.
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		Node tmp = head;
		while(tmp != null)
		{
			sb.append(tmp.array.length + ": ");
			sb.append(tmp.toString());
			sb.append("\n");
			tmp = tmp.next;
		}
		return sb.toString();
	}



	/**
	 * Implementation of the underlying array-based data structure.
	 *
	 * You may add additional methods.
	 */
	@SuppressWarnings("unchecked")
	private static class Node
	{
		private Comparable[] array;
		private Node next;

		/**
		 * Creates an Node with the specified parameters.
		 */
		public Node(Comparable[] array, Node next)
		{
			this.array = array;
			this.next = next;
		}


		/**
		 * Returns	true, if there is an element in the array equal to item
		 * 			false, otherwise
		 */
		public boolean contains(Comparable item)
		{
			/*
			 * Your code goes here...
			 */
			int length = array.length;
	        int lo=0,hi=length-1,mid;
	        if (item.compareTo(array[0])<0 || item.compareTo(array[length-1])>0)
	        {
				return false;
			}
			
	        while(true)
			{       	                
	            mid=(hi+lo)/2;
	            if (item.compareTo(this.array[mid])<0)
				{
					hi=mid-1;
				}
	            
				else if (item.compareTo(this.array[mid])>0)
				{
					lo=mid+1;
				}
				
				else
	            {
					return true;
				}
	        }

			//throw new RuntimeException("You need to implement this method!");
		}
		
		public int arrsize()
		{
			return array.length;
		}

		/**
		 * Returns a useful representation of this Node.  (Note how this is used by Dictionary's toString()).
		 */
		public String toString()
		{
			return java.util.Arrays.toString(array);
		}
	}

}


