package lasermaze.model.piece.common;

import lasermaze.model.piece.properties.*;

public enum PropertyBundle {

    LASER_PROPERTY(new PieceProperties.PiecesPropertiesBuilder(new LaserPiece())
                    .applyShootable(new Shooter()).build()),
    KING_PROPRTY(new PieceProperties.PiecesPropertiesBuilder(new NonLaserPiece()).build()),
    SPLITTER_PROPRTY(new PieceProperties.PiecesPropertiesBuilder(new NonLaserPiece())
                    .applyShootable(new Shooter())
                    .applyReflectable(new DiagonalReflect())
                    .applyPenetable(new Penetrate()).build()),
    TRIANGLE_KNIGHT_PROPERTY(new PieceProperties.PiecesPropertiesBuilder(new NonLaserPiece())
                    .applyReflectable(new DiagonalReflect()).build()),
    SQUARE_KNIGHT_PROPERTY(new PieceProperties.PiecesPropertiesBuilder(new NonLaserPiece())
            .applyReflectable(new HorizontalReflect()).build()),
    DUMMY_PROPERTY(new PieceProperties.PiecesPropertiesBuilder(new CommonPlay()).build());

    private PieceProperties pieceProperties;

    PropertyBundle(PieceProperties pieceProperties) {
        this.pieceProperties = pieceProperties;
    }

    public PieceProperties getProperty() {
        return this.pieceProperties;
    }

}