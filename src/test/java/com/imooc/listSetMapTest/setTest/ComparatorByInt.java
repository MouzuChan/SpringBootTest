package com.imooc.listSetMapTest.setTest;

import java.util.Comparator;

public class ComparatorByInt implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		if (a > b)
            return 1;
        else if (a == b)
            return 0;
        else
            return -1;
	}

}
