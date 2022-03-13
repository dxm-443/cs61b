public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque tmp = new ArrayDeque<Character>();
        for (int i =0; i < word.length(); i++){
            tmp.addLast(word.charAt(i));
        }
        return tmp;
    }

    public boolean isPalindrome(){
        return false;
    }
}
