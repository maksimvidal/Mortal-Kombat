package fighters;

public enum FighterType {
	WARRIOR{
	public Class<? extends AbstractFighter> getTypeClass() {
		return Warrior.class;
	}},
	KNIGHT{
		public Class<? extends AbstractFighter> getTypeClass() {
			return Knight.class;
	}},
	DEFENDER{
		public Class<? extends AbstractFighter> getTypeClass() {
			return Defender.class;
	}},
	VAMPIRE{
		public Class<? extends AbstractFighter> getTypeClass() {
			return Vampire.class;
	}};
	
	public abstract Class<? extends AbstractFighter> getTypeClass();
}
