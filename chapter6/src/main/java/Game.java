public class Game {
    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];

            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10) {
                score += frameScore + itsThrows[ball];
            } else {
                score += frameScore;
            }
        }
        return score;
    }
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
}
