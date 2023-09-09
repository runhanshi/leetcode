package No_400_499;

import java.util.HashMap;
import java.util.LinkedHashSet;

// No.460.LFU Cache
// https://leetcode.com/problems/lfu-cache/
public class No_460 {
    class LFUCache{
        HashMap<Integer, Integer> keyToVal;
        HashMap<Integer, Integer> keyToFreq;
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        int cap;
        int minFreq;

        public LFUCache(int capacity){
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            this.cap = capacity;
            this.minFreq = 0;
        }

        public int get(int key){
            if (!keyToVal.containsKey(key)) return -1;
            increaseFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value){
            if (this.cap <= 0) return;
            if (keyToVal.containsKey(key)){
                increaseFreq(key);
                keyToVal.put(key, value);
                return;
            }
            if (this.cap <= keyToVal.size()){
                removeMinFreqKey();
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, value);
            this.minFreq = 1;
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
        }

        private void increaseFreq(int key){
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            freqToKeys.get(freq).remove(key);
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);
            if (freqToKeys.get(freq).isEmpty()){
                freqToKeys.remove(freq);
                if (freq == this.minFreq) this.minFreq++;
            }
        }

        private void removeMinFreqKey(){
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            int deletedKey = keyList.iterator().next();
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKeys.remove(this.minFreq);
            }
            keyToVal.remove(deletedKey);
            keyToFreq.remove(deletedKey);
        }
    }

}
