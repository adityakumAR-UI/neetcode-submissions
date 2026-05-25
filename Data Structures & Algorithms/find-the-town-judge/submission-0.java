class Solution {
    // class pair{
    //     int row;
    //     int col;
    //     pair(int f,int s){
    //         this.row=f;
    //         this.col=s;
    //     }

    // }
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer> >  arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<trust.length;i++){
            arr.get(trust[i][1]-1).add(trust[i][0]-1);
        }
        int index=0;
        boolean flag=false;
        for(int j=0;j<arr.size();j++){
            if(arr.get(j).size()==n-1) {
                index=j+1;
                flag=true;
                break;
            }
        }

        for(int i=0;i<trust.length;i++){
            if(trust[i][0]==index) return -1;

        }
        if(flag) return index;
        return -1;

        
    }
}