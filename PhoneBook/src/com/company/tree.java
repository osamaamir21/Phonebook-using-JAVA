package com.company;

import java.util.TreeMap;
import java.io.File;
import java.util.*;
public class tree {

    private static String DATA_FILE_NAME = ".txt";
    static String name;
    public static String number;
    public static TreeMap<String,String> phoneBook = new TreeMap<String,String>();
    public static boolean changed = false;
    File userHomeDirectory = new File( System.getProperty("user.home") );
    File dataFile = new File( userHomeDirectory, DATA_FILE_NAME );

}
