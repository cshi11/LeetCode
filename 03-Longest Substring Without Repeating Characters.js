/** 
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
*/

/**
 * 解法一：暴力，逐个匹配  O(n^3)
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring_1 = function(s) {
    var set = new Set()
    var maxLength = 0
    for(let i in s){
        for(j = i; !set.has(s[j]) && j < s.length; j++){
            set.add(s[j])
        }
        console.log(set)
        maxLength = (set.size > maxLength)? set.size : maxLength
        set.clear()
    }
    return maxLength
};

// var m1 = lengthOfLongestSubstring_1('abcabcabcd')
// console.log(m1)

/**
 * 解法二：滑动窗口
 * s:   --------------
 *         i    j
 * 寻找最大差值的 i 和 j
 * @param {string} 
 * @return {number}
 */
var lengthOfLongestSubstring_2 = function(s) {
    var set = new Set()
    var maxLength = 0
    for(var i = j = 0; j < s.length && i < s.length;){
        if (!set.has(s[j])){
            set.add(s[j++])
            maxLength = (set.size > maxLength)? set.size : maxLength
        }else{
            set.delete(s[i++])
        }
        console.log(set)
    }
    return maxLength
};

var m2 = lengthOfLongestSubstring_2('dvdf')
console.log(m2)