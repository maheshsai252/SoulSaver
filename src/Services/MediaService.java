/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import javax.imageio.ImageIO;
/**
 *
 * @author maheshsai
 */
public class MediaService {
    public void saveImage(BufferedImage i, String id) {
        FileWriter csvWriter;
        String afilePath = new File("").getAbsolutePath();
        String filePath =  afilePath+"/src/data/"+id;
        System.out.print(filePath);
        File destFile = new File(filePath);
        try {
            ImageIO.write(i, "png", destFile);
        } catch (IOException ex) {
            Logger.getLogger(CSVService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public BufferedImage getImage(String id) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("src/data/"+id)); // eventually C:\\ImageTest\\pic2.jpg
            return img;
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
