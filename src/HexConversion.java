import java.util.TreeMap;
public class HexConversion
{
    private static final int HEX_TABLE_SIZE = 16;
    private final TreeMap<String,String> hexTable;
    private final String[]binaryDigits;
    private String hexString;

    public HexConversion()
    {
      hexTable = new TreeMap<>();
      binaryDigits = Main.getBinaryConvert().getConvertedRgb();
      populateHexTable();
      convertHex(refactoringString());
      printHexString();
    }

    public TreeMap<String,String> getHexTable()
    {
        return hexTable;
    }

    public String[] getBinaryDigits()
    {
        return binaryDigits;
    }

    private void clear()
    {
        hexTable.clear();
    }

    public String getHexString()
    {
        return hexString;
    }

    public void buildHexString(String hexDigit)
    {
        StringBuilder hexString = new StringBuilder();
        hexString.append(getHexString());
        hexString.append(hexDigit);
    }

    private void populateHexTable()
    {
        clear();
        hexTable.put("0000","0");
        hexTable.put("0001","1");
        hexTable.put("0010","2");
        hexTable.put("0011","3");
        hexTable.put("0100","4");
        hexTable.put("0101","5");
        hexTable.put("0110","6");
        hexTable.put("0111","7");
        hexTable.put("1000","8");
        hexTable.put("1001","9");
        hexTable.put("1010","A");
        hexTable.put("1011","B");
        hexTable.put("1100","C");
        hexTable.put("1101","D");
        hexTable.put("1110","E");
        hexTable.put("1111","F");
    }

    private String[] refactoringString()
    {
        String[] refactoringString = new String[6];
        String[] toBeRefactored = binaryDigits;
        int arrayIndex = 0;
        for(int colorIndex = 0;colorIndex<toBeRefactored.length;colorIndex++)
        {
            for(int index = 0; index < 2; index++)
            {
                StringBuilder tempString = new StringBuilder();
                for(int subIndex = 0 ; subIndex <4;subIndex++)
                {
                    String subString = toBeRefactored[colorIndex];
                    tempString.append(subString.charAt(0));
                    toBeRefactored[colorIndex] = subString.substring(1);
                }
                refactoringString[arrayIndex] = tempString.toString();
                arrayIndex++;
            }
        }
        return refactoringString;
    }

    private void convertHex(String[] refactoredString)
    {
        for (String string : refactoredString)
        {
            buildHexString(getHexTable().get(string));
        }
    }

    private void printHexString()
    {
        System.out.println("\n\n"+hexString);
    }
}
