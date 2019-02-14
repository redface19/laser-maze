package lasermaze.model.piece;

public class PieceProperties {

    private Playable playable;
    private Reflectable reflectable;
    private Shootable shootable;

    private PieceProperties(PiecesPropertiesBuilder piecesPropertiesBuilder) {
        this.playable = piecesPropertiesBuilder.playable;
        this.reflectable = piecesPropertiesBuilder.reflectable;
        this.shootable = piecesPropertiesBuilder.shootable;
    }

    public void inject(Playable playable, Reflectable reflectable, Shootable shootable) {
        playable = this.playable;
        reflectable = this.reflectable;
        shootable = this.shootable;
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

        public PieceProperties build() {
            return new PieceProperties(this);
        }
    }
}
