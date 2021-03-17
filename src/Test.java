public class Test {
    public static void main(String[] args)
    {
        System.out.println(ResultProcess("hello hello world mina-san"));
    }
    public static String ResultProcess(String str)
    {
        String[] strArr = str.split(" ");
        String result = " ";

        for(int i = 0; i < strArr.length; i++)
        {
            if(Count(strArr[i], str) == 1)
            {
                result += strArr[i] + " ";
            }
        }
        return result;
    }

    public static int Count(String item, String str)
    {
        int result = 0;
        String[] strArr = str.split(" ");

        for (int i = 0; i < strArr.length; i++)
        {
            if(item.equalsIgnoreCase(strArr[i]))
            {
                result = result + 1;
            }
        }
        return  result;
    }
}
