package game.initializers;

import game.parameters.Parameters;

public class BrickAreaDynamic implements BrickArea{
        private double lowerY, upperY, leftX, rightX, width, height;

        public BrickAreaDynamic() {
        }

        public BrickAreaDynamic(double screenWidth, double screenHeight){
            upperY = calculateUpperY(screenHeight);
            lowerY = calculateLowerY(screenHeight);
            leftX = 0.0;
            rightX = screenWidth;
            width = rightX - leftX;
            height = lowerY - upperY;
        }

        public double calculateUpperY(double screenHeight) {
            return screenHeight*0.001;
        }

    public double calculateLowerY(double screenHeight) {
        return screenHeight*0.5;
    }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        public double getLowerY() {
            return lowerY;
        }

        public double getUpperY() {
            return upperY;
        }

        public double getLeftX() {
            return leftX;
        }

        public double getRightX() {
            return rightX;
        }
    }

