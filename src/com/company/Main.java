package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;  
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String alltext = urlToString("http://erdani.com/tdpl/hamlet.txt");

        String p = "Prince";
        int counter=0;

        String[] arr = alltext.split("[\\p{Punct}\\s]+");

        for(int a=0;a<arr.length;a++)
        {
            if(arr[a].equalsIgnoreCase("Prince"))
            {counter++;}
        }

        System.out.println(counter);

    }
}
