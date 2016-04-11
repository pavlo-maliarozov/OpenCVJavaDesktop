package main;

import org.opencv.core.Core;

class App {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        new LeafDetectDemo().run();
    }
}

