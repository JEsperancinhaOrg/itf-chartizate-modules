package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class ChartizateManagerBuilderImpl
        extends ChartizateManagerBuilderAbstract<Color, Font, BufferedImage> {

    private int densityPercentage;
    private int rangePercentage;

    private String fontName;
    private ChartizateDistributionType distributionType;
    private String destinationImagePath;
    private InputStream imageFullStream;

    @Override
    public ChartizateImageManagerImpl createImageManager(
            final InputStream imageFullStream) throws IOException {
        return new ChartizateImageManagerImpl(imageFullStream, destinationImagePath);
    }

    @Override
    public ChartizateEncodingManager<Font> createEncodingManager(final Character.UnicodeBlock block) {
        return new ChartizateEncodingManagerImpl(block, fontManager);
    }

    @Override
    public ChartizateFontManager<Font> createFontManager(final String fontName, final int fontSize) {
        return new ChartizateFontManagerImpl(fontName, fontSize);
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> backgroundColor(Color backgroundColor) {
        this.withBackground(backgroundColor);
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> densityPercentage(int densityPercentage) {
        this.densityPercentage = densityPercentage;
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> rangePercentage(int rangePercentage) {
        this.rangePercentage = rangePercentage;
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> distributionType(ChartizateDistributionType distributionType) {
        this.distributionType = distributionType;
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> fontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> fontSize(int fontSize) {
        this.withFontManager(this.fontName, fontSize);
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> block(Character.UnicodeBlock block) {
        this.withEncodingManager(block);
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> imageFullStream(InputStream imageFullStream) throws IOException {
        this.imageFullStream = imageFullStream;
        return this;
    }

    @Override
    public ChartizateManagerBuilder<Color, Font, BufferedImage> destinationImagePath(String destinationImagePath) {
        this.destinationImagePath = destinationImagePath;
        return this;
    }

    @Override
    public ChartizateManager<Color, Font, BufferedImage> build() throws IOException {
        this.withDistribution(this.distributionType, this.densityPercentage, this.rangePercentage);
        this.withDestinationPath(destinationImagePath);
        this.withImageManager(imageFullStream);
        this.withChartizateBoard();
        return ChartizateManagerImpl.<Color, Font, BufferedImage>builder()
                .chartizateBoard(super.chartizateBoard)
                .fontManager(this.fontManager)
                .background(this.background)
                .distribution(this.distribution)
                .encodingManager(this.encodingManager)
                .imageManager(this.imageManager)
                .destinationImagePath(this.destinationImagePath)
                .build();
    }
}