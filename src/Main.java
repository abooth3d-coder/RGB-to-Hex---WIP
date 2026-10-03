import java.util.*;
public class Main
{
    private static final Scanner SCANNER = new Scanner(System.in);
    private static BinaryConvert binaryConvert;
    private static RgbInput rgbInput;

    public static void main(String[] arg)
    {
        System.out.println("Welcome To RGB Convertor \nPlease enter a red color value:");
        int red = SCANNER.nextInt();
        System.out.println("Please enter a green color value:");
        int green = SCANNER.nextInt();
        System.out.println("Please enter a blue color value:");
        int blue = SCANNER.nextInt();
        rgbInput = new RgbInput(red, green, blue);
        binaryConvert = new BinaryConvert();
        HexConversion hexConversion = new HexConversion();

    }

    public static RgbInput getRgbInput()
    {
        return rgbInput;
    }

    public static BinaryConvert getBinaryConvert()
    {
        return binaryConvert;
    }
}
