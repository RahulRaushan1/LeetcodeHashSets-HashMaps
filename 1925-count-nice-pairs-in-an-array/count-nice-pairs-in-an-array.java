//                     Brute Force Methode TC O(n)^2
// class Solution {
//     public int countNicePairs(int[] nums) {
//         int count = 0;
//         int n = nums.length;
//         for(int i =0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]+rev(nums[j])==nums[j]+ rev(nums[i])) count++;
            
//             }
//         }
//         return count;
//     }
//     public int rev(int n){
//         int r=0;
//         while(n!=0){
//             r = r*10 + n%10;
//             n /= 10;
//         }
//         return r;
//     }
// }


//                          Methode 2

class Solution {
    public int countNicePairs(int[] nums){
        int count =0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int ele = nums[i] - rev(nums[i]);
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                count += freq;  // IMPORTANT
                count %= 1000000007;
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        return count;
    }
    public int rev (int n ){
        int r = 0;
        while(n!=0){
             r = r*10 + n%10;
             n /= 10;
        }
        return r;
    }
}
