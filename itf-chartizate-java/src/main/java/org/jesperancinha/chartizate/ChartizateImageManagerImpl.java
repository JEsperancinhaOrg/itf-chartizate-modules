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
public class ChartizateImageManagerImpl
        extends ChartizateImageManagerAbstract<Color, Font, BufferedImage> {

    private final String outputFile;

    public ChartizateImageManagerImpl(InputStream io, String outputFile) throws IOException {
        srcImage = ChartizateImageImpl.builder().srcImage(ImageIO.read(io)).build();
        this.outputFile = outputFile;
    }

    @Override
    public BufferedImage generateBufferedImage(ChartizateCharacterImg<Color>[][] chartizateCharacterImage, ChartizateFontManager<Font> fontManager) {
        final BufferedImage bImg = new BufferedImage(srcImage.getImageWidth(), srcImage.getImageHeight(), BufferedImage.TYPE_INT_RGB);
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
}
