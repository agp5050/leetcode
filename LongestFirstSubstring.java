public class LongestFirstSubstring {
    public static void main(String[] args) {
        LongestFirstSubstring longestFirstSubstring = new LongestFirstSubstring();
        int abcabcbb = longestFirstSubstring.lengthOfLongestSubstring("alqebriavxoo");
        System.out.println(abcabcbb);
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max=0;
        for (int i=0;i<s.length();++i){
            String tmpSub="";
            int step=0;
            while (true){
                if (i+step >= s.length()){
                    break;
                }
                if (tmpSub.contains(chars[i+step]+"")){
                    break;
                }else {
                    tmpSub=tmpSub+chars[i+step];
                }
                ++step;

            }
            if (tmpSub.length()>max){
                max=tmpSub.length();
            }
        }
        return max;

    }
}
