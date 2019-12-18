public class ObfuscateDeobfuscateTool {
    private static String source="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String target="Q5A8ZWS0XEDC6RFVT9GBY4HNU3J2MI1KO7LP";

    public static String obfuscate(String s) {
        return getString(s, source, target);
    }

    public static String deobfuscate(String s) {
        return getString(s, target, source);
    }

    private static String getString(String s, String target, String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = source.indexOf(c);
            stringBuilder.append(target.charAt(index));
        }
        return stringBuilder.toString();
    }

}
