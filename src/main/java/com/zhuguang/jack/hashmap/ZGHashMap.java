package com.zhuguang.jack.hashmap;

import java.util.ArrayList;
import java.util.List;

public class ZGHashMap<K, V> implements ZGMap<K, V> {
    
    /** 
     * @Fields defaultLength hash 表的默认长度 
     */
    
    private static int defaultLength = 16;
    
    /** 
     * @Fields defaultLoader 负载因子 
     */
    
    private static double defaultLoader = 0.75;
    
    private Entry<K, V>[] table = null;
    
    /** 
     * @Fields size 表里面存储的元素个数 
     */
    
    private int size = 0;
    
    public ZGHashMap(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        
        table = new Entry[defaultLength];
    }
    
    public ZGHashMap() {
        this(defaultLength, defaultLoader);
    }
    
    /* 
     * 需要把k v数据存储到我们的hash表里面
     */
    public V put(K k, V v) {
        
        if (size >= defaultLength * defaultLoader) {
            up2size();
        }
        
        int index = getIndex(k);
        
        Entry<K, V> entry = table[index];
        
        if (entry == null) {
            table[index] = newEntry(k, v, null);
            size++;
        }
        else {
            table[index] = newEntry(k, v, entry);
        }
        return table[index].getValue();
    }
    
    private Entry<K, V> newEntry(K k, V v, Entry<K, V> next) {
        return new Entry(k, v, next);
    }
    
    private void up2size() {
        Entry<K, V>[] newTable = new Entry[2 * defaultLength];
        
    }
    
    private void againHash(Entry<K, V>[] newTable) {
        //1、拿到前面老表的数据
        List<Entry<K, V>> list = new ArrayList<Entry<K, V>>();
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            findEntryByNext(table[i], list);
        }
        
        if (list.size() > 0) {
            size = 0;
            defaultLength = defaultLength * 2;
            table = newTable;
            
            for (Entry<K, V> entry : list) {
                if (entry.next != null) {
                    entry.next = null;
                }
                
                put(entry.getKey(), entry.getValue());
            }
        }
    }
    
    private void findEntryByNext(Entry<K, V> entry, List<Entry<K, V>> list) {
        if (entry != null && entry.next != null) {
            list.add(entry);
            findEntryByNext(entry.next, list);
        }
        else {
            list.add(entry);
        }
    }
    
    /** 
     * @Description getIndex 根据key的 hash值对表的长度取模，得到的index就是表的存储位置 
     * @param @param k
     * @param @return 参数 
     * @return int 返回类型  
     * @throws 
     */
    
    private int getIndex(K k) {
        int m = defaultLength;
        
        int index = k.hashCode() % m;
        
        return index >= 0 ? index : -index;
    }
    
    /* 根据key递归的去找key相等的value值
     */
    public V get(K k) {
        
        int index = getIndex(k);
        
        if (table[index] == null) {
            return null;
        }
        
        return findValueByEqualKey(k, table[index]);
    }
    
    private V findValueByEqualKey(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        }
        else {
            if (entry.next != null) {
                return findValueByEqualKey(k, entry.next);
            }
        }
        return null;
    }
    
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /** 
     * @Description entry对象 
     * @ClassName   Entry 
     * @Date        2017年12月10日 上午11:05:31 
     * @Author      zg_jack
     */
    
    class Entry<K, V> implements ZGMap.Entry<K, V> {
        
        K k;
        
        V v;
        
        Entry<K, V> next;
        
        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
        
        public K getKey() {
            // TODO Auto-generated method stub
            return k;
        }
        
        public V getValue() {
            // TODO Auto-generated method stub
            return v;
        }
        
    }
    
}
