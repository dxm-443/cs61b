public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque tmp = new ArrayDeque<Character>();
        for (int i =0; i < word.length(); i++){
            tmp.addLast(word.charAt(i));
        }
        return tmp;
    }

    /**
     * using removelast to reverse the word
     */
    private String word_reverse(Deque d){
        if (d.size() == 0){
            return "";
        }
        String reverse = String.valueOf(d.removeLast());
        return reverse + word_reverse(d);
    }

    public boolean isPalindrome(String word){
        Deque d1 = wordToDeque(word);
        String reverse = word_reverse(d1);
        return word.compareTo(reverse) == 0;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word == null || word.length() <= 1) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < word.length() / 2; i++){
            if (!cc.equalChars(word.charAt(i),word.charAt(word.length() - i - 1))){
                sum += 1;
            }
        }
        return sum == 0;
    }
}
