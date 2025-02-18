package com.iamhotcenplotz.chapter14.set_;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class HashSetSource_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add("scala");
        hashSet.add("java");
        hashSet.add("python");
        hashSet.add("scala");

        System.out.println(hashSet);
//        1. 执行HashSet()
//        public HashSet() {
//            map = new HashMap<>();
//        }

//        2. 执行 add()
//        public boolean add(E e) {
//            return map.put(e, PRESENT)==null;
//        }

//        3. 执行 put() 该方法会执行hash(key)得到key对应的hash值  算法：(h = key.hashCode()) ^ (h >>> 16)
//        public V put(K key, V value) {
//            return putVal(hash(key), key, value, false, true);
//        }

//        4. 执行
//
//        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//        boolean evict) {
//            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//            if ((tab = table) == null || (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            if ((p = tab[i = (n - 1) & hash]) == null)
//                tab[i] = newNode(hash, key, value, null);
//            else {
//                HashMap.Node<K,V> e; K k;
//                if (p.hash == hash &&
//                        ((k = p.key) == key || (key != null && key.equals(k))))
//                    e = p;
//                else if (p instanceof HashMap.TreeNode)
//                    e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//                else {
//                    for (int binCount = 0; ; ++binCount) {
//                        if ((e = p.next) == null) {
//                            p.next = newNode(hash, key, value, null);
//                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                                treeifyBin(tab, hash);  // 转成红黑树
//                            break;
//                        }
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k))))
//                            break;
//                        p = e;
//                    }
//                }
//                if (e != null) { // existing mapping for key
//                    V oldValue = e.value;
//                    if (!onlyIfAbsent || oldValue == null)
//                        e.value = value;
//                    afterNodeAccess(e);
//                    return oldValue;
//                }
//            }
//            ++modCount;
//            if (++size > threshold)
//                resize();
//            afterNodeInsertion(evict);
//            return null;
//        }
    }
}
