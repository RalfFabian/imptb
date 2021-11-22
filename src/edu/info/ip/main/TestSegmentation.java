package edu.info.ip.main;

import edu.info.ip.util.ThresholdDlg;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class TestSegmentation {

    public static void main(String[] args) {

//        BufferedImage inputImg= loadImage("./test_images/lena_color_512.bmp");
        BufferedImage inputImg= loadImage("./test_images/eight.bmp");
//        BufferedImage inputImg= loadImage("./test_images/lena_gray_512.bmp");
//        BufferedImage inputImg= loadImage("./test_images/logo.png");
        displayImage(inputImg, "Original image");

        BufferedImage grayImg, thresholdImg, contrastImg, negativeImg, maskedImg;

//        grayImg = colorToGray(inputImg,GrayTransforms.GRAY_TRANSFORMS_PAL);
//        displayImage(grayImg, "Gray PAL");

        contrastImg = contrastStretch(inputImg);
        displayImage(contrastImg, "Contrast Stretch");

//        thresholdImg = threshold(contrastImg, 40);
        thresholdImg = applySettingsDlg(contrastImg, new ThresholdDlg());
        displayImage(thresholdImg, "Threshold");

        negativeImg = negative(thresholdImg);
        displayImage(negativeImg, "Negative");

        maskedImg = applyMask(inputImg,negativeImg);
        displayImage(maskedImg,"Apply Mask");

        displayImage(contrastStretch(maskedImg));
    }
}
