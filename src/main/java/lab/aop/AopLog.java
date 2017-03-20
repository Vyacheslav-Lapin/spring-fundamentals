package lab.aop;

public class AopLog {
    private static StringBuffer value = new StringBuffer();

    static void printf(String pattern, Object... params) {
        append(String.format(pattern, params));
    }
    public static void append(String str){
        value.append(str);
    }

    public static String getStringValue(){
        return value.toString();
    }

    public static void clear(){
        value.delete(0, value.length());
    }
}
