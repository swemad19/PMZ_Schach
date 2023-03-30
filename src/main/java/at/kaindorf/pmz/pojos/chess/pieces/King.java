package at.kaindorf.pmz.pojos.chess.pieces;

import at.kaindorf.pmz.bl.Game;
import at.kaindorf.pmz.pojos.chess.Piece;

import java.util.List;

/**
 * @Author Marcus Schweighofer
 * Created on 24.03.2023.
 * Class: King.java
 */

public class King extends Piece {
    public King(Boolean isBlack, Game game) {
        super(isBlack, game);
    }

    @Override
    public List<Integer> getPossibleMoves() {
        return null;
    }
}
