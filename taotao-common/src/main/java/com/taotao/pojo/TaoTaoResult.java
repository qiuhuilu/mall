package com.taotao.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 自定义响应结构
 * Created by qiuhl on 2017/6/30.
 */
public class TaoTaoResult {

    //定义Jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应数据
    private Object data;

    public TaoTaoResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public TaoTaoResult(Object data){
        this.status = TaoTaoStatusType.OK;
        this.msg = "OK";
        this.data = data;
    }

    public static TaoTaoResult build(Integer status, String msg, Object data){
        return new TaoTaoResult(status, msg, data);
    }

    public static TaoTaoResult build(Integer status, String msg){
        return new TaoTaoResult(status, msg, null);
    }

    //正确的返回，无data内容
    public static TaoTaoResult ok(){
        return new TaoTaoResult(null);
    }

    //正确的返回体
    public static TaoTaoResult ok(Object data){
        return new TaoTaoResult(data);
    }

    /**将json结果转化为TaoTaoResult对象
     * @param jsonData  json数据
     * @param clazz  TaoTaoResult中的Object类型
     * @return
     */
    public static TaoTaoResult formatToPojo(String jsonData, Class<?> clazz){
        try {
            if (null == clazz) {
                return MAPPER.readValue(jsonData, TaoTaoResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (null != clazz){
                if(data.isObject()){
                    obj = MAPPER.readValues(data.traverse(), clazz);
                }else if(data.isTextual()){
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static TaoTaoResult format(String json) {
        try {
            return MAPPER.readValue(json, TaoTaoResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static TaoTaoResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
