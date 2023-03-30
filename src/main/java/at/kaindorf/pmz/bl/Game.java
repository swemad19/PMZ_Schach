package at.kaindorf.pmz.bl;

import at.kaindorf.pmz.pojos.chess.FieldState;
import at.kaindorf.pmz.pojos.chess.Piece;
import at.kaindorf.pmz.pojos.chess.pieces.Bishop;
import at.kaindorf.pmz.pojos.chess.pieces.King;
import at.kaindorf.pmz.pojos.chess.pieces.Knight;
import at.kaindorf.pmz.pojos.chess.pieces.Pawn;
import at.kaindorf.pmz.pojos.chess.pieces.Queen;
import at.kaindorf.pmz.pojos.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Marcus Schweighofer
 * Created on 24.03.2023.
 * Class: Game.java
 */

public class Game {
    public static final Integer LINE_SIZE = 8;
    public static final Float DIVISOR_LINE_SIZE = 1 / (float)(LINE_SIZE);
    public static final Integer FIELD_SIZE = LINE_SIZE * LINE_SIZE;

    private final List<Piece> board;

    public Game() {
        this.board = new ArrayList<>();
        //setupBoard();
        setupTesting();
    }

    private void setupBoard() {
        // top row
        board.add(new Rook(    true,    this));
        board.add(new Knight(  true,    this));
        board.add(new Bishop(  true,    this));
        board.add(new Queen(   true,    this));
        board.add(new King(    true,    this));
        board.add(new Bishop(  true,    this));
        board.add(new Knight(  true,    this));
        board.add(new Rook(    true,    this));

        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));
        board.add(new Pawn(    true,    this));

        // null rows
        for (int i = 16; i < 48; i++) {
            board.add(null);
        }

        // bottom row
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));
        board.add(new Pawn(    false,   this));

        board.add(new Rook(    false,   this));
        board.add(new Knight(  false,   this));
        board.add(new Bishop(  false,   this));
        board.add(new Queen(   false,   this));
        board.add(new King(    false,   this));
        board.add(new Bishop(  false,   this));
        board.add(new Knight(  false,   this));
        board.add(new Rook(    false,   this));
    }

    public int getPosition(Piece piece) {
        return board.indexOf(piece);
    }

    public Boolean isFieldInbound(int index) {
        return index >= 0 && index < FIELD_SIZE;
    }

    public FieldState getFieldState(int index) {
        if (board.get(index) == null) {
            return FieldState.NULL;
        }
        Piece piece = board.get(index);
        String fieldState = piece.isBlack() ? "BLACK" : "WHITE";
        if (piece instanceof King) {
            fieldState += "_KING";
        }
        return FieldState.valueOf(fieldState);
    }

    // DEBUG

    private void setupTesting() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            board.add(null);
        }

        board.set(PMZController.TEST_POS1, new Bishop(true, this));
        board.set(PMZController.TEST_POS2, new Rook(false, this));
    }

    public void printField() {
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < LINE_SIZE; j++) {
                if (board.get(i * LINE_SIZE + j) == null) {
                    System.out.print("+");
                } else {
                    System.out.print(board.get(i * LINE_SIZE + j));
                }
                //System.out.print("|");
            }
            System.out.println();
        }
    }

    public Piece getPiece(int index) {
        return board.get(index);
    }
}