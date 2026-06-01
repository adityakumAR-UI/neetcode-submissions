class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int[] vis = new int[n];

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (vis[i] == 1) continue;

            ArrayList<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            vis[i] = 1;

            HashMap<Character, Integer> map = new HashMap<>();

            for (int h = 0; h < strs[i].length(); h++) {
                map.put(strs[i].charAt(h),
                        map.getOrDefault(strs[i].charAt(h), 0) + 1);
            }

            for (int j = i + 1; j < n; j++) {

                if (vis[j] == 1) continue;

                if (strs[j].length() != strs[i].length())
                    continue;

                HashMap<Character, Integer> mapp = new HashMap<>();

                for (int h = 0; h < strs[j].length(); h++) {
                    mapp.put(strs[j].charAt(h),
                             mapp.getOrDefault(strs[j].charAt(h), 0) + 1);
                }

                boolean flag = map.size() == mapp.size();

                for (Character c : map.keySet()) {
                    if (!map.get(c).equals(mapp.get(c))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp.add(strs[j]);
                    vis[j] = 1;
                }
            }

            arr.add(temp);
        }

        return arr;
    }
}