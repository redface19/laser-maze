package lasermaze.model.piece;

public class PieceProperties {

    private Playable playable;
    private Reflectable reflectable;
    private Shootable shootable;
    private Penetable penetable;

    private PieceProperties(PiecesPropertiesBuilder piecesPropertiesBuilder) {
        this.playable = piecesPropertiesBuilder.playable;
        this.reflectable = piecesPropertiesBuilder.reflectable;
        this.shootable = piecesPropertiesBuilder.shootable;
        this.penetable = piecesPropertiesBuilder.penetable;
    }

    public void inject(Playable playable, Reflectable reflectable, Shootable shootable, Penetable penetable) {
        playable = this.playable;
        reflectable = this.reflectable;
        shootable = this.shootable;
        penetable = this.penetable;
    }

    public static class PiecesPropertiesBuilder {
        private Playable playable;
        private Reflectable reflectable;
        private Shootable shootable;
        private Penetable penetable;

        public PiecesPropertiesBuilder(Playable playable) {
            this.playable = playable;
        }

        public PiecesPropertiesBuilder applyReflectable(Reflectable reflectable) {
            this.reflectable = reflectable;
            return this;
        }

        public PiecesPropertiesBuilder applyShootable(Shootable shootable) {
            this.shootable = shootable;
            return this;
        }

        public PiecesPropertiesBuilder applyPenetable(Penetable penetable) {
            this.penetable = penetable;
            return this;
        }

        public PieceProperties build() {
            return new PieceProperties(this);
        }
    }
}
