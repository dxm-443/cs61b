public class OffByN implements CharacterComparator{
    private int gap;

    public OffByN(int n){
        gap = n;
    }

    @Override
    public boolean equalChars(char x, char y){
        if (Math.abs(x - y) == gap){
            return true;
        }
        return false;
    }
}
