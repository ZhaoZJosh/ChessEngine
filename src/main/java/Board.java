public class Board {
    //bitboard vars
    private long wPawns;
    private long wKnights;
    private long wBishops;
    private long wRooks;
    private long wQueens;
    private long wKing;
    private long bPawns;
    private long bKnights;
    private long bBishops;
    private long bRooks;
    private long bQueens;
    private long bKing;

    public Board() {
        wPawns = 0x000000000000FF00L;
        wKnights = 0x0000000000000042L;
        wBishops = 0x0000000000000024L;
        wRooks = 0x0000000000000081L;
        wQueens = 0x0000000000000010L;
        wKing = 0x0000000000000008L;
        bPawns = 0x00FF000000000000L;
        bKnights = 0x4200000000000000L;
        bBishops = 0x2400000000000000L;
        bRooks = 0x8100000000000000L;
        bQueens = 0x1000000000000000L;
        bKing = 0x0800000000000000L;
    }

    public Board(long[] bitboards) {
        wPawns = bitboards[0];
        wKnights = bitboards[1];
        wBishops = bitboards[2];
        wRooks = bitboards[3];
        wQueens = bitboards[4];
        wKing = bitboards[5];
        bPawns = bitboards[6];
        bKnights = bitboards[7];
        bBishops = bitboards[8];
        bRooks = bitboards[9];
        bQueens = bitboards[10];
        bKing = bitboards[11];
    }

    public long getWPawns() {
        return wPawns;
    }

    public long getWKnights() {
        return wKnights;
    }

    public long getWBishops() {
        return wBishops;
    }

    public long getWRooks() {
        return wRooks;
    }

    public long getWQueens() {
        return wQueens;
    }

    public long getWKing() {
        return wKing;
    }

    public long getBPawns() {
        return bPawns;
    }

    public long getBKnights() {
        return bKnights;
    }

    public long getBBishops() {
        return bBishops;
    }

    public long getBRooks() {
        return bRooks;
    }

    public long getBQueens() {
        return bQueens;
    }

    public long getBKing() {
        return bKing;
    }

    public enum PieceType {
        BLACK_PAWN, BLACK_KNIGHT, BLACK_BISHOP, BLACK_ROOK, BLACK_QUEEN, BLACK_KING,
        WHITE_PAWN, WHITE_KNIGHT, WHITE_BISHOP, WHITE_ROOK, WHITE_QUEEN, WHITE_KING
    }

    public PieceType getPieceOnSquare(int row, int col) {
        long squareMask = 1L << (row * 8 + col);
        if ((wPawns & squareMask) != 0) return PieceType.WHITE_PAWN;
        if ((wKnights & squareMask) != 0) return PieceType.WHITE_KNIGHT;
        if ((wBishops & squareMask) != 0) return PieceType.WHITE_BISHOP;
        if ((wRooks & squareMask) != 0) return PieceType.WHITE_ROOK;
        if ((wQueens & squareMask) != 0) return PieceType.WHITE_QUEEN;
        if ((wKing & squareMask) != 0) return PieceType.WHITE_KING;
        if ((bPawns & squareMask) != 0) return PieceType.BLACK_PAWN;
        if ((bKnights & squareMask) != 0) return PieceType.BLACK_KNIGHT;
        if ((bBishops & squareMask) != 0) return PieceType.BLACK_BISHOP;
        if ((bRooks & squareMask) != 0) return PieceType.BLACK_ROOK;
        if ((bQueens & squareMask) != 0) return PieceType.BLACK_QUEEN;
        if ((bKing & squareMask) != 0) return PieceType.BLACK_KING;
        return null;
    }
}