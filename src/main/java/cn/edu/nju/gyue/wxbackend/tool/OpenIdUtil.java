package cn.edu.nju.gyue.wxbackend.tool;


import cn.edu.nju.gyue.wxbackend.service.OpenIdService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class OpenIdUtil implements OpenIdService{
    @Override
    public String oauth2GetOpenid(String code) {
        String appid="";
        String appsecret="";

        //自己的配置appid
        appid = "wx914d1ab24c6c0025";
        //自己的配置APPSECRET;
        appsecret = "3842e38eafc2ac96e9f3d12d00bd3b38";

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(data);
        //用户的唯一标识（openid）
        String Openid = null;
        Openid = String.valueOf(json.get("openid"));
        //System.out.println(Openid);
        return Openid;
    }
}
