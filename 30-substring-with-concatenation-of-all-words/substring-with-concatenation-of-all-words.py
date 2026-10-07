from collections import Counter

class Solution(object):
    def findSubstring(self, s, words):
        if not s or not words:
            return []

        word_len = len(words[0])
        num_words = len(words)
        total_len = word_len * num_words

        word_count = Counter(words)
        result = []

        # hum word_len alag alag starting se check karenge
        for i in range(word_len):
            left = i
            curr_count = Counter()
            count = 0

            for j in range(i, len(s) - word_len + 1, word_len):
                word = s[j:j+word_len]

                if word in word_count:
                    curr_count[word] += 1
                    count += 1

                    # agar zyada ho gaya toh left se hatana hai
                    while curr_count[word] > word_count[word]:
                        left_word = s[left:left+word_len]
                        curr_count[left_word] -= 1
                        count -= 1
                        left += word_len

                    # agar saare words mil gaye
                    if count == num_words:
                        result.append(left)
                else:
                    # galat word mila toh reset
                    curr_count.clear()
                    count = 0
                    left = j + word_len

        return result