import java.util.ArrayList;

public class BinaryConvert
{
    private final static int HEX_INDEX = 8;
    private final ArrayList<Integer> binaryBits = new ArrayList<>();
    private final int[] rgbToConvert= Main.getRgbInput().getRgbValues();
    private final String[] convertedRgb = new String[Main.getRgbInput().getRgbValues().length];;
    private StringBuilder buildDigits = new StringBuilder();

    public BinaryConvert()
    {
        populateBits();
        binaryConversion(getRgbToConvert());
        printBinaryDigits();
    }

    public String[] getConvertedRgb()
    {
        return convertedRgb;
    }

    public void addConvertedDigits(int index,String digits)
    {
        getConvertedRgb()[index]= digits;
        resetDigits();
    }

    public void addDigits(String digits)
    {
        buildDigits.append(digits);
    }

    public void resetDigits()
    {
        buildDigits = new StringBuilder();
    }

    public String getDigits()
    {
        return buildDigits.toString();
    }

    public int[] getRgbToConvert()
    {
        return rgbToConvert;
    }

    public ArrayList<Integer> getBinaryBits()
    {
        return binaryBits;
    }

    private void populateBits()
    {
        int bit =128;
        binaryBits.add(bit);
        for (int index = 0; index < HEX_INDEX-1; index++)
        {
            bit /= 2;
            binaryBits.add(bit);

        }
    }

    private void printBinaryDigits()
    {
        for (String digits:getConvertedRgb()) {
            System.out.println("Binary digits: " + digits);
        }

    }

    private void binaryConversion(int[] convertRgb)
    {
        if (convertRgb== null || convertRgb.length==0)
        {
            System.err.println("convertRgb is null or empty");
            return;
        }
        int index = 0;
        for(int color : convertRgb)
        {
            int colorSum= color;
            for(int bits:getBinaryBits())
            {
                if(colorSum>=bits)
                {
                   addDigits("1");
                   colorSum-=bits;
                }
                else addDigits("0");
            }
            addConvertedDigits(index,getDigits());
            index++;
        }
    }
}