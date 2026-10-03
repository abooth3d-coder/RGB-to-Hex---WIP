/**
 * This class handles the User RGB input values, stores them in an Integer Array and prints the values on the Screen.
 *
 * @author Andrew Michaels
 * @version 17/10/2025
 */
public class RgbInput
{
    private static final int[] RGB_VALUES =  new int[3];

    public RgbInput(int red, int green, int blue) {
        setRgbValues(checkRed(red), checkGreen(green), checkBlue(blue));
        printRgbValues(getRgbValues());

    }

    /**
     *Check whether the red value is in the correct range if not then set red to a default value otherwise
     * return red value unaltered.
     *
     * @param red       represents the red value to check
     * @return red, represents the red value after checking
     */
    private int checkRed(int red) {
        if (red > 255) {
            System.err.println("Red input is invalid, will default to 255");
            red = 255;
        } else if (red < 0) {
            System.err.println("Red input is invalid, will default to 0");
            red = 0;
        }
        return red;
    }

    private int checkGreen(int green) {
        if (green > 255) {
            System.err.println("Green input is invalid, will default to 255");
            green = 255;
        } else if (green < 0) {
            System.err.println("Green input is invalid, will default to 0");
            green = 0;
        }
        return green;
    }

    private int checkBlue(int blue) {
        if (blue > 255) {
            System.err.println("Blue input is invalid, will default to 255");
            blue = 255;
        } else if (blue < 0) {
            System.err.println("BLue input is invalid, will default to 0");
            blue = 0;
        }
        return blue;
    }

    public int[] getRgbValues() {
        return RGB_VALUES;
    }

    public void setRgbValues(int red, int green, int blue) {
        RGB_VALUES[0] = red;
        RGB_VALUES[1] = green;
        RGB_VALUES[2] = blue;
    }

    /**
     * This method prints the RGB values provided by the user.
     * @param rgbValues An int Array that represents RGB values.
     */
    private void printRgbValues(int[] rgbValues) {
        int redValue = rgbValues[0];
        int greenValue = rgbValues[1];
        int blueValue = rgbValues[2];
        System.out.printf("\n\nRed:%2d%nGreen:%2d%nBlue:%2d%n%n", redValue, greenValue, blueValue);
    }
}
