package com.kaishengit.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 搜索查询条件工具类
 * Created by Mxia on 2017/3/17.
 */
public class QueryParam {

    //创建查询条件
    private String type; //参数类型  eq ge gt le ...
    private String propertyName; //属性名称
    private Object value; //属性值

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * 通过请求获取查询对象
     * @param request
     * @return
     */
    public static List<QueryParam> builderQueryNameByRequest(HttpServletRequest request) {

        List<QueryParam> list = new ArrayList<>();
        Enumeration<String> enumeration = request.getParameterNames();
        //循环输出
        while(enumeration.hasMoreElements()) {
            //获取参数值
            String paramterName = enumeration.nextElement();
            //获取属性值
            String value = request.getParameter(paramterName);
            try {
                value = new String(value.getBytes("ISO8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new IllegalAccessError("参数异常");
            }
            //分割参数值 获取类型  属性名称 属性值
            if(paramterName.startsWith("q_")&& StringUtils.isNotEmpty(value)) {
                String[] params = paramterName.split("_",4);
                //获取相应的值
                Object v = null;
                String dataType = params[2];
                if("d".equalsIgnoreCase(dataType)) {
                    v = Double.valueOf(value);
                } else if("f".equalsIgnoreCase(dataType)) {
                    v = Float.valueOf(value);
                } else if("l".equalsIgnoreCase(dataType)) {
                    v = Long.valueOf(value);
                } else if("i".equalsIgnoreCase(dataType)) {
                    v = Integer.valueOf(value);
                } else {

                    try {
                        v = new String(value.getBytes("ISO8859-1"),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                //
                QueryParam queryParam = new QueryParam();
                queryParam.setPropertyName(params[3]);
                queryParam.setType(params[1]);
                queryParam.setValue(v);

                list.add(queryParam);
                request.setAttribute(paramterName,v);

            }


        }
        return list;

    }





    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

}
