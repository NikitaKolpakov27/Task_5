package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
		MyTree<Integer> mt = new MyTree<>();
		mt.add(20);
		mt.add(7);
		mt.add(4);
		mt.add(9);
		mt.add(6);
		mt.add(35);
		mt.add(31);
		mt.add(40);
		mt.add(28);
		mt.add(38);
		mt.add(52);
		//System.out.println(MyTree.maxLeaf);
		System.out.println(mt.findMaxLeaf());


    }
}
