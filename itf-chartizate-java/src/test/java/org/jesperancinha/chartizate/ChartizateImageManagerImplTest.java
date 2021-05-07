package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImgImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class ChartizateImageManagerImplTest {

    public static Path folder;

    static {
        try {
            folder = Files.createTempDirectory(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File targetFile;

    @BeforeEach
    public void setUp() throws IOException {
        targetFile = Files.createTempDirectory(folder, "tmp").toFile();
    }

    @Test
    public void testGetImageAverageColorBlackGreen() throws Exception {
        final InputStream io = getClass().getResourceAsStream("ChartizateBlackGreen.png");

        final ChartizateImageManager<Color, Font, BufferedImage> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Color imageAverageColor = imageManager.getImageAverageColor();
        assertThat(imageAverageColor.getRed()).isAnyOf(45, 41);
        assertThat(imageAverageColor.getGreen()).isAnyOf(153, 139);
        assertThat(imageAverageColor.getBlue()).isEqualTo(0);
    }

    @Test
    public void testGetImageAverageColorCyanBlack() throws Exception {
        final InputStream io = getClass().getResourceAsStream("ChartizateCyanBlack.png");

        final ChartizateImageManager<Color, Font, BufferedImage> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Color imageAverageColor = imageManager.getImageAverageColor();
        assertThat(imageAverageColor.getRed()).isEqualTo(0);
        assertThat(imageAverageColor.getGreen()).isAnyOf(134, 121);
        assertThat(imageAverageColor.getBlue()).isAnyOf(134, 121);
    }

    @Test
    public void testGetPartAverageColorCyanBlack00() throws Exception {
        final InputStream io = getClass().getResourceAsStream("ChartizateCyanBlack.png");

        final ChartizateImageManager<Color, Font, BufferedImage> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Color partAverageColor = imageManager.getPartAverageColor(IntStream.range(0, 10), IntStream.range(0, 10));

        assertThat(partAverageColor.getRed()).isEqualTo(0);
        assertThat(partAverageColor.getGreen()).isAnyOf(191, 163);
        assertThat(partAverageColor.getBlue()).isAnyOf(191, 163);

    }

    @Test
    public void testGetPartAverageColorCyanBlack10() throws Exception {
        final InputStream io = getClass().getResourceAsStream("ChartizateCyanBlack.png");

        final ChartizateImageManager<Color, Font, BufferedImage> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Color partAverageColor = imageManager.getPartAverageColor(IntStream.range(10, 19), IntStream.range(0, 10));
        assertThat(partAverageColor.getRed()).isEqualTo(0);
        assertThat(partAverageColor.getGreen()).isAnyOf(70, 62);
        assertThat(partAverageColor.getBlue()).isAnyOf(70, 62);
    }

    @Test
    public void testSaveImage() throws Exception {
        final InputStream io = getClass().getResourceAsStream("ChartizateCyanBlack.png");
        final ChartizateImageManager<Color, Font, BufferedImage> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());
        final ChartizateCharacterImg<Color>[][] chartizateCharacterImgs = new ChartizateCharacterImg[2][];
        chartizateCharacterImgs[0] = new ChartizateCharacterImg[]{
                new ChartizateCharacterImgImpl<>(Color.GREEN, Color.RED, 10, 'A'),
                new ChartizateCharacterImgImpl<>(Color.RED, Color.BLACK, 10, 'B')
        };
        chartizateCharacterImgs[1] = new ChartizateCharacterImg[]{
                new ChartizateCharacterImgImpl<>(Color.BLUE, Color.YELLOW, 10, 'C'),
                new ChartizateCharacterImgImpl<>(Color.YELLOW, Color.GREEN, 10, 'D')
        };
        final ChartizateFontManagerAbstract<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);

        assertDoesNotThrow(() -> {
            final BufferedImage bufferedImage = imageManager.generateBufferedImage(chartizateCharacterImgs, fontManager);
            imageManager.saveBitmap(bufferedImage);
        });
    }
}
