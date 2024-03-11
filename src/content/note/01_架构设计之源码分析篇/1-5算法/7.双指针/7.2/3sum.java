class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numbers == null || numbers.length == 0) {   
            return result;
        }
        //nlog(n)
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                if (numbers[i] + numbers[left] + numbers[right] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    left++;
                    right--;
                    result.add(list);
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (numbers[i] + numbers[left] + numbers[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}