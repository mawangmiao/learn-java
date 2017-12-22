package com.example.demo;

class GCScope {
    GCScope t;
    static int iii = 1;

    public static void main(String args[]) {
        GCScope t1 = new GCScope();
        GCScope t2 = new GCScope();
        GCScope t3 = new GCScope();

        // 没有对象符合GC
        t1.t = t2; // 没有对象符合GC
        t2.t = t3; // 没有对象符合GC
        t3.t = t1; // 没有对象符合GC

        t1 = null;
        // 没有对象符合GC (t3.t 仍然有一个到 t1 的引用)

        t2 = null;
        // 没有对象符合GC (t3.t.t 仍然有一个到 t2 的引用)

        t3 = null;
        // 所有三个对象都符合GC (它们中没有一个拥有引用。
        // 只有各对象的变量 t 还指向了彼此，
        // 形成了一个由对象组成的环形的岛，而没有任何外部的引用。)
    }

    protected void finalize() {
        System.out.println("Garbage collected from object" + iii);
        iii++;
    }
}
