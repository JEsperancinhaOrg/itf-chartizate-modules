package org.jesperancinha.chartizate;

import lombok.extern.slf4j.Slf4j;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class ChartizateImageManagerImpl extends ChartizateImageManagerAbstract<Color, Font, BufferedImage> {

    private final String outputFile;
    private BufferedImage srcImage;

    public ChartizateImageManagerImpl(InputStream io, String outputFile) throws IOException {
        this.srcImage = ImageIO.read(io);
        this.outputFile = outputFile;
    }

    public int getImageWidth() {
        return this.srcImage.getWidth();
    }

    public int getImageHeight() {
        return this.srcImage.getHeight();
    }

    public BufferedImage generateBufferedImage(ChartizateCharacterImg<Color>[][] chartizateCharacterImage, ChartizateFontManager<Font> fontManager) {
        final BufferedImage bImg = new BufferedImage(getImageWidth(), getImageHeight(), BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2d = bImg.createGraphics();
        final Font font = fontManager.getFont();
        g2d.setFont(font);

        int currentWidth = 0;
        for (int i = 0; i < chartizateCharacterImage.length; i++) {
            int rowLength = chartizateCharacterImage[i].length;
            for (int j = 0; j < rowLength; j++) {
                final ChartizateCharacterImg<?> character = chartizateCharacterImage[i][j];
                g2d.setBackground((Color) character.getBg());
                int x = currentWidth;
                int y = font.getSize() * (i + 1);
                g2d.clearRect(x, y - font.getSize(), character.getWidth(), font.getSize() * 2);
                g2d.setColor((Color) character.getFg());
                g2d.drawString(character.toString(), x, y);
                currentWidth += chartizateCharacterImage[i][j].getWidth();
            }
            currentWidth = 0;
        }
        g2d.dispose();

        return bImg;
    }

    @Override
    public void saveBitmap(BufferedImage bufferedImage) throws IOException {
        ImageIO.write(bufferedImage, "png", new File(this.outputFile));
        log.trace("File {} {}", this.outputFile, " is saved");
    }

    @Override
    public int getImagePixelRGB(int j, int k) {
        return srcImage.getRGB(j, k);
    }

    @Override
    public Color createColor(int mediumApha, int mediumRed, int mediumGreen, int mediumBlue) {
        return new Color(mediumRed, mediumGreen, mediumBlue, mediumApha);
    }

    @Override
    public int getBlue(int rgbPixel) {
        return (rgbPixel) & 0xff;
    }

    @Override
    public int getGreen(int rgbPixel) {
        return (rgbPixel >> 8) & 0xff;
    }

    @Override
    public int getRed(int rgbPixel) {
        return (rgbPixel >> 16) & 0xff;
    }

    @Override
    public int getAlpha(int rgbPixel) {
        return (rgbPixel >> 24) & 0xff;
    }
}
