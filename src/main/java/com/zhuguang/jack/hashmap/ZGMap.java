package com.zhuguang.jack.hashmap;

public interface ZGMap<K, V> {
    
    //把k v属性包住成对象然后存储到hash表里面来
    public V put(K k, V v);
    
    //根据key获取value
    public V get(K k);
    
    //获取表的长度
    public int size();
    
    //entry对象实际上就是存储到hash表里面的数据对象
    public interface Entry<K, V> {
        //获取key
        public K getKey();
        
        //获取value
        public V getValue();
    }
}
