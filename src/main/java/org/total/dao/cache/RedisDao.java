package org.total.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.total.entity.HotSale;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisDao {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    private JedisPool jedisPool;
    public RedisDao(String ip,int port){
        jedisPool=new JedisPool(ip,port);
    }
    private RuntimeSchema<HotSale> schema= RuntimeSchema.createFrom(HotSale.class);
    public HotSale getHotSale(long Id){
        try{
            Jedis jedis=jedisPool.getResource();
            try{
              String key="HotSale:"+Id;

             byte[] bytes= jedis.get(key.getBytes());
             if(bytes!=null)
             {
                 HotSale hotSale=schema.newMessage();
                 /*
                 反序列化
                  */
                 ProtostuffIOUtil.mergeFrom(bytes,hotSale,schema);
                 return hotSale;
             }
            }finally {
                jedis.close();
            }

        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return null;
    }
    public String putHotSale(HotSale hotSale) {
        // set Object(Seckill) => 序列化 =》byte[]
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "HotSale:"+hotSale.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(hotSale,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存超时
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);

                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

}
