class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int np = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = -1, el2 = -1;

        for (int n : nums) {
            if (cnt1 == 0 && el2 != n) {
                cnt1 = 1;
                el1 = n;
            }
            else if (cnt2 == 0 && el1 != n) {
                cnt2 = 1;
                el2 = n;
            }
            else if (n == el1) cnt1++;
            else if (n == el2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Verification pass
        cnt1 = 0;
        cnt2 = 0;

        for (int n : nums) {
            if (n == el1) cnt1++;
            else if (n == el2) cnt2++;
        }

        if (cnt1 > np / 3) res.add(el1);
        if (cnt2 > np / 3) res.add(el2);

        return res;
    }
}