package cn.edu.nju.gyue.wxbackend.tool;

import org.springframework.stereotype.Service;

@Service
public class CheckUtil {
    /**
     * 验证是否有空值的参数，只要有一个，就返回true
     *
     * @param args
     * @return true
     */
    public static boolean checkNulls(String... args) {

        if (args.length == 0) {
            return true;
        }
        //
        for (String str : args) {
            if (str.isEmpty()||str == null) {
                return true;
            }
        }
        return false;
    }
}
