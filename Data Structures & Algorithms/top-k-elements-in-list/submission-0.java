class Solution {
    class pair{
        int n;
        int f;
        pair(int n,int f){
            this.n=n;
            this.f=f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        ArrayList<pair> arr=new ArrayList<>();
        for(int n : map.keySet()){
            arr.add(new pair(n,map.get(n)));
        }
        Collections.sort(arr,(a,b)-> a.f-b.f);
        int [] res=new int [k];
        int z=0;
        for(int i=0;i<k;i++){
            res[z]=arr.get(arr.size()-1-i).n;
            z++;
        }
        return res;
        
    }
}
