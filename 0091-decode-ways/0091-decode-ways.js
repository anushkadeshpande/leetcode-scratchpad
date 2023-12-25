/**
 * @param {string} s
 * @return {number}
 */
let numPossibilities = (chosenString, digits, memo = {}) => {
  let key = chosenString + "-" + digits.join("");
  if (key in memo) return memo[key];

  if (chosenString.startsWith("0") || parseInt(chosenString) > 26) {
    memo[key] = 0;
    return 0;
  }

  if (digits.length === 0) {
    memo[key] = 1;
    return 1;
  }

  let totalNum = numPossibilities(digits[0], digits.slice(1), memo);

  if (digits.length >= 2)
    totalNum += numPossibilities(digits[0] + digits[1], digits.slice(2), memo);

  memo[key] = totalNum;
  return totalNum;
};

var numDecodings = function (s) {
  // the numbers can only be between 1-26
  // leading 0 ---> 0
  let digits = s.split("");

  if (digits[0] === "0") return 0;
  let num = numPossibilities(digits[0], digits.slice(1));
  if (digits.length >= 2)
    num += numPossibilities(digits[0] + digits[1], digits.slice(2));

  return num;
};