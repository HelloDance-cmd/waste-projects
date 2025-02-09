#include <bits/stdc++.h>

// class Solution {
// public:
//     int removeDuplicates(std::vector<int>& nums) {
//         std::unordered_map<std::vector<int>::iterator, bool> mp;
//         for(std::vector<int>::iterator iter = nums.begin(); iter != nums.end(); iter++) {
//             if(mp.count(iter) == 0)
//                 mp.insert(std::pair<std::vector<int>::iterator, bool>(iter, true));
//             else
//                 nums.erase(iter);
//         }

//         return nums.size();
//     }
// };


class Solution {
public:
    int maximumGain(std::string s, int x, int y) {
        char xStr[] = "ab";
        char yStr[] = "ba";
        std::string::size_type xPos;
        std::string::size_type yPos;
        do {
            xPos = s.find(xStr);
            yPos = s.find(yStr);

            if(xPos != std::string::npos) {
                s.erase(xPos, 2);
                x++;
            }
             if(yPos != std::string::npos) {
                s.erase(yPos, 2);
                y++;
             }
     
        } while(xPos != std::string::npos || yPos != std::string::npos);
     
        return x + y;
    }
};