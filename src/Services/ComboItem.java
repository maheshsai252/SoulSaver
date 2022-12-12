/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


/**
 *
 * @author maheshsai
 */
public class ComboItem
{
    private String key;
    private String value;

    public ComboItem(String cityName, String id)
    {
        this.key = cityName;
        this.value = id;
    }

   

   

 

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}