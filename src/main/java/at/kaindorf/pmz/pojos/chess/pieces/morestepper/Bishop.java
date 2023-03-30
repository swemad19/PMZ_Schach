package at.kaindorf.pmz.pojos.chess.pieces.morestepper;

import at.kaindorf.pmz.bl.Game;
import at.kaindorf.pmz.pojos.chess.FieldState;
import at.kaindorf.pmz.pojos.chess.Piece;
import at.kaindorf.pmz.pojos.chess.pieces.MoreStepPiece;
import at.kaindorf.pmz.pojos.chess.pieces.MoveType;

import java.util.ArrayList;
import java.util.List;

import static at.kaindorf.pmz.bl.Game.*;
import static at.kaindorf.pmz.pojos.chess.pieces.MoveType.*;

/**
 * @Author Marcus Schweighofer
 * Created on 29.03.2023.
 * Class: Bishop.java
 */

public class Bishop extends MoreStepPiece {
    public Bishop(Boolean isBlack, Game game) {
        super(isBlack, game);
    }

    @Override
    public List<Integer> getPossibleMoves() {
        List<Integer> possibleMoves;
        final int position = game.getPosition(this);

        possibleMoves = step(position, LEFT_UP, RIGHT_UP, LEFT_DOWN, RIGHT_DOWN);

        return possibleMoves;
    }
}