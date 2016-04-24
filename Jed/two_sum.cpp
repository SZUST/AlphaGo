/*leetcode:two sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        int size = nums.size();
        map<int,int> mp;

        for(int i =0;i<size;i++){
            mp[nums[i]]=i;
        }
        map<int,int>::iterator it;
        for(int i =0;i<size;i++){
            it = mp.find(target-nums[i]);
            if(it!=mp.end()&&(it->second !=i)){
                res.push_back(i);
                res.push_back(it->second);
                break;
            }
        }
        return res;    
    }
};
