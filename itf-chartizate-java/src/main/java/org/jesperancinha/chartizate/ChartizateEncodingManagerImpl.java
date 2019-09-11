package org.jesperancinha.chartizate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Character.UnicodeBlock;

public class ChartizateEncodingManagerImpl extends ChartizateEncodingManagerAbstract<Font> {
    ChartizateEncodingManagerImpl(UnicodeBlock block, ChartizateFontManager<Font> fontManager) {
        super(block, fontManager);
    }

    public int getCharacterFullness(Character character) {
        Font font = fontManager.getFont();
        FontMetrics metrics = new JLabel().getFontMetrics(font);
        int width = Math.abs(metrics.stringWidth(character.toString()));
        int height = metrics.getMaxAscent();
        if (width > 0) {
            final BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            final Graphics2D g2d = bi.createGraphics();
            g2d.setFont(font);
            g2d.setColor(Color.black);
            g2d.drawString(character.toString(), 0, height);
            g2d.dispose();
            double total = getMaximumHeight() * width;
            double fullNess = 0;
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    fullNess += bi.getRGB(i, j) != 0 ? 1d : 0d;
                }
            }
            return computeFullness(fullNess, total);
        } else {
            return -1;
        }
    }

    protected int getMaximumHeight() {
        return maximumHeight;
    }

    @Override
    public Character[] getCharacters() {
        return characters;
    }
}