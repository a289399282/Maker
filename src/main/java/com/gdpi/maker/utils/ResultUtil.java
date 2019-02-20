package com.gdpi.maker.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.gdpi.maker.pojo.Result;

@SuppressWarnings("Duplicates")
public class ResultUtil {

    public static Result success(Object object,String msg,long count,int[] navigatepageNums) {
        Result result = new Result();
        result.setCode(1);
        if(msg == null){
            result.setMsg("操作成功");
        }
        result.setMsg(msg);
        //总数目
        result.setCount(count);
        //result.setMsg("操作成功");
        result.setData(object);
        //result.setNavigatepageNums(navigatepageNums);
        return result;
    }
	
//	private static Result result;
    public static Result success(Object object,String msg,long count) {
        Result result = new Result();
        result.setCode(1);
        if(msg == null){
            result.setMsg("操作成功");
        }
        result.setMsg(msg);
        //总数目
        result.setCount(count);
        //result.setMsg("操作成功");
        result.setData(object);
        return result;
    }

    public static Result success(Object object,String msg) {
    	Result result = new Result();
        result.setCode(1);
        if(msg == null){
        	result.setMsg("操作成功");
        }
        result.setMsg(msg);
        
        //result.setMsg("操作成功");
        result.setData(object);
        return result;
    }


    public static Result success() {
        return success(null, null);
        //return success(null);
    }

    public static Result error(Integer code, String msg) {
    	Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result error(String msg) {
    	Result result = new Result();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }
    /**
     * 构造Result
     * <p>Title: build</p>  
     * <p>Description: </p>  
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result build(Integer code, String msg, Object data) {
    	 return new Result(code, msg, null);
    }
    /**
     * 将json结果集转化为TaotaoResult对象
     * 
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return Result.MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = Result.MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = Result.MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = Result.MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return Result.MAPPER.readValue(json, Result.class);
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
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = Result.MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = Result.MAPPER.readValue(data.traverse(),
                        Result.MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
