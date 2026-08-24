class Solution {

    HashMap<String, Integer> dp = new HashMap<>();

    public int func(ArrayList<Integer> nums) {

        if (nums.size() == 0)
            return 0;

        if (nums.size() == 1)
            return nums.get(0);

        // Current array as memoization key
        String key = nums.toString();

        if (dp.containsKey(key))
            return dp.get(key);

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {

            ArrayList<Integer> tempArr = new ArrayList<>(nums);

            int temp;

            if (i == 0) {

                tempArr.remove(0);

                temp = nums.get(0) * nums.get(1)
                     + func(tempArr);

            }
            else if (i == nums.size() - 1) {

                tempArr.remove(nums.size() - 1);

                temp = nums.get(nums.size() - 1)
                     * nums.get(nums.size() - 2)
                     + func(tempArr);

            }
            else {

                tempArr.remove(i);

                temp = nums.get(i - 1)
                     * nums.get(i)
                     * nums.get(i + 1)
                     + func(tempArr);
            }

            maxi = Math.max(maxi, temp);
        }

        dp.put(key, maxi);

        return maxi;
    }

    public int maxCoins(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int n : nums) {
            arr.add(n);
        }

        return func(arr);
    }
}