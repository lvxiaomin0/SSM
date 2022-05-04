public class KMPAlogrithm {

    public static void main(String[] args) {
        String str1 ="BBC ABCDAB ABCDABCDABDE";
        String str2 ="ABCDABD";
        //获取到一个字符串（字串）的部分匹配值
        int []next =kmpNext("ABCDABD");//[0,1]
        int result = kmpSerach(str1,str2,next);
        System.out.println("result = "+result);
    }
    //写出kmp搜索算法
    /*
     * str1 原字符串
     * str2 子串
     * next 部分匹配表
     * @return 如果是-1，就是没有匹配到，否则返回第一个匹配的位置
     * */
    public static int kmpSerach(String str1,String str2,int[] next){
        //遍历
        for (int i = 0,j=0; i < str1.length(); i++) {

            //需要处理，当str1.charAt(i) != str2.charAt(j)
            //kmp算法核心点
            while ( j > 0 &&str1.charAt(i) != str2.charAt(j)){
                j = next[j -1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()){
                return i - j - 1;
            }
        }
        return -1;
    }

    public static  int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串是长度为1部分匹配值就是0
        for (int i = 1,j=0; i < dest.length(); i++) {
            //当dest.charAt(i)！=dest.charAt(j)，需要从next[j-1]获取新的j
            //直到发现dest.charAt(i) ==dest.charAt(j)成立时候退出
            //kmp算法核心点
            while ( j > 0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }

            //当这个条件满足时，部分匹配值就加1
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}