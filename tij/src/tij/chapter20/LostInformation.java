package tij.chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

public class LostInformation {
    public static void main(String[] args) {
        ArrayList<Frob> list = new ArrayList<>();
        HashMap<Frob, Fnorkle> map = new HashMap<>();
        Quark<Frob> quark = new Quark<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
    }
}
