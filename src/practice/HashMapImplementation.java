package practice;

import java.util.Arrays;

public class HashMapImplementation<K, V> {
  public static class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next;
    Node(K key, V value){
      this.key = key;
      this.value = value;
    }
    public K getKey(){
      return key;
    }
    public V getValue(){
      return value;
    }
    public void setValue(V value){
      this.value = value;
    }
  }

  public int size;
  private float loadFactor;
  private Node<K, V>[] array;
  private static final int DEFAULT_CAPACITY = 16;
  private static final float DEFAULT_LOAD_FACTOR = 0.75f;
  private static final int SCALE_FACTOR = 2;

  public HashMapImplementation(){
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }
  public HashMapImplementation(int cap, float loadFactor){
    if (cap <= 0){
      throw new IllegalArgumentException("cap cannot be <= 0!");
    }
    this.size = 0;
    this.loadFactor = loadFactor;
    this.array = (Node<K, V>[]) (new Node[cap]);
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public void clear(){
    Arrays.fill(this.array, null);
    size = 0;
  }
  public boolean containsKey(K key){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    while (node != null){
      if (equalsKey(node.getKey(), key)){
        return true;
      }
      node = node.next;
    }
    return false;
  }
  private boolean equalsKey(K k1, K k2){
    return k1 == k2 || k1 != null && k1.equals(k2);
  }
  private int getIndex(K key){
    return myHashFunction(key) % array.length;
  }
  private int myHashFunction(K key){
    return key.hashCode() & 0X7FFFFFFF;
  }


  public boolean containsValue(V value){
    if (isEmpty()){
      return false;
    }
    for (Node<K, V> node : array){
      while (node != null){
        if (node.value.equals(value)){
          return true;
        }
        node = node.next;
      }
    }
    return false;
  }
  public V get(K key){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    while (node != null){
      if (equalsKey(node.getKey(), key)){
        return node.getValue();
      }
      node = node.next;
    }
    return null;
  }
  public V put(K key, V value){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    while (node != null){
      if (equalsKey(node.getKey(), key)){
        V oldValue = node.getValue();
        node.setValue(value);
        return oldValue;
      }
      node = node.next;
    }
    Node<K, V> newNode = new Node<>(key, value);
    newNode.next = node;
    array[index] = newNode;
    size++;
    if (needRehashing()){
      rehashing();
    }
    return null;
  }
  private boolean needRehashing(){
    float currentRatio = (0.0f + size) / array.length;
    return currentRatio >= loadFactor;
  }
  private void rehashing(){
    Node<K, V>[] oldArray = array;
    array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
    for (Node<K, V> node : oldArray){
      while (node != null){
        int index = getIndex(node.key);
        Node<K, V> next = node.next;
        node.next = null;
        array[index] = node;
        node = next;
      }
    }
  }
  public V remove(K key){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    Node<K, V> prev = null;
    while (node != null){
      if (equalsKey(node.key, key)){
        if (prev != null){
          prev.next = node.next;
        }
        else {
          array[index] = node.next;
        }
        return node.value;
      }
      prev = node;
      node = node.next;
    }
    return null;
  }
}

