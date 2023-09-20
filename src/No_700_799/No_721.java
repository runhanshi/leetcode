package No_700_799;

import java.util.*;

// No.721.Accounts Merge
// https://leetcode.com/problems/accounts-merge
public class No_721 {
    private int[] p;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        p = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = i;
        }

        // 合并索引
        Map<String, Integer> emailId = new HashMap<>();
        for (int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if (emailId.containsKey(email)){
                    // 为什么用p[find(i)] 不用p[i]? 因为p[i]不一定是根
                    p[find(i)] = find(emailId.get(email));
                } else {
                    emailId.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> map= new HashMap<>();
        for (int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++){
                String email = account.get(j);
                map.computeIfAbsent(find(i), k -> new HashSet()).add(email);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry: map.entrySet()){
            List<String> t = new LinkedList<>();
            t.addAll(entry.getValue());
            Collections.sort(t);
            t.add(0, accounts.get(entry.getKey()).get(0));
            res.add(t);
        }
        return res;
    }


    private int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
