/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    var expandAroundCenter = function(s, l, r){
        while(l >= 0 && r <= s.length && s[l] === s[r]){
            l--;
            r++;
        }
        return r-l-1
    }

    if(s === null || s.length < 1){
        return ""
    }
    let start = end = 0
    for(let i = 0; i < s.length; i++){
        let len1 = expandAroundCenter(s, i, i)
        let len2 = expandAroundCenter(s, i, i+1)
        let len = (len1 > len2)? len1:len2
        if(len > (end - start)){
            start = i - (len -1)/2
            end = i + len/2
        }
    }
    return s.substring(start, end + 1)
};


var s = "babad"
var ret = longestPalindrome(s)
console.log(ret)