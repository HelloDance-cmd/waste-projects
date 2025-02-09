#include <iostream>
#include <vector>
#include <unordered_map>

std::vector<int> twoSum(std::vector<int> nums, int target) {
	std::unordered_map<int, int> index_map;
	std::vector<int> ans;
	
	for (int i = 0; i < nums.size(); i++) {
		if (index_map.find(target - nums[i]) != index_map.end()) {
			ans.push_back(index_map.find(target - nums[i]));
			ans.push_back(i);
			return ans;
		}

		index_map.insert(std::pair<int, int>(nums[i], i));
	}
	
	ans.push_back(-1);
	ans.push_back(-1);
	
	return ans;
}

int main() {
	std::vector<int> nums{1, 2, 3, 4};
	
	std::vector<int> idxs = twoSum(nums, 5);
	for (int n : idxs) {
		std::cout << n << std::endl;
	}
}
