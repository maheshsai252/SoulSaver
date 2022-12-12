/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author maheshsai
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class FetchGeoService 
{
    static final String GEO_CODE_SERVER = "https://maps.googleapis.com/maps/api/geocode/json?";

//    public static void main(String[] args)
//    {
//        String code = "1600 Amphitheatre Parkway, Mountain View, CA";
//
//        String response = getLocation(code);
//        System.out.println(response);
//
//        String[] result = parseLocation(response);
//
//        System.out.println("Latitude: " + result[0]);
//        System.out.println("Longitude: " + result[1]);
//    }
     static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    public static String getLocation(String code)
    {
        String address = buildUrl(code);

        String content = null;

        try
        {
            URL url = new URL(address);

            InputStream stream = url.openStream();

            try
            {
                

                content = convertStreamToString(stream);
            }
            finally
            {
                stream.close();
            }

            return (String) content.toString();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static String buildUrl(String code)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(GEO_CODE_SERVER);

        builder.append("address=");
        builder.append(code.replaceAll(" ", "+"));
        builder.append("&sensor=false");
        builder.append("&key=AIzaSyDWiOF31Xvh-AiFoDQVIl2y_RBpuJzrLC8");
        
        return builder.toString();
    }

    public static String[] parseLocation(String response)
    {
        // Look for location using brute force.
        // There are much nicer ways to do this, e.g. with Google's JSON library: Gson
        //     https://sites.google.com/site/gson/gson-user-guide

        String[] lines = response.split("\n");

        String lat = null;
        String lng = null;

        for (int i = 0; i < lines.length; i++)
        {
            if ("\"location\" : {".equals(lines[i].trim()))
            {
                lat = getOrdinate(lines[i+1]);
                lng = getOrdinate(lines[i+2]);
                break;
            }
        }

        return new String[] {lat, lng};
    }

    private static String getOrdinate(String s)
    {
        String[] split = s.trim().split(" ");

        if (split.length < 1)
        {
            return null;
        }

        String ord = split[split.length - 1];

        if (ord.endsWith(","))
        {
            ord = ord.substring(0, ord.length() - 1);
        }

        // Check that the result is a valid double
        Double.parseDouble(ord);

        return ord;
    }
    public static double calculate(double lat2, double lon2) {
        double lat1 = 42.33;
        double lon1 = -71.08;
        
     double earthRadius = 6371000; //meters
    double dLat = Math.toRadians(lat2-lat1);
    double dLng = Math.toRadians(lon2-lon1);
    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    float dist = (float) (earthRadius * c);

    return dist*0.000621371;
    }
    public static double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }
    
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    public static double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }
    
}
